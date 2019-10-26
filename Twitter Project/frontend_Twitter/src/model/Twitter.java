package model;

import java.io.Serializable;
import java.util.Date;

public class Twitter implements Serializable {

	private static final long serialVersionUID = -6758296956091695650L;

	private Integer tweetID;
	private Date timeStamp;
	private String tweetBody;

	public Integer getTweetID() {
		return tweetID;
	}

	public void setTweetID(Integer tweetID) {
		this.tweetID = tweetID;
	}

	public Date getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}

	public String getTweetBody() {
		return tweetBody;
	}

	public void setTweetBody(String tweetBody) {
		this.tweetBody = tweetBody;
	}

	@Override
	public String toString() {
		return "Twitter [tweetID=" + tweetID + ", timeStamp=" + timeStamp + ", tweetBody=" + tweetBody + "]";
	}

}

