package com.szczerbap.rssreader.service;

import com.szczerbap.rssreader.data.dto.RssChannelDto;
import com.szczerbap.rssreader.data.feed.Channel;
import com.szczerbap.rssreader.model.RssChannel;
import org.jsoup.Jsoup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import javax.naming.MalformedLinkException;
import javax.swing.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class ReadUrl {

    @Autowired
    FeedProcess feedProcess;


    public List<RssChannelDto> getChannel(String url){


        if(checkIfRssUrl(url)){
            List<RssChannelDto> rssChannels=new ArrayList<>();
            Channel channel= feedProcess.setChannel(feedProcess.getXmlFeed(url));
            rssChannels.add(new RssChannelDto(url,channel.getLink(),channel.getTitle(),channel.getDescription()));
            return rssChannels;
        }
        else {
            return getUrlFromHTML(url);

        }
    }

    //==============================================================//

    public boolean checkIfRssUrl(String url){

        String regex = "(feed)|(xml)|(rss)";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(url);

        return matcher.find();
    }

    //==============================================================//

    public List<RssChannelDto> getUrlFromHTML(String url){

        String txt=null;

        try {
            txt= Jsoup.connect(url).get().toString();

        }catch (IOException e){
            System.out.println(e.getStackTrace());
        }




        String regex="<link[A-Za-z0-9\\s\"\\/:\\+\\?.=&\\nĄąĆćĘęŁłŃńÓóŚśŹźŻż-]*rel=\"alternate\"[A-Za-z0-9\\s\"\\/:\\+\\?.=&\\nĄąĆćĘęŁłŃńÓóŚśŹźŻż-]*\\/?>";

        //String regex="[\\S\\s]*?(<link[\\S\\s]*?rel=\"alternate\"[\\S\\s]*?\\/>)[\\S\\s]*?";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(txt);

        List<RssChannelDto> channelList=new ArrayList<>();



        while(matcher.find()){




            Pattern rssHrefPattern = Pattern.compile("href=\"(.*?)\"");
            Matcher rssHrefMatcher = rssHrefPattern.matcher(matcher.group());

            Pattern descriptionPattern = Pattern.compile("title=\"(.*?)\"");
            Matcher descriptionMatcher = descriptionPattern.matcher(matcher.group());

            Pattern titlePattern = Pattern.compile("https?:\\/\\/(.*?)\\/");
            Matcher titleMatcher = titlePattern.matcher(url);




            if(rssHrefMatcher.find()&&descriptionMatcher.find()&&titleMatcher.find()) {
                channelList.add(new RssChannelDto(rssHrefMatcher.group(1),url,titleMatcher.group(1),descriptionMatcher.group(1)));

            }

        }


        return channelList;
    }


}
