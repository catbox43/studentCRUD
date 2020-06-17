import request from '@/utils/request';

export async function queryGrader(params) {
  return request('/api/grader/list', {
    params,
  }).then(function (response) {
    const resdata = response.data;
    response.total = resdata.total;
    response.data = resdata.records;
    console.log(response);
    return response;
  });
}

export async function addGrader(params) {
  return request('/api/grader/save', {
    method: 'POST',
    data: params,
  });
}

export async function updateGrader(params) {
  return request('/api/grader/update', {
    method: 'POST',
    data: params,
  });
}

export async function removeGrader(params) {
  return request('/api/grader/remove', {
    method: 'POST',
    data: params,
  });
}
