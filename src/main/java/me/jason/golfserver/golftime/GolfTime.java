package me.jason.golfserver.golftime;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.ZonedDateTime;

@Document("golfTime")
public class GolfTime {
    @Id
    private String id;
    private final String startDate;
    private final int startHour;
    private final int startMinute;

    public GolfTime(String startDate, int startHour, int startMinute) {
        this.startDate = startDate;
        this.startHour = startHour;
        this.startMinute = startMinute;
    }

    @JsonIgnore
    public boolean isValid() {
        return startDate != null && startDate.matches("\\d{1,2}-\\d{1,2}-\\d{4}");
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("GolfTime{");
        sb.append("id='").append(id).append('\'');
        sb.append(", startDate='").append(startDate).append('\'');
        sb.append(", startHour=").append(startHour);
        sb.append(", startMinute=").append(startMinute);
        sb.append('}');
        return sb.toString();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStartDate() {
        return startDate;
    }

    public int getStartHour() {
        return startHour;
    }

    public int getStartMinute() {
        return startMinute;
    }
}
