import { connect } from 'react-redux';

import CustomLoader from './custom-loader.component';
import { showLoader, hideLoader, } from '../../redux/actions/global.actions';

const mapStateToProps = (state, ownProps) => ({
    global: state.globalReducer,
});

const mapDispatchToProps = dispatch => ({
    showLoader: (value) => dispatch(showLoader(value)),
    hideLoader: () => dispatch(hideLoader()),
});

export default connect(
    mapStateToProps,
    mapDispatchToProps
)(CustomLoader);