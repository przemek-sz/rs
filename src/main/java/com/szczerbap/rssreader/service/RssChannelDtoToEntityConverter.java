package com.szczerbap.rssreader.service;

import com.szczerbap.rssreader.data.dto.RssChannelDto;
import com.szczerbap.rssreader.model.RssChannel;
import org.springframework.stereotype.Service;

@Service
public class RssChannelDtoToEntityConverter implements BaseConverter<RssChannelDto,RssChannel> {

    @Override
    public RssChannel convert(RssChannelDto from) {

        RssChannel  rssChannel = new RssChannel(
                from.getRssUrl(),
                from.getUrl(),
                from.getTitle(),
                from.getDescription()
        );

        return  rssChannel;

    }

}
