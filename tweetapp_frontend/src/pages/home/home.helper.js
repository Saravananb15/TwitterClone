import { HttpGet, HttpPost } from "../../services/api-services";
import { BASE_URI, BASE_TWEET_URL, ALL_TWEETS, GET_USER } from "../../constants/endpoints";

export const fetchLoggedInUserDetails = async () => {
    try {
        let credentials = "Bearer " + localStorage.getItem("token");
        let apiUrl = BASE_URI + GET_USER + localStorage.getItem("loginId");
        console.log(apiUrl)
        let headers = {
            "Authorization": credentials
        }
        let response = await HttpGet(apiUrl, {}, headers)
      
        return response.data.usersDto[0];
    } catch (e) {
        throw e;
    }
}

export const fetchAllTweets = async () => {
    try {
        let credentials = "Bearer " + localStorage.getItem("token");
        let apiUrl = BASE_URI + BASE_TWEET_URL + ALL_TWEETS;
        let headers = {
            "Authorization": credentials
        }
        let response = await HttpGet(apiUrl, {}, headers)
        
        return response.data.tweetsDto;
    } catch (e) {
        throw e;
    }
}

export const postTweet = async (loginId, tweetMessage) => {
    try {
        let credentials = "Bearer " + localStorage.getItem("token");
        let headers = {
            "Authorization": credentials
        }
        let apiUrl = BASE_URI + BASE_TWEET_URL + "/" + loginId + "/add" ;
        await HttpPost(apiUrl, {
            tweet: {
                tweet: tweetMessage,
            }
        }, headers)
    } catch (e) {
        throw e;
    }
}
export const postReplyTweet = async (data) => {
    try {
        let credentials = "Bearer " + localStorage.getItem("token");
        let headers = {
            "Authorization": credentials
        }

        let apiUrl = BASE_URI + BASE_TWEET_URL + "/reply" ;
        await HttpPost(apiUrl, data, headers)
    } catch (e) {
        throw e;
    }
}

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

