package dev.tcnam.runnerz.model;

import java.time.Duration;
import java.time.LocalDateTime;

public class Run {
    private Integer id;
    private String title;
    private LocalDateTime startDateTime;
    private LocalDateTime endDateTime;
    private Long distance;
    private String location;

    public Run(Integer id, String title, LocalDateTime startDateTime, LocalDateTime endDateTime, Long distance, String location ){
        this.id = id;
        this.title = title;
        this.startDateTime = startDateTime;
        this.endDateTime = endDateTime;
        this.distance = distance;
        this.location = location;
    }

    public Duration getDuration() {
        return Duration.between(startDateTime, endDateTime);
    }

    public Integer getAvgPace() {
        return Math.toIntExact(getDuration().toMinutes() / distance);
    }

    public Integer getId() {
        return this.id;
    }

    public String getTitle() {
        return this.title;
    }

    public Long getDistance() {
        return this.distance;
    }

    public String getLocation() {
        return this.location;
    }

    @Override
    public String toString() {
        return "Run{" +
                    "id=" + Integer.toString(this.id)  +
                    ", title=" + this.title +
                    ", startDateTime=" + this.startDateTime.toString() +
                    ", endDatetime=" + this.endDateTime.toString() +
                    ", distance=" + Long.toString(this.distance) +
                    ", location=" + this.location + 
                    "}";
    }
}   
