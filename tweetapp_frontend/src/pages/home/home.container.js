import { connect } from 'react-redux';

import Home from './home.component';
import { showLoader, hideLoader, updateUserData } from '../../redux/actions/global.actions';

const mapStateToProps = (state, ownProps) => ({
    global: state.globalReducer,
});

const mapDispatchToProps = dispatch => ({
    showLoader: (value) => dispatch(showLoader(value)),
    updateUserData: (value) => dispatch(updateUserData(value)),
    hideLoader: () => dispatch(hideLoader()),

});

export default connect(
    mapStateToProps,
    mapDispatchToProps
)(Home);