package com.szczerbap.rssreader.service;

import com.szczerbap.rssreader.data.feed.Channel;
import com.szczerbap.rssreader.data.feed.Feed;
import com.szczerbap.rssreader.data.feed.Item;
import org.springframework.security.access.method.P;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;


import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

@Service
public class FeedProcess {

    public Document getXmlFeed(String channelUrl){

        Document doc=null;

        try{

        URLConnection connection = new URL(channelUrl).openConnection();
        doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(connection.getInputStream());

        doc.getDocumentElement().normalize();


        }catch (MalformedURLException e){
            System.out.println(e.getStackTrace());
        }catch (IOException e){
            System.out.println(e.getStackTrace());
        }catch (ParserConfigurationException e){
            System.out.println(e.getStackTrace());
        }catch (SAXException e){
            System.out.println(e.getStackTrace());
        }

        System.out.println("getDocFromUrl");
        return doc;
    }


    public Feed feedFactory(Document document){


        NodeList nodeList = document.getElementsByTagName("item");


        List<Item> items = new ArrayList<>();


        for(int i=0;i<nodeList.getLength();i++){

            Node node = nodeList.item(i);
            Element element = (Element) node;

            items.add(new Item(element.getElementsByTagName("title").item(0).getTextContent(),
                    element.getElementsByTagName("link").item(0).getTextContent(),
                    element.getElementsByTagName("description").item(0).getTextContent()
            ));
        }


        Channel feed=setChannel(document);

        feed.setItems(items);

        return feed;
    }


    public Channel setChannel(Document document){

        //Channel channel =new Channel("s","s","s");
       Channel channel=new Channel(document.getElementsByTagName("title").item(0).getTextContent(),
                document.getElementsByTagName("link").item(0).getTextContent(),
                document.getElementsByTagName("description").item(0).getTextContent());


        return channel;
    }
}
