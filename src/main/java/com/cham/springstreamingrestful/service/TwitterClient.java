package com.cham.springstreamingrestful.service;

import com.cham.springstreamingrestful.domain.Tweet;
import com.cham.springstreamingrestful.repository.TweetCassandraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import twitter4j.*;
import twitter4j.auth.AccessToken;
import twitter4j.conf.ConfigurationBuilder;

@Component
public class TwitterClient {

    private String appKey = "";
    private String appSecret = "";
    private String accessToken = "";
    private String accessTokenSecret="";

    private TwitterStreamFactory factory = new TwitterStreamFactory(new ConfigurationBuilder().build());
    private TwitterStream twitterStream = factory.getInstance();

    @Autowired
    private TweetCassandraRepository tweetCassandraRepository;

    public void init() {
        twitterStream.setOAuthConsumer(appKey, appSecret);
        twitterStream.setOAuthAccessToken(new AccessToken(accessToken, accessTokenSecret));

        twitterStream.addListener(new StatusListener() {
            @Override
            public void onStatus(Status status) {
                Tweet tweet = new Tweet();
                tweet.setId(Long.toString(status.getUser().getId()));
                tweet.setUser(status.getUser().getName());
                tweet.setMessage(status.getText());
                tweetCassandraRepository.insert(tweet);
                System.out.println("Usr ID is = " + tweet.getId() +"Usr name is = " +tweet.getUser() +" Tweet message is = " +tweet.getMessage());
            }

            @Override
            public void onDeletionNotice(StatusDeletionNotice statusDeletionNotice) {

            }

            @Override
            public void onTrackLimitationNotice(int numberOfLimitedStatuses) {

            }

            @Override
            public void onScrubGeo(long userId, long upToStatusId) {

            }

            @Override
            public void onStallWarning(StallWarning warning) {

            }

            @Override
            public void onException(Exception ex) {

            }
        });
    }
    public TwitterClient(){
        init();

    }

    public void getTwitterStream(){
        twitterStream.sample();
    }
}
