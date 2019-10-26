package twitter_REST;

import java.util.List; 

import javax.inject.Inject;
import javax.websocket.server.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import model_Twitter.model_Twitter;
import model.TwitterEntities;
import service.TwitterEJB;
import twitter4j.Twitter;

@Path("twitter")
public class twitter_REST {
	
	@Inject
	TwitterEJB twitterEJB;
	
	@POST
	@Path("/createNewTweet")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response createNewTweet(Twitter twitter) {
		TwitterEntities mdl = twitterEJB.saveTweet(twitter);
		return Response.ok(mdl).build();
	}
	
	@GET
	@Path("/viewTweet")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Twitter> findAllTweet() {
		return twitterEJB.getAllTweetsByID();
	}
}