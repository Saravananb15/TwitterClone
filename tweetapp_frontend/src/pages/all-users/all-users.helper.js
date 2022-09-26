import { HttpGet } from "../../services/api-services";
import { BASE_URI, BASE_TWEET_URL, ALL_USERS } from "../../constants/endpoints";

export const fetchAllUsers = async () => {
    try {
        let credentials = "Bearer " + localStorage.getItem("token");
        let apiUrl = BASE_URI + BASE_TWEET_URL + ALL_USERS;
        let headers = {
            "Authorization": credentials
        }
        let response = await HttpGet(apiUrl, {}, headers)
        // let response = {
        //     data: {
        //         "usersDto": [
        //             {
        //                 "loginId": "finny",
        //                 "firstName": "finny",
        //                 "lastName": "gathala",
        //                 "emailId": "finnylaurence@gmail.com",
        //                 "password": "$2a$10$CLWpoE7Z1kBkisoFvAVOgu4MJr/7qDvmRvo/HNGfIF8kWJG4jcM62",
        //                 "contactNumber": "9603340903",
        //                 "loggedIn": true
        //             },
        //             {
        //                 "loginId": "budamkay",
        //                 "firstName": "bud",
        //                 "lastName": "mkay",
        //                 "emailId": "bud@gmail.com",
        //                 "password": "$2a$10$E9tRoQKF7AlEopLCKIebVOtKaHsno5eB3ZkyOMyaYcz9ghnbm/azG",
        //                 "contactNumber": "9999",
        //                 "loggedIn": false
        //             },
        //             {
        //                 "loginId": "fudamkay",
        //                 "firstName": "bud",
        //                 "lastName": "mkay",
        //                 "emailId": "fud@gmail.com",
        //                 "password": "$2a$10$KNJsigty8NaOJBl7NpkHRu8eZBIEiGuI0bq5wXoDGwLusVORJiuW6",
        //                 "contactNumber": "9999",
        //                 "loggedIn": false
        //             },
        //             {
        //                 "loginId": "klaus",
        //                 "firstName": "klaus",
        //                 "lastName": "klaus",
        //                 "emailId": "klaus@gmail.com",
        //                 "password": "$2a$10$1Uoh.7efpGHAy6z5nsV7cOSPduYtMc70c/dn4h06yzMLYz/5ZK.q6",
        //                 "contactNumber": "99999",
        //                 "loggedIn": true
        //             },
        //             {
        //                 "loginId": "mini",
        //                 "firstName": "mini",
        //                 "lastName": "mini",
        //                 "emailId": "mini@gmail.com",
        //                 "password": "$2a$10$CWvGKmSp13NcnzoaSkxhTu4GRNProa2aXPwc2bXl4ya45aD051Cv.",
        //                 "contactNumber": "9999",
        //                 "loggedIn": true
        //             }
        //         ],
        //         "statusMessage": "SUCCESS"
        //     }
        // }

        return response.data.usersDto;
    } catch (e) {
        throw e;
    }
}

