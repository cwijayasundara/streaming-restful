package com.cham.springstreamingrestful;

import com.cham.springstreamingrestful.domain.Tweet;
import com.cham.springstreamingrestful.repository.TweetCassandraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.cassandra.repository.config.EnableReactiveCassandraRepositories;


@SpringBootApplication
@EnableReactiveCassandraRepositories
public class SpringStreamingRestfulApplication implements CommandLineRunner {

    @Autowired
    private TweetCassandraRepository tweetCassandraRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringStreamingRestfulApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
	    for(int count=7; count<100000;count++) {
	        String countString= Integer.toString(count);
            Tweet tweet = new Tweet(countString, "Chaminda W", "I love TF");
            tweetCassandraRepository.insert(tweet).block();
        }
	}
}
