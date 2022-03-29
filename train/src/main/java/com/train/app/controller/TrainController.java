package com.train.app.controller;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.train.app.entity.Train;
import com.train.app.service.TrainService;

@RestController
@RequestMapping("/trains")
public class TrainController {
	@Autowired
	TrainService trainService;
	
	@GetMapping()
	public ArrayList<Train> getTrains(){
		return trainService.getTrains();
	}
	
	@PostMapping()
	public Train saveTrain(@RequestBody Train train) {
		return this.trainService.saveTrains(train);
	}

    @GetMapping( path = "/{trainId}")
    public Optional<Train> getTrainsById(@PathVariable("trainId") Integer trainId) {
        return this.trainService.getById(trainId);
    }
    
    //GET BY SOURCE
    @GetMapping("/source")
    public ArrayList<Train> getTrainsBySource(@RequestParam("source") String source){
        return this.trainService.getSource(source);
    } 
    //GET BY DESTINATION
    @GetMapping("/destination")
    public ArrayList<Train> getTrainsByDestination(@RequestParam("destination") String destination){
        return this.trainService.getByDestination(destination);
    } 
    //GET BY DATE
    @GetMapping("/date")
    public ArrayList<Train> getTrainsByDate(@RequestParam("date") String date){
        return this.trainService.getDate(date);
    }    
    
    @DeleteMapping( path = "/{trainId}")
    public String deleteById(@PathVariable("trainId") Integer trainId){
        boolean ok = this.trainService.deleteTrain(trainId);
        if (ok){
            return "Delete Train Successful id:" + trainId;
        }else{
            return "Cannot Deleted Train:" + trainId;
        }
    }
    
    
  
    
    
    
    
    
}
