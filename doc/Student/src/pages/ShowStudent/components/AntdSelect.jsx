import request from '@/utils/request';
import React from 'react';
import { Select, Spin } from 'antd';

const { Option } = Select;


class AntdSelect extends React.Component {

  constructor(props) {
    super(props);
    const that = this;
    this.state = {
      list: [],
      select: props.values.graderName,
      spinState: false,
    }



    const params = {
      "graderName":'',
      "current":1,
      "size":5,
    }
    request('/api/grader/list', {
      params,
    }).then(function(data) {
      if (data.success){
        that.setState({
          list: data.data.records,
          spinState: false
        })
      }
    })
  }

  handleSearch = async (keywords) => {
    const that = this;
    this.setState({
      list: [],
      spinState: true
    })
    const params = {
      "graderName":keywords,
      "current":1,
      "size":5,
    }
    request('/api/grader/list', {
      params,
    }).then(function(data) {
      if (data.success){
        that.setState({
          list: data.data.records,
          spinState: false
        })
      }
    })
  }

  handleSelect = (sele) => {
    this.setState({
      select : sele
    })
    const {
      onSelect: onSele,
    } = this.props
    this.state.list.map((item) => (
      (item.graderName===sele)?onSele(item.graderId):''
    ))
  }

  render(){
    const { list, select, spinState } = this.state;
    return(
      <Select
        showSearch
        notFoundContent={spinState ? <Spin /> : '暂无数据'}
        filterOption={false}
        onSearch={this.handleSearch}
        value={select}
        onSelect={this.handleSelect}
      >
        {
          list.map((item) => (
            <Option key={item.graderId} value={item.graderName}>{item.graderName}</Option>
          ))
        }
      </Select>
    )
  }
}
export default AntdSelect
