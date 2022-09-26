import './App.css';
import Login from './pages/login'
import CustomLoader from './components/custom-loader'
import CustomNavBar from './components/custom-nav-bar'
import { Provider, connect } from 'react-redux';
import store from './redux/store';
import ForgotPassword from './pages/forgot-passwd';
import { pages } from './constants/strings';
import Register from './pages/register';
import React from 'react';
import Root from "./pages/root.component.js";
import { ToastContainer } from 'react-toastify';

export default function () {
  return (
    <Provider store={store}>
      <div className="App">
        <AppContainer />
      </div>
      <ToastContainer
        hideProgressBar />
    </Provider>
  );
}

export function App(props) {
  const [isAuthenticated, setIsAuthenticated] = React.useState(false);
  React.useEffect(() => {
    if (localStorage.getItem("isAuthenticated") == "true") {
      setIsAuthenticated(true);
    } else {
      setIsAuthenticated(false);
    }
  }, [localStorage.getItem("isAuthenticated")])

  return (
    <>
      <CustomLoader />
      {
        isAuthenticated ?
          <div style={{ width: "100%", height: "100%", }}>
            <CustomNavBar />
            <Root selectedPage={props.global.selectedPage} />
          </div>
          :
          props.global.selectedPage == pages.LOGIN ?
            <Login /> :
            props.global.selectedPage == pages.FORGOT_PASSWORD ?
              <ForgotPassword />
              :
              <Register />
      }
    </>
  );
}

const mapStateToProps = (state, ownProps) => ({
  global: state.globalReducer,
});
const mapDispatchToProps = (dispatch) => ({

});

export const AppContainer = connect(mapStateToProps, mapDispatchToProps)(App);


