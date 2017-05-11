package com.example.jitu.recyclerviewwithsearch;

/**
 * Created by jitu on 11/25/2016.
 */

public class Bean  {

    private String name;
    String url;
    String imageUrl;
    String author;
    String title;
    String description;
    String urlToImage;
    String ural;
    int PublishedAt;
    String souce;
    String source;
    String publishedAt;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void seturlToImage(String urlToImage) {
        this.urlToImage = urlToImage;
    }

    public String geturlToImage() {
        return urlToImage;
    }

    public void setUral(String ural) {
        this.ural = ural;
    }

    public String getUral() {
        return ural;
    }

   /* public void setpPublishedAt(int PublishedAt) {
        this.PublishedAt = PublishedAt;
    }

    public String getpPublishedAt() {
        String strI = Integer.toString(PublishedAt);
        return strI;
    }*/

    public void setSouce(String souce) {
        this.souce = souce;
    }

    public String getSouce() {
        return souce;
    }

 /*   public void setSource(String source) {
        this.source = source;
    }

    public String setSource() {
        return source;
    }*/


    public void setSourceName(String source) {
        this.source = source;
    }

    public String getSourceName() {
        return source;
    }



  /*  public void setPublishedAt(String publishedAt) {
        this.publishedAt = publishedAt;
    }

    public String getPublishedAt() {
        return publishedAt;
    }*/


    public void setTime(String publishedAt) {
        this.publishedAt = publishedAt;
    }

    public String getTime() {
        return publishedAt;
    }


   /* public int compareTo(Bean st) {
        if (PublishedAt == st.PublishedAt)
            return 0;
        else if (PublishedAt > st.PublishedAt)
            return 1;
        else
            return -1;
    }*/
}
