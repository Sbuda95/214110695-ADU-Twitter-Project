package model_Twitter;

import java.io.Serializable;
import java.util.Date;

public class model_Twitter implements Serializable{

	private static final long serialVersionUID = -1513100561321637678L;
	
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

}

