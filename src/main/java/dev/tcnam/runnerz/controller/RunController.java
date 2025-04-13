package dev.tcnam.runnerz.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import dev.tcnam.runnerz.exception.RunNotFoundException;
import dev.tcnam.runnerz.model.Run;
import dev.tcnam.runnerz.repository.RunRepository;
// import dev.tcnam.runnerz.services.RunService;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RequestParam;
// import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;




@RestController
@RequestMapping("runnerz/v1/runs")
public class RunController {
    
    private final RunRepository runRepository;

    public RunController(RunRepository runRepository) {
        this.runRepository = runRepository;
    }

    @GetMapping()
    public List<Run> findAll() {
        return this.runRepository.findAll();
    }

    @GetMapping("/{id}")
    public Run findById(@PathVariable Integer id) {
        Run run = this.runRepository.findById(id);
        if (run == null){
            throw new RunNotFoundException();
        } else {
            return this.runRepository.findById(id);
        }
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping()
    public void createRun(@RequestBody Run run){
        this.runRepository.createRun(run);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    public void updateRun(@PathVariable Integer id, @RequestBody Run run){
        this.runRepository.updateRun(id, run);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void deleteRun(@PathVariable Integer id){
        this.runRepository.deleteRun(id);
    }
    

}
