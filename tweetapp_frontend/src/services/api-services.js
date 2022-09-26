import axios from 'axios';

const api = axios.create({
  timeout: 10000,
});

export const HttpGet = async (endPoint, queryParams = {}, headers = {}) => {
  try {
    if (typeof endPoint == 'string') {
      let result = await api.get(endPoint, {
        params: queryParams,
        headers: headers
      });
      return result;
    }
  } catch (error) {
    console.log(error)
    throw JSON.parse(error.request._response).message.data.error.description;
  }
};

export const HttpPost = async (endPoint, body = {}, headers = {}) => {
  try {
    if (typeof endPoint == 'string') {
      let result = await api.post(endPoint, body, {
        headers: headers
      });
      return result;
    }
    throw new Error('Incorrect request');
  } catch (error) {
    console.log('error', error);
    throw error;
  }
};

export const HttpDelete = async (endPoint, body = {}, headers = {}) => {
  try {
    if (typeof endPoint == 'string') {
      let result = await api.delete(endPoint, {
        params: { ...body },
        headers: headers
      });
      return result;
    }
    throw new Error('Incorrect request');
  } catch (error) {
    console.log('error', error);
    throw error;
  }
}
