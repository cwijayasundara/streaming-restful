package com.cham.springstreamingrestful.repository;

import com.cham.springstreamingrestful.domain.Tweet;
import org.springframework.data.cassandra.repository.ReactiveCassandraRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TweetCassandraRepository extends ReactiveCassandraRepository<Tweet, String>{

}
