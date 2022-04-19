package com.itesm.azul.config;

/**
 *
 */

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import org.socialsignin.spring.data.dynamodb.repository.config.EnableDynamoDBRepositories;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;

/**
 * @author Molina
 *
 */
@Configuration
@EnableDynamoDBRepositories
        (basePackages = "com.itesm.azul.repositories")
public class AzulConfig {

    @Bean
    public AmazonDynamoDB amazonDynamoDB() {
        return AmazonDynamoDBClientBuilder.standard().withEndpointConfiguration(
                        new AwsClientBuilder.EndpointConfiguration("http://localhost:8000", "localhost")).withCredentials(
                        new AWSStaticCredentialsProvider(new BasicAWSCredentials("rarkct", "c8lg7e"))
                )
                .build();
        /*
        AWSCredentialsProvider credentials = new ProfileCredentialsProvider("pratikpoc");
		AmazonDynamoDB amazonDynamoDB
          = AmazonDynamoDBClientBuilder.standard().withCredentials(credentials).build();

        return amazonDynamoDB;

         */
    }

}
