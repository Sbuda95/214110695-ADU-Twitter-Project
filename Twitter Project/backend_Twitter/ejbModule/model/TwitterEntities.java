package model;

import java.io.Serializable; 
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="tweet_details")
@NamedQueries({
	@NamedQuery(name="TwitterEntities.viewAll", query="SELECT t FROM tweet_details"),
	@NamedQuery(name="TwitterEntities.viewAllById", query="SELECT t FROM tweet_details where tweetID = :tweetID")
})
public class TwitterEntities implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="tweet_ID")
	private Integer tweetID;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="time_stamp")
	private Date timeStamp;

	@Column(name="tweet_body")
	private String tweetBody;


	public Integer getTweetID() {
		return tweetID;
	}

	public void setTweetID(Integer tweetID) {
		this.tweetID = tweetID;
	}



	public Date getTimeStamp() {
		return this.timeStamp;
	}

	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}

	public String getTweetBody() {
		return this.tweetBody;
	}

	public void setTweetBody(String tweetBody) {
		this.tweetBody = tweetBody;
	}

}
