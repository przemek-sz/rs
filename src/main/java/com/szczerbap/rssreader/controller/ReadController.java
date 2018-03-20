package com.szczerbap.rssreader.controller;


import com.szczerbap.rssreader.data.feed.Feed;
import com.szczerbap.rssreader.service.FeedProcess;
import com.szczerbap.rssreader.service.ReadUrl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.w3c.dom.Document;




@RestController
@RequestMapping("/api/read")
public class ReadController {

    @Autowired
    ReadUrl readUrl;
    @Autowired
    FeedProcess feedProcess;

    @PostMapping
    public Feed readFromUrl(@RequestBody String url){


        return feedProcess.feedFactory(feedProcess.getXmlFeed(url));

    }

    @GetMapping
    public Document getData(String url){

        return feedProcess.getXmlFeed(url);
    }
}
