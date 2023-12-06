package org.example.dtos.builders;

import org.example.dtos.MeasurementDTO;
import org.example.entities.Measurement;

public class MeasurementBuilder {
    private MeasurementBuilder() {
    }

    public static MeasurementDTO toMeasurementDTO(Measurement measurement) {
        return new MeasurementDTO(measurement.getId(), measurement.getTimestamp(), measurement.getDeviceId(), measurement.getMeasurementValue());
    }

    public static Measurement toMeasurementDetailsDTO(Measurement measurement) {
        return new Measurement(measurement.getId(), measurement.getTimestamp(), measurement.getDeviceId(), measurement.getMeasurementValue());
    }

    public static Measurement toEntity(MeasurementDTO measurementDTO) {
        return new Measurement(measurementDTO.getId(),
                measurementDTO.getTimestamp(),
                measurementDTO.getDeviceId(),
                measurementDTO.getMeasurementValue());
    }
}
