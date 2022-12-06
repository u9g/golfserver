package me.jason.golfserver.golfplayer;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("golfPlayer")
public class GolfPlayer {
    @Id
    private String id;
    private String name;
    private String phoneNumber;

    public GolfPlayer(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }


    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("GolfPlayer{");
        sb.append("id='").append(id).append('\'');
        sb.append(", name='").append(name).append('\'');
        sb.append(", phoneNumber='").append(phoneNumber).append('\'');
        sb.append('}');
        return sb.toString();
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    @JsonIgnore
    public boolean isValid() {
        return name != null && phoneNumber != null && phoneNumber.matches("\\d\\d\\d-\\d\\d\\d-\\d\\d\\d\\d");
    }
}
