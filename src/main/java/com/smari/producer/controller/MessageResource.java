package com.smari.producer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("/messages")
public class MessageResource {
    @Autowired
    private KafkaTemplate<String, String> template;
    @GET
    @Path("{message}")
    public String publishMessage(@PathParam("message") String message){
        template.send("test",message);
        return "message [" + message +"] has been published to [test]";
    }
}

