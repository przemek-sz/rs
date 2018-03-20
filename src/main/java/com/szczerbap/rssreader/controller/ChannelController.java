package com.szczerbap.rssreader.controller;

import com.szczerbap.rssreader.data.feed.Channel;
import com.szczerbap.rssreader.repository.RssChannelRepository;
import com.szczerbap.rssreader.service.ReadUrl;
import com.szczerbap.rssreader.service.RssChannelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/api/channel")
public class ChannelController {

    @Autowired
    ReadUrl readUrl;
    @Autowired
    RssChannelService rssChannelService;

    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public List<Channel> search(@RequestBody String url){

       return readUrl.getChannel(url);

    }

    /*
    @RequestMapping(value = "/add", method=RequestMethod.PUT)
    public void add(String url,Principal user){


       System.out.println(user.getName());
        //rssChannelService.add(url);

    }
    */
}
