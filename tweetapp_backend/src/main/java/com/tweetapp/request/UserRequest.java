package com.tweetapp.request;

import java.io.Serializable;

import com.tweetapp.dto.UsersDto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRequest implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8300957195016445421L;
	
	UsersDto userDto;

	public UsersDto getUserDto() {
		return userDto;
	}

	public void setUserDto(UsersDto userDto) {
		this.userDto = userDto;
	}
}
