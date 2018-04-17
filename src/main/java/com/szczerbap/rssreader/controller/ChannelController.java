package com.szczerbap.rssreader.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.szczerbap.rssreader.data.dto.RssChannelDto;
import com.szczerbap.rssreader.data.feed.Channel;
import com.szczerbap.rssreader.model.RssChannel;
import com.szczerbap.rssreader.repository.RssChannelRepository;
import com.szczerbap.rssreader.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/api/channel")
public class ChannelController {

    @Autowired
    ReadUrl readUrl;
    @Autowired
    UserService userService;
    @Autowired
    RssChannelService rssChannelService;
    @Autowired
    BaseConverter<RssChannelDto,RssChannel> dtoToEntity;


    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public List<RssChannelDto> search(@RequestBody String url){

       return readUrl.getChannel(url);
    }



    @RequestMapping(value = "/add", method=RequestMethod.POST)
    public void add(@RequestBody String json,Principal principal){

        ObjectMapper mapper = new ObjectMapper();
        RssChannelDto rssChannelDto=null;

        try {
            rssChannelDto=mapper.readValue(json,RssChannelDto.class);
        }catch (IOException e){
            e.printStackTrace();
        }

        RssChannel rssChannel=dtoToEntity.convert(rssChannelDto);
        rssChannel.setUser(userService.getByUserName(principal.getName()));

        rssChannelService.add(rssChannel);

    }


    @RequestMapping(value = "/getall", method = RequestMethod.GET)
    public void getall(){

        System.out.println("getAll");
    }

}
