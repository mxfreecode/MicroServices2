package com.train.app.service;


import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.train.app.entity.Train;
import com.train.app.repository.TrainRepository;

@Service
public class TrainService {
	@Autowired
	TrainRepository trainRepository;
	
	public ArrayList<Train> getTrains(){
		return (ArrayList<Train>) trainRepository.findAll();
	}
	
	public Train saveTrains(Train train) {
		return trainRepository.save(train);
	}
	
	public Optional<Train> getById(Integer trainId){
		return trainRepository.findById(trainId);
	}
	

	///GET BY SOURCE
	public ArrayList<Train> getByDestination(String destination)
	{
		return trainRepository.findByDestination(destination);
	}
	
	public boolean deleteTrain(Integer trainId) {
		try {
			trainRepository.deleteById(trainId);
			return true;
		}catch(Exception err) {
			return false;
		}
	}
	
		///GET BY SOURCE
		
		public ArrayList<Train> getSource(String source)
		{
			return trainRepository.findBySource(source);
		}
		///GET BY DATE
		public ArrayList<Train> getDate(String date)
		{
			return trainRepository.findByDate(date);
		}
		
	
	
	
}
