package org.example.dtos;

import org.springframework.hateoas.RepresentationModel;

import java.sql.Timestamp;

public class MeasurementDTO extends RepresentationModel<MeasurementDTO> {
    private int id;
    private Timestamp timestamp;
    private int device_id;
    private int measurement_value;

    public MeasurementDTO() {
    }

    public MeasurementDTO(int id, Timestamp timestamp, int device_id, int measurement_value) {
        this.id = id;
        this.timestamp = timestamp;
        this.device_id = device_id;
        this.measurement_value = measurement_value;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id= id;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp= timestamp;
    }

    public int getDeviceId() {
        return device_id;
    }

    public void setDeviceId(int device_id) {
        this.device_id= device_id;
    }

    public int getMeasurementValue() {
        return measurement_value;
    }

    public void setMeasurementValue(int measurement_value) {
        this.measurement_value= measurement_value;
    }

    @Override
    public String toString() {
        return "Measurement{" +
                "id=" + id +
                ", timestamp='" + timestamp + '\'' +
                ", device_id='" + device_id + '\'' +
                ", measurement_value='" + measurement_value + '\'' +
                '}';
    }
}
