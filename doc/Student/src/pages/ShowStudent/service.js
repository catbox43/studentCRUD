import request from '@/utils/request';

export async function queryStudent(params) {
  return request('/api/student/list', {
    params,
  }).then(function (response) {
    const resdata = response.data;
    response.total = resdata.total;
    response.data = resdata.records;
    console.log(response);
    return response;
  });
}

export async function queryGrader(params) {
  return request('/api/grader/list', {
    params,
  })
}

export async function getGrader() {
  const res = request('/api/student/list', {});
  console.log(res);
}

export async function addStudent(params) {
  return request('/api/student/save', {
    method: 'POST',
    data: params,
  });
}

export async function updateStudent(params) {
  return request('/api/student/update', {
    method: 'POST',
    data: params,
  });
}

export async function removeStudent(params) {
  return request('/api/student/remove', {
    method: 'POST',
    data: params,
  });
}
