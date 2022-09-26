import React from 'react';
import './custom-nav-bar.styles.css';
import imgTweetLogo from '../../assets/images/logo.png';
import imgProfileEmpty from '../../assets/images/profile.jpeg';
import { pages } from '../../constants/strings';
import 'bootstrap/dist/js/bootstrap.bundle'
import { fetchLoggedInUserDetails } from './custom-nav-bar.helper';

export default function CustomNavBar(props) {

  const onLogout = () => {
    localStorage.clear();
    window.location.reload();
  };
  React.useEffect(() => {
    const initialise = async () => {
      try {
        props.showLoader('Initialising Data');
        let userDetails = await fetchLoggedInUserDetails();
        props.updateUserData(userDetails);
        props.hideLoader();
      } catch (err) {
        console.log(err);
        props.hideLoader();
      }
    };
    initialise();
    // eslint-disable-next-line react-hooks/exhaustive-deps
  }, []);


  const onNavItemClick = target => {
    props.updateSelectedPage(target);
  };

  return (
    <div className="fixed-top">
      <nav className="navbar navbar-expand-lg navbar-light  navbar_bg" style={{ paddingRight: 15 }}>
        <img src={imgTweetLogo} alt="gerdau-logo" height={90} width={90} className="rounded-rectangle" />
        <button className="appName homeLink remove_button_styling" onClick={() => onNavItemClick(pages.HOME)} ></button>
        <p className="appName d-none d-lg-block d-xl-block" style={{ fontSize: 16, marginRight: 20 }}></p>
        <button className="navbar-toggler toggler_icon remove_button_styling" type="button" data-toggle="collapse" data-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
          <span className="navbar-toggler-icon "></span>
        </button>
        <div className="collapse navbar-collapse justify-content-between" id="navbarNavDropdown">
          <ul class="navbar-nav mr-auto">
            <li class="nav-item ">
              <a class="nav-link" style={{ color: "white", backgroundColor: props.selectedPage == pages.HOME && "#3295d1" }} href="#" onClick={() => onNavItemClick(pages.HOME)} >Home</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" style={{ color: "white", backgroundColor: props.selectedPage == pages.MY_TWEETS && "#3295d1" }} href="#" onClick={() => onNavItemClick(pages.MY_TWEETS)} >My Tweets</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" style={{ color: "white", backgroundColor: props.selectedPage == pages.ALL_USERS && "#3295d1" }} href="#" onClick={() => onNavItemClick(pages.ALL_USERS)} >All Users</a>
            </li>
          </ul>
          <button className="nav-link remove_button_styling" style={{ padding: 0, display: "inline-block", }} id="navbarDropdown" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
            <img className="rounded-circle" alt="profile-pic" src={props.global.imageURL || imgProfileEmpty} height={40} width={40} />
          </button>
          <div className="w-md-100">
            <div className="dropdown-menu profile-menu-width" style={{ left: "auto", right: 20, }} id="dd" aria-labelledby="navbarDropdown">
              <p className="dd_sub_heading">{props.global.userData.firstName} {props.global.userData.lastName}</p>
              <p className="dd_sub_heading" style={{ color: "#53626A" }}>@{props.global.userData.loginId}</p>
              <div className="dropdown-divider"></div>
              <button className="dropdown-item dd_page pt-1 pb-1 remove_button_styling" onClick={onLogout}>Log Out</button>
            </div>
          </div>
        </div>
      </nav>
    </div>
  );
}
