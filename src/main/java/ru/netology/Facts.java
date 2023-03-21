package ru.netology;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Facts {
    /*
    //    "id": "5b4910ae0508220014ccfe91",
    //    "text": "Кошки могуть создавать более 100 разных звуков, тогда как собаки только около 10.",
    //    "type": "cat",
    //    "user": "Alex Petrov",
    //    "upvotes": null
     */
    private String id;
    private String text;
    private String type;
    private String user;
    private int upvotes;

    public Facts(@JsonProperty("id") String id,
                 @JsonProperty("text") String text,
                 @JsonProperty("type") String type,
                 @JsonProperty("user") String user,
                 @JsonProperty("upvotes") int upvotes) {
        this.id = id;
        this.text = text;
        this.type = type;
        this.user = user;
        this.upvotes = upvotes;
    }

    public int getUpvotes(){
        return upvotes;
    }

    @Override
    public String toString(){
        return "Facts: "
                + "\n (ID): " + id
                + "\n (TEXT): " + text
                + "\n (TYPE): " + type
                + "\n (USER): " + user
                + "\n (UPVOTES): " + upvotes
                + "\n" ;
    }
}
