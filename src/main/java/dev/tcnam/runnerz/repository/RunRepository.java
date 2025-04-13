package dev.tcnam.runnerz.repository;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Repository;

import dev.tcnam.runnerz.model.Run;
import jakarta.annotation.PostConstruct;

@Repository
public class RunRepository {
    private List<Run> runs = new ArrayList<>();

    public List<Run> findAll() {
        return this.runs;
    }

    public Run findById(Integer id){
        for (int i = 0; i<this.runs.size(); i++){
            if (this.runs.get(i).getId() == id) {
                return this.runs.get(i);
            }
        }
        return null;
        // return this.runs.stream()
        //             .filter(run -> run.getId().equals(id))
        //             .findFirst()
        //             .get();
    }

    public void createRun(Run run){
        Run existedRun = findById(run.getId());
        if (existedRun != null){
            System.out.println("Id was already existed");
        } else {
            this.runs.add(run);
        }
        // return run;
    }

    public void updateRun(Integer id, Run run){
        Run existedRun = findById(id);
        if (existedRun != null){
            this.runs.set(this.runs.indexOf(existedRun), run);
        }
    }

    public void deleteRun(Integer id){
        this.runs.removeIf(run -> run.getId().equals(id));
    }

    @PostConstruct
    private void init() {
        System.out.println(LocalDateTime.now());
        this.runs.add(new Run(1, "First Run", LocalDateTime.now(), LocalDateTime.now().plus(1, ChronoUnit.HOURS), (long) (3.0), "Chicago"));
        this.runs.add(new Run(2, "Second Run", LocalDateTime.now(), LocalDateTime.now().plus(2, ChronoUnit.HOURS), (long) (5.0), "Newyork"));
    }
}
