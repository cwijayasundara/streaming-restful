package com.cham.springstreamingrestful.controller;

import com.cham.springstreamingrestful.domain.Tweet;
import com.cham.springstreamingrestful.repository.TweetCassandraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class TweetController {

    @Autowired
    private TweetCassandraRepository tweetCassandraRepository;

    @GetMapping("/tweets")
    public Flux<Tweet> getAllTweets() {
        System.out.println("Inside TweetController.getAllTweets()..");
        return tweetCassandraRepository.findAll();
    }

    @GetMapping(value = "/stream/tweets", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Tweet> streamAllTweets() {
        System.out.println("Inside TweetController.streamAllTweets()..");
        return tweetCassandraRepository.findAll();
    }

    @PostMapping("/tweets")
    public Mono<Tweet> createTweets(@RequestBody Tweet tweet) {
        System.out.println(tweet.getId() + tweet.getUser()+ tweet.getMessage());
        return tweetCassandraRepository.insert(tweet);
    }
}
