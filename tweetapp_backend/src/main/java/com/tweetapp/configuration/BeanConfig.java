package com.tweetapp.configuration;

import org.socialsignin.spring.data.dynamodb.repository.config.EnableDynamoDBRepositories;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
 
@Configuration
//annotation enables the dynamodb repositories
@EnableDynamoDBRepositories(basePackages = "com.tweetapp.repo")
public class BeanConfig {
 
    @Value("${amazon.dynamodb.endpoint}")
    String endpoint;
    @Value("${amazon.aws.accesskey}")
    String accesskey;
    @Value("${amazon.aws.secretkey}")
    String secretkey;
    @Value("${amazon.aws.region}")
    String region;
    
   
 
    public AwsClientBuilder.EndpointConfiguration endpointConfiguration() {
        return new AwsClientBuilder.EndpointConfiguration(endpoint, region);   
    }
 
    public AWSCredentialsProvider awsCredentialsProvider() {
        return new AWSStaticCredentialsProvider(new BasicAWSCredentials(accesskey, secretkey));
    }
 
    @Bean
    public AmazonDynamoDB amazonDynamoDB() {
        return AmazonDynamoDBClientBuilder
                .standard()
                .withEndpointConfiguration(endpointConfiguration())
                .withCredentials(awsCredentialsProvider())
                .build();
    }
}
