
import React from 'react';
import "./register.styles.css";
import IconButton from '@material-ui/core/IconButton';
import Visibility from '@material-ui/icons/Visibility';
import VisibilityOff from '@material-ui/icons/VisibilityOff';
import InputAdornment from '@material-ui/core/InputAdornment';
import FormControl from '@material-ui/core/FormControl';
import InputLabel from '@material-ui/core/InputLabel';
import imgLogo from "../../assets/images/logo.png";
import Input from '@material-ui/core/Input';
import { pages } from '../../constants/strings';
import TextField from '@material-ui/core/TextField';
import { toast } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';
import { register } from './register.helper';

export default function Register(props) {
    const [values, setValues] = React.useState({
        emailId: '',
        loginId: '',
        firstName: '',
        lastName: '',
        confirmPassword: "",
        password: '',
        contactNumber: "",
        showPassword: false,
        showConfirmPassword: false,
    });
    const [errorValues, setErrorValues] = React.useState({
        emailId: '',
        loginId: '',
        confirmPassword: "",
        contactNumber: "",
    });
    const handleChange = (prop) => (event) => {
        setErrorValues({
            emailId: '',
            loginId: '',
            confirmPassword: "",
            contactNumber: "",
        })
        setValues({ ...values, [prop]: event.target.value });
    };

    const validateInputs = () => {
        let allValid = true;
        let confirmPassword = "";
        let emailId = "";
        let phoneNumber = "";
        if (values.confirmPassword !== values.password) {
            confirmPassword = "Confirm Password does not match with Password"
            allValid = false;
        }
        if (!/^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\.[a-zA-Z0-9-]+)*$/.test(values.emailId)) {
            emailId = "Email id is not valid"
            allValid = false;
        }
        if (values.contactNumber.length != 10) {
            phoneNumber = "Contact Number should be of length 10"
            allValid = false;
        }
        if (!allValid) {
            setErrorValues({ ...errorValues, confirmPassword: confirmPassword, emailId: emailId, contactNumber: phoneNumber })
        }
        return allValid;
    }

    const handleClickShowPassword = () => {
        setValues({ ...values, showPassword: !values.showPassword });
    };
    const handleClickShowConfirmPassword = () => {
        setValues({ ...values, showPassword: !values.showConfirmPassword });
    };
    const handleMouseDownPassword = (event) => {
        event.preventDefault();
    };

    const onRegisterClick = async () => {
        if (validateInputs()) {
            try {
                props.showLoader("Creating User");
                await register(values);
                toast.success("User Registration Sucessfull")
                props.updateSelectedPage(pages.LOGIN)
                props.hideLoader();
            } catch (e) {
                props.hideLoader();
                setErrorValues({ ...errorValues, loginId: "Login Id Already Exists", emailId: "Email Id Already Exists" })
            }
        }
    }
    return (
        <>
            <div className={"d-flex h-100 justify-content-center "}>
                <div style={{ width: "50%", maxWidth: 1000 }}>
                    <div style={{ display: "flex", alignItems: "center", cursor: "pointer" }} onClick={() => { props.updateSelectedPage(pages.LOGIN) }}>
                        <img src={imgLogo} height={50} width={50} />
                    </div>
                    <div style={{ display: "flex", alignItems: "center", marginLeft: 10 }}>
                        <h2 style={{ fontFamily: "Barlow-Bold", marginBottom: 30 }}>Register</h2>
                    </div>
                    <div style={{ marginBottom: 20, display: "flex", flexWrap: "wrap" }}>
                        <FormControl variant="outlined" style={{ paddingLeft: 10, width: 250, marginBottom: 20, marginRight: 20 }}>
                            <InputLabel style={{color: "white" }}htmlFor="standard-adornment-email">First Name</InputLabel>
                            <Input label="Email ID"
                                id="standard-adornment-email"
                                onChange={handleChange('firstName')} />
                        </FormControl>
                        <FormControl style={{color: "white" }}variant="outlined" style={{ paddingLeft: 10, width: 250, marginBottom: 20, marginRight: 20 }}>
                            <InputLabel style={{color: "white" }}htmlFor="standard-adornment-email">Last Name</InputLabel>
                            <Input label="Email ID"
                                id="standard-adornment-email"
                                onChange={handleChange('lastName')} />
                        </FormControl>
                        <FormControl style={{color: "white" }}variant="outlined" style={{ paddingLeft: 10, width: 250, marginBottom: 20, marginRight: 20 }}>
                            <TextField label="Email ID"
                                id="standard-adornment-email"
                                onChange={handleChange('emailId')}
                                error={errorValues.emailId != ""}
                                helperText={errorValues.emailId}
                                color={errorValues.emailId == "" ? "primary" : "secondary"}
                            />
                        </FormControl>
                        <FormControl style={{color: "white" }} variant="outlined" style={{ paddingLeft: 10, width: 250, marginBottom: 20, marginRight: 20 }}>
                            <TextField label="Login ID"
                                id="standard-adornment-email"
                                onChange={handleChange('loginId')}
                                error={errorValues.loginId != ""}
                                helperText={errorValues.loginId}
                                color={errorValues.loginId == "" ? "primary" : "secondary"} />
                        </FormControl>
                        <FormControl variant="outlined" style={{ paddingLeft: 10, width: 250, marginBottom: 20, marginRight: 20 }}>
                            {/* <InputLabel htmlFor="outlined-adornment-amount">Password</InputLabel> */}
                            <TextField label="Password"
                                type={values.showPassword ? 'text' : 'password'}
                                onChange={handleChange('password')}
                                InputProps={{
                                    endAdornment:
                                        <>
                                            <InputAdornment position="end" >
                                                <IconButton style={{color: "white" }}
                                                    aria-label="toggle password visibility"
                                                    onClick={handleClickShowPassword}
                                                    onMouseDown={handleMouseDownPassword}
                                                >
                                                    {values.showPassword ? <Visibility /> : <VisibilityOff />}
                                                </IconButton>
                                            </InputAdornment>
                                        </>
                                }}
                            />
                        </FormControl>
                        <FormControl variant="outlined" style={{ paddingLeft: 10, width: 250, marginRight: 20 ,color: "white"}}>
                            {/* <InputLabel htmlFor="outlined-adornment-amount">Confirm Password</InputLabel> */}
                            <TextField label="Confirm Password"
                                type={values.showPassword ? 'text' : 'password'}
                                onChange={handleChange('confirmPassword')}
                                InputProps={{
                                    endAdornment:
                                        <>
                                            <InputAdornment position="end" >
                                                <IconButton style={{color: "white" }}
                                                    aria-label="toggle password visibility"
                                                    onClick={handleClickShowConfirmPassword}
                                                    onMouseDown={handleMouseDownPassword}
                                                >
                                                    {values.showPassword ? <Visibility /> : <VisibilityOff />}
                                                </IconButton>
                                            </InputAdornment>
                                        </>
                                }}
                                color={errorValues.confirmPassword == "" ? "primary" : "secondary"}
                                error={errorValues.confirmPassword != ""}
                                helperText={errorValues.confirmPassword} />
                        </FormControl>
                        <FormControl style={{color: "white" }}variant="outlined" style={{ paddingLeft: 10, width: 250, marginBottom: 20, marginRight: 20,color: "white" }}>
                            {/* <InputLabel htmlFor="standard-adornment-number">Contact Number</InputLabel> */}
                            <TextField label="Contact Number"
                                id="standard-adornment-number"
                                onChange={handleChange('contactNumber')} type="number"
                                color={errorValues.contactNumber == "" ? "primary" : "secondary"}
                                error={errorValues.contactNumber != ""}
                                helperText={errorValues.contactNumber} />

                        </FormControl>
                    </div>
                    <div>
                        {
                            (values.emailId != "" && values.password != "" && values.confirmPassword != "" && values.contactNumber != "" && values.firstName != "" && values.loginId != "" && values.lastName != "") ?
                                <button style={{ borderWidth: 0, backgroundColor: "aqua", color: "white", width: "100%", padding: 10, borderRadius: 20, marginBottom: 20 }} onClick={onRegisterClick}>Submit</button>
                                : <button style={{ borderWidth: 0, backgroundColor: "aqua", color: "white", width: "100%", padding: 10, borderRadius: 20, marginBottom: 20 }}>SUBMIT</button>
                        }
                    </div>

                </div>
            </div>
        </>
    )

}
