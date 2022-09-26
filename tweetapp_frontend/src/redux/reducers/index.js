import { combineReducers } from 'redux';

import globalReducer from './global.reducer';

const reducers = combineReducers({
  globalReducer,
});

export default reducers;
