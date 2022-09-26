import { HttpGet, HttpPost, HttpDelete } from "../../services/api-services";
import { BASE_URI, BASE_TWEET_URL } from "../../constants/endpoints";

export const likeTweet = async (data) => {
    try {
        let credentials = "Bearer " + localStorage.getItem("token");
        let headers = {
            "Authorization": credentials
        }
        let apiUrl = BASE_URI + BASE_TWEET_URL + "/like" ;
        await HttpPost(apiUrl, data, headers)
    } catch (e) {
        throw e;
    }

}

export const fetchMyTweets = async (loginId) => {
    try {
        let credentials = "Bearer " + localStorage.getItem("token");
        let apiUrl = BASE_URI + BASE_TWEET_URL + "/" + loginId;
        let headers = {
            "Authorization": credentials
        }
        let response = await HttpGet(apiUrl, {}, headers)
        return response.data.tweetsDto;
    } catch (e) {
        throw e;
    }
}

export const deleteTweet = async (loginId, tweetId) => {
    try {
        let credentials = "Bearer " + localStorage.getItem("token");
        let apiUrl = BASE_URI + BASE_TWEET_URL + "/" + loginId + "/delete/" + tweetId;
        let headers = {
            "Authorization": credentials
        }
       await HttpDelete(apiUrl, {}, headers)
        
    } catch (e) {
        throw e;
    }
}

export const updateTweet = async (data) => {
    try {
        let credentials = "Bearer " + localStorage.getItem("token");
        let apiUrl = BASE_URI + BASE_TWEET_URL + "/update";
        let headers = {
            "Authorization": credentials
        }
       await HttpPost(apiUrl, data, headers)
        
    } catch (e) {
        throw e;
    }
}

