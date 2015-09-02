package com.hpdts.hello.repository.config;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;

@Configuration
public class SpringMongoConfig extends AbstractMongoConfiguration
{
    @Override
    protected String getDatabaseName()
    {
        return "hpdts";
    }

    @Override
    @Bean
    public Mongo mongo() throws Exception
    {
        return new MongoClient("localhost" , 27017 );
    }
}
