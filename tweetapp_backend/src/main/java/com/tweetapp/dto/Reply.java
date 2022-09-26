package com.tweetapp.dto;

import java.util.Date;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBDocument;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@DynamoDBDocument
public class Reply {

	@DynamoDBAttribute
	private String userId;

	@DynamoDBAttribute
	private String replied;

	@DynamoDBAttribute
	private Date dateReplied;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getReplied() {
		return replied;
	}

	public void setReplied(String replied) {
		this.replied = replied;
	}

	public Date getDateReplied() {
		return dateReplied;
	}

	public void setDateReplied(Date dateReplied) {
		this.dateReplied = dateReplied;
	}
}
