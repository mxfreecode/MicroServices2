package com.train.app.client;


import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.train.app.entity.Train;



@FeignClient("trainservice")
public interface TrainClient {
	
	 @GetMapping("/trains")
	 public List<String> getAllTrains();
	 
	 @PostMapping("/trains")
	 public ResponseEntity<String> saveTrainsDetails(@RequestBody Train train);
	 
	 @GetMapping("/trains/{trainId}")
	 public ResponseEntity<String> getTrainById(@PathVariable Integer trainId);
	 
	 
	 @GetMapping("/trains/source")
	 public ResponseEntity<String> getTrainBySource(@RequestParam String source);
	
	 @GetMapping("/trains/destination")
	 public ResponseEntity<String> getTrainByDestination(@RequestParam String destination);

	 @GetMapping("/trains/date")
	 public ResponseEntity<String> getTrainByDate(@RequestParam String date);


}
