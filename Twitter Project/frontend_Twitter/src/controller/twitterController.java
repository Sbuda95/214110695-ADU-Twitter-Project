package controller;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.GenericType;

import Conn.TwitterRS;
import model.Twitter;

@ManagedBean(name = "twitterController")
@SessionScoped
public class twitterController {

	Client client = ClientBuilder.newClient();
	private List<Twitter> tweetsList;
	private String tweetBody;

	public void getAllTweets() {
		this.tweetsList = client.target(TwitterRS.URL + TwitterRS.GET_ALL_TWEETS).request()
				.get(new GenericType<List<Twitter>>() {
				});
	}

	public void saveTweet() {
		String status = client.target(TwitterRS.URL+TwitterRS.CREATE_NEW_TWEET).request().post(Entity.json(twitterBody()),String.class);
		if(status != null) {
		
		}
	}

	public void clearTweets() {
		if (this.tweetsList != null) {
			tweetsList.clear();
		}
	}

	private Twitter twitterBody() {
		Twitter mdl = new Twitter();
		mdl.setTweetBody(tweetBody);
		return mdl;
	}

	public String getTweetBody() {
		return tweetBody;
	}

	public void setTweetBody(String tweetBody) {
		this.tweetBody = tweetBody;
	}

	public List<Twitter> getTweetsList() {
		return tweetsList;
	}

	public void setTweetsList(List<Twitter> tweetsList) {
		this.tweetsList = tweetsList;
	}

}

