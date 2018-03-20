package com.szczerbap.rssreader.data.feed;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Item implements Feed {

    private String title;
    private String link;
    private String description;
    private String jpgLink;


    public Item(String title,String link,String description){
        this.title=title;
        this.link=link;
        this.description=fabricateDescription(description);
        this.jpgLink=setJpgLink(description);
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public void setTitle(String title) {
        this.title=title;
    }

    @Override
    public String getLink() {
        return link;
    }

    @Override
    public void setLink(String link) {
        this.link=link;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public void setDescription(String description) {
        this.description=description;
    }

    public String getJpgLink() {
        return jpgLink;
    }

    public String setJpgLink(String text) {


        String regex="(src=\")(.+j?pn?e?g)(\")";

        Pattern pattern=Pattern.compile(regex);

        Matcher matcher =pattern.matcher(text);

        if(matcher.find()){
            return matcher.group(2);
        }else return null;

        //System.out.println(matcher.group(2));



    }

    public String fabricateDescription(String text){


        //String regex="[A-Za-z0-9{,10}\\s\\.,%ĄąĆćĘęŁłŃńÓóŚśŹźŻż]{50,}[.\\s]";

        //Pattern pattern=Pattern.compile(regex);

       // Matcher matcher =pattern.matcher(text);

       // matcher.find();

        text=text.replaceAll("<(?<tag>\\w{1,2}).*><\\/?\\k<tag>\\s?\\/?>","");
        text=text.replaceAll("<(?<tag>\\w{1,2}).*>.*<\\/?\\k<tag>\\s?\\/?>","");



        return text;


    }
}

