package Twitter_Interface;

import java.util.List;

import model_Twitter.model_Twitter;
import model.TwitterEntities;
import twitter4j.Twitter;
import twitter4j.TwitterException;

public interface Twitter_Interface {

	List<Twitter> getAllTweetsByID();
	TwitterEntities saveTweet(Twitter twitter);
	void postTweet(String message) throws TwitterException;
	
}
