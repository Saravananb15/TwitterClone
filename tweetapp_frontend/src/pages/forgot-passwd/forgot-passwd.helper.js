import { HttpGet, HttpPost } from "../../services/api-services";
import { BASE_URI, FORGOT_PASSWD } from "../../constants/endpoints";

export const forgotPassword = async (email, password) => {
    try {
        let apiUrl = BASE_URI + FORGOT_PASSWD;
        let response = await HttpPost(apiUrl, {
            userDto: {
                loginId: email,
                password: password
            }
        })
        if(response.data.statusMessage == "USER NOT FOUND"){
            throw "User does not exist"
        }
    } catch (e) {
        throw e;
    }
}

