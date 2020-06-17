import React, { useState } from 'react';
import { Form, Button, DatePicker, Input, Modal, Radio, Select, Steps } from 'antd';
import AntdSelect from './AntdSelect'

const FormItem = Form.Item;
const RadioGroup = Radio.Group;
const formLayout = {
  labelCol: {
    span: 7,
  },
  wrapperCol: {
    span: 13,
  },
};

const CreateForm = (props) => {
  const [formVals, setFormVals] = useState({
    stuName: '',
    stuGender: true,
    graderId: '',
  });
  const [form] = Form.useForm();
  const {
    onSubmit: handleCreate,
    onCancel: handleCreateModalVisible,
    createModalVisible,
    values,
  } = props;

  const handleNext = async () => {
    const fieldsValue = await form.validateFields();
    fieldsValue.stuGender = (fieldsValue.stuGender==='0')
    setFormVals({ ...formVals, ...fieldsValue });
    handleCreate({ ...formVals, ...fieldsValue });
    setFormVals({})
  };

  const renderContent = () => {
    return (
      <>
        <FormItem
          name="stuName"
          label="学生姓名"
          rules={[
            {
              required: true,
              message: "请输入学生名称",
            }
          ]}
        >
          <Input placeholder="请输入" />
        </FormItem>
        <FormItem
          name="stuGender"
          label="学生性别"
        >
          <RadioGroup
            style={{
              width: '100%',
            }}
          >
            <Radio value='0'>男</Radio>
            <Radio value='1'>女</Radio>
          </RadioGroup>
        </FormItem>
        <FormItem
          name="graderId"
          label="班级"
          rules={[
            {
              required: true,
              message: "请选择学生班级",
            }
          ]}
        >
          <AntdSelect
            values={formVals}
            onSelect={(sele) => {
              form.setFieldsValue({'graderId':sele})
            }}
          />
        </FormItem>
      </>
    );
  };

  const renderFooter = () => {
    return (
      <>
        <Button onClick={() => handleCreateModalVisible(false, values)}>取消</Button>
        <Button type="primary" onClick={() => handleNext()}>
          完成
        </Button>
      </>
    );
  };

  return (
    <Modal
      width={640}
      bodyStyle={{
        padding: '32px 40px 48px',
      }}
      destroyOnClose
      title="学生添加"
      visible={createModalVisible}
      footer={renderFooter()}
      onCancel={() => handleCreateModalVisible()}
    >
      <Form
        {...formLayout}
        form={form}
        initialValues={{
          stuName: formVals.stuName,
          stuGender: formVals.stuGender?'0':'1'
        }}
      >
        {renderContent()}
      </Form>
    </Modal>
  );
};

export default CreateForm;
