package service;

import java.util.Date;  
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import Twitter_Interface.Twitter_Interface;
import model_Twitter.model_Twitter;
import model.TwitterEntities;

import Twitter_Interface.Twitter_Interface;
import model.TwitterEntities;
import twitter4j.DirectMessage;
import twitter4j.Status;
import twitter4j.StatusUpdate;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;
import twitter4j.conf.ConfigurationBuilder;

/**
 * Session Bean implementation class TwitterEJB
 */
@Stateless
@LocalBean
public class TwitterEJB implements Twitter_Interface {

	@PersistenceContext
	EntityManager em;
	
	TwitterFactory twitterFactory = new TwitterFactory();

	Twitter twitter = twitterFactory.getInstance();
	
    public TwitterEJB() {
        // TODO Auto-generated constructor stub
    }
    
	@SuppressWarnings("unchecked")
	@Override
	public List<Twitter> getAllTweetsByID() {
		Query query = em.createNamedQuery("TwitterDetail.findAll");
		return (List<Twitter>) query.getResultList();
	}

	@Override
	public TwitterEntities saveTweet(Twitter twitter) {
		String recipiantName = "@og_sbu";
		TwitterEntities twitterDetails = new TwitterEntities();
		if (twitter != null) {
			twitterDetails.setTweetBody( ((model_Twitter) twitter).getTweetBody());
			twitterDetails.setTimeStamp(new Date());
			em.persist(twitterDetails);
			try {
				postTweet(recipiantName + " " +twitterDetails.getTweetBody());
			} catch (TwitterException e) {
				e.printStackTrace();
			}
		}
		return twitterDetails;
	}

	@Override
	public void postTweet(String tweetBody) throws TwitterException {

		StatusUpdate statusUpdate = new StatusUpdate(tweetBody);

		getInstance().updateStatus(statusUpdate);

	}

	private Twitter getInstance() {
		ConfigurationBuilder cb = new ConfigurationBuilder();
		cb.setDebugEnabled(true)
		  .setOAuthConsumerKey("xO69ZSq2UnujAi1XMeFllASiP")
		  .setOAuthConsumerSecret("RgzucJjdT36WyBxAtqACFzkkMNGZpnIuBgBuz835pBq6e7TxIP")
		  .setOAuthAccessToken("282611471-MX4pfpYUzgeV0oWMo5jXADdvrxbBSfMxs21dKcs7")
		  .setOAuthAccessTokenSecret("w9M2h7AAN8njnJsnI5OTvAKKAr7FG2DqMjRc9tw5YWNKw");
		TwitterFactory tf = new TwitterFactory(cb.build());
		return tf.getInstance();
	}

}
