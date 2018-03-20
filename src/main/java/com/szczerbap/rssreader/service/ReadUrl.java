package com.szczerbap.rssreader.service;

import com.szczerbap.rssreader.data.feed.Channel;
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


    public List<Channel> getChannel(String url){


        if(checkIfRssUrl(url)){
            List<Channel> channel=new ArrayList<>();
            channel.add(feedProcess.setChannel(feedProcess.getXmlFeed(url)));
            return channel;
        }

        return getUrlFromHTML(url);

    }

    //==============================================================//

    public boolean checkIfRssUrl(String url){

        String regex = "(feed)|(xml)|(rss)";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(url);

        return matcher.find();
    }

    //==============================================================//

    public List<Channel> getUrlFromHTML(String url){

        String txt=null;

        try {
            URLConnection connection = new URL(url).openConnection();
            InputStream is = connection.getInputStream();
            int ptr = 0;
            StringBuffer buffer = new StringBuffer();
            while ((ptr = is.read()) != -1) {
                buffer.append((char)ptr);
            }
            txt=buffer.toString();
        }catch (MalformedURLException e){
            System.out.println(e.getStackTrace());
        }catch (IOException e){
            System.out.println(e.getStackTrace());
        }




        String regex="<link([A-Za-z0-9\\s\"\\/:\\+\\?.=&\\nĄąĆćĘęŁłŃńÓóŚśŹźŻż-])*rel=\"alternate\"[A-Za-z0-9\\s\"\\/:\\+\\?.=&\\nĄąĆćĘęŁłŃńÓóŚśŹźŻż-]*/>";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(txt);

        List<Channel> channelList=new ArrayList<>();

        while(matcher.find()){

            Pattern hrefPattern = Pattern.compile("href=\"(.*?)\"");
            Matcher hrefMatcher = hrefPattern.matcher(matcher.group());

            Pattern titlePattern = Pattern.compile("title=\"(.*?)\"");
            Matcher titleMatcher = titlePattern.matcher(matcher.group());


            if(hrefMatcher.find()&&titleMatcher.find()) {
                channelList.add(new Channel(titleMatcher.group(1),hrefMatcher.group(1),url));
            }

        }

        return channelList;
    }


}
