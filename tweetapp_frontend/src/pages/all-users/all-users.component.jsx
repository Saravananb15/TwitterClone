import React, { useRef } from 'react';
import "./all-users.styles.css";
import imgProfileEmpty from '../../assets/images/profile.jpeg';
import imgProfile1 from '../../assets/images/profile-1.png';
import imgProfile2 from '../../assets/images/profile-2.png';
import imgProfile3 from '../../assets/images/profile-3.png';
import imgProfile4 from '../../assets/images/profile-4.jpg';
import imgProfile5 from '../../assets/images/profile-5.png';
import imgEmail from '../../assets/images/email.png';
import imgPhone from '../../assets/images/phone.png';
import { fetchAllUsers } from './all-users.helper';

export default function MyTweets(props) {
    React.useEffect(() => {
        initialise();
        // eslint-disable-next-line react-hooks/exhaustive-deps
    }, [props.global.selectedPage]);
    const [allUsers, setAllUsers] = React.useState([])
    const onTweetClick = () => {

    }
    const initialise = async () => {
        try {
            props.showLoader("Fetching All Users")
            let allUsers = await fetchAllUsers();
            setAllUsers(allUsers);
            props.hideLoader();
        } catch (e) {
            props.hideLoader();
        }
    }
    const generateTweets = () => {

        return allUsers.map((tweet, index) => {
            let imgSrcIndex = index % 5;
            let imgSrc = imgProfileEmpty;
            switch (imgSrcIndex) {
                case 1: imgSrc = imgProfile1;
                    break;
                case 2: imgSrc = imgProfile2;
                    break;
                case 3: imgSrc = imgProfile3;
                    break;
                case 4: imgSrc = imgProfile4;
                    break;
                case 0: imgSrc = imgProfile5;
                    break;

            }

            return (
                <div className="shadow" style={{ width: "60%", marginLeft: "auto", marginRight: "auto", alignItems: "flex-start", display: "flex", flexDirection: "column", borderRadius: 10, marginBottom: 10 }}>
                    <div style={{ alignItems: "flex-start", display: "inline-flex", width: "100%", padding: 20, borderRadius: 10, borderWidth: 1 }}>
                        <img src={imgSrc} className="rounded-circle" height={40} width={40} style={{ marginRight: 20 }} />
                        <div style={{ width: "100%", justifyContent: "flex-start", display: "inline-flex", flexDirection: "column", alignItems: "flex-start" }}>
                            <div style={{ display: "inline-flex", justifyContent: "space-between", width: "100%" }}>
                                <p style={{ fontFamily: "Barlow-SemiBold", fontSize: 16, margin: 0 }}>{tweet.firstName} {tweet.lastName} <span style={{ color: "GrayText", fontFamily: "OpenSans-Regular", fontSize: 12 }}>@{tweet.loginId}</span></p>
                            </div>
                            <div style={{ flexDirection: "row", display: "inline-flex", alignItems: "center", marginTop: 10 }}>
                                <img src={imgEmail} height={20} width={20} style={{ marginRight: 5 }} />
                                <p style={{ marginRight: 10, marginBottom: 0 }}>{tweet.emailId} </p>
                                <img src={imgPhone} height={20} width={20} style={{ marginRight: 5 }} />
                                <p style={{ marginRight: 5, marginBottom: 0 }}>{tweet.contactNumber}</p>
                            </div>
                        </div>
                    </div>

                </div>
            )
        })
    }
    return (
        <>
            <div className={"h-100"}>
                <div>
                    {
                        generateTweets()
                    }
                </div>

            </div>
        </>
    )

}
