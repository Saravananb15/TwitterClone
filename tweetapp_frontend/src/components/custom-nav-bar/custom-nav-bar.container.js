import { connect } from 'react-redux';

import CustomNavBar from './custom-nav-bar.component';
import { showLoader, hideLoader, updateSelectedPage, updateUserData } from '../../redux/actions/global.actions';

const mapStateToProps = (state, ownProps) => ({
    global: state.globalReducer,
    selectedPage: state.globalReducer.selectedPage,
});

const mapDispatchToProps = dispatch => ({
    showLoader: (value) => dispatch(showLoader(value)),
    hideLoader: () => dispatch(hideLoader()),
    updateSelectedPage: (value) => dispatch(updateSelectedPage(value)),
    updateUserData: (value) => dispatch(updateUserData(value)),
});

export default connect(
    mapStateToProps,
    mapDispatchToProps
)(CustomNavBar);