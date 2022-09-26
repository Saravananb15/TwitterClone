import { HttpPost } from "../../services/api-services";
import { BASE_URI, REGISTER } from "../../constants/endpoints";

export const register = async (values) => {
    try {
        let apiUrl = BASE_URI + REGISTER;
        await HttpPost(apiUrl, {
            userDto: { 
                loginId: values.loginId,
                password: values.password,
                firstName: values.firstName,
                lastName: values.lastName,
                emailId: values.emailId,
                contactNumber: values.contactNumber
            }
        })
    } catch (e) {
        throw e;
    }
}

