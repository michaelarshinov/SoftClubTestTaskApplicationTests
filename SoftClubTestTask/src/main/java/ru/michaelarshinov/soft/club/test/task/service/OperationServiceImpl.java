package ru.michaelarshinov.soft.club.test.task.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ru.michaelarshinov.soft.club.test.task.dto.OperationDTO;
import ru.michaelarshinov.soft.club.test.task.model.Operation;
import ru.michaelarshinov.soft.club.test.task.repository.OperationRepository;

@Service
public class OperationServiceImpl implements OperationService {

	@Autowired
	OperationRepository operationRepository;
	
	@Override
	public boolean save(OperationDTO dto) {
		Operation operation = new Operation();
		operation.setCreatedDate(new Date());
		operation.setValue(dto.getValue());
		operation.setDescription(dto.getDescription());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			operation.setDate(sdf.parse(dto.getDate()));
		} catch (ParseException e) {
			return false;
		}
		operationRepository.save(operation);
		return true;
	}

}
