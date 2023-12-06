package org.example.controller;

import org.example.dtos.MeasurementDTO;
import org.example.dtos.MeasurementDetailsDTO;
import org.example.entities.Measurement;
import org.example.services.MeasurementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/measurement")
public class MeasurementController {
    private final MeasurementService measurementService;

    @Autowired
    public MeasurementController(MeasurementService measurementService) {
        this.measurementService = measurementService;
    }

    @GetMapping()
    public ResponseEntity<List<MeasurementDTO>> getMeasurements() {
        List<MeasurementDTO> dtos = measurementService.findMeasurements();
        return ResponseEntity.ok(dtos);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Measurement> getMeasurement(@PathVariable("id") int measurementId) {
        Measurement dto = measurementService.findMeasurementById(measurementId);
        return ResponseEntity.ok(dto);
    }

    @PostMapping()
    public ResponseEntity<Integer> insertMeasurement(@RequestBody MeasurementDTO measurementDTO) {
        int measurementId = measurementService.insert(measurementDTO);
        return ResponseEntity.ok(measurementId);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Integer> updateMeasurement(@RequestBody MeasurementDTO measurementDTO, @PathVariable("id") int measurementId) {
        int id = measurementService.update(measurementDTO, measurementId);
        return ResponseEntity.ok(id);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Integer> deleteMeasurement(@PathVariable("id") int measurementId) {
        measurementService.delete(measurementId);
        return ResponseEntity.ok(measurementId);
    }


}
