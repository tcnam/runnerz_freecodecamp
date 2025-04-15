package dev.tcnam.runnerz.model;

import java.time.Duration;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.validation.constraints.NotBlank;



public class Run {

    private Integer id;
    @NotBlank
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

    public Integer getId() {
        return this.id;
    }

    public String getTitle() {
        return this.title;
    }

    public LocalDateTime getStartDateTime(){
        return this.startDateTime;
    }
    public LocalDateTime getEndDateTime(){
        return this.endDateTime;
    }

    public Long getDistance() {
        return this.distance;
    }

    public String getLocation() {
        return this.location;
    }

    public Duration getDuration() {
        return Duration.between(startDateTime, endDateTime);
    }

    public Integer getAvgPace() {
        return Math.toIntExact(getDuration().toMinutes() / distance);
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
