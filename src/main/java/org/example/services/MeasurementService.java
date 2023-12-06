package org.example.services;

import org.example.dtos.MeasurementDTO;
import org.example.dtos.builders.MeasurementBuilder;
import org.example.entities.Measurement;
import org.example.repositories.MeasurementRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MeasurementService {
    private static final Logger LOGGER = LoggerFactory.getLogger(MeasurementService.class);

    private final MeasurementRepository measurementRepository;

    @Autowired
    public MeasurementService(MeasurementRepository measurementRepository) {
        this.measurementRepository = measurementRepository;
    }

    public List<MeasurementDTO> findMeasurements() {
        List<Measurement> measurementList = measurementRepository.findAll();
        return measurementList.stream()
                .map(MeasurementBuilder::toMeasurementDTO)
                .collect(Collectors.toList());
    }

    public Measurement findMeasurementById(Integer id) {
        Measurement measurement = measurementRepository.findById(id).orElse(null);
        return MeasurementBuilder.toMeasurementDetailsDTO(measurement);
    }

    public Integer insert(MeasurementDTO measurementDTO) {
        Measurement measurement = MeasurementBuilder.toEntity(measurementDTO);
        measurement = measurementRepository.save(measurement);
        LOGGER.debug("Measurement with id {} was inserted in db", measurement.getId());
        return measurement.getId();
    }

    public Integer update(MeasurementDTO measurementDTO, Integer id) {
        Measurement measurement = measurementRepository.findById(id).orElse(null);
        assert measurement != null;
        measurement.setTimestamp(measurementDTO.getTimestamp());
        measurement.setDeviceId(measurementDTO.getDeviceId());
        measurement.setMeasurementValue(measurementDTO.getMeasurementValue());
        measurement = measurementRepository.save(measurement);
        LOGGER.debug("Measurement with id {} was updated in db", measurement.getId());
        return measurement.getId();
    }

    public void delete(Integer id) {
        measurementRepository.deleteById(id);
        LOGGER.debug("Measurement with id {} was deleted from db", id);
    }

}
