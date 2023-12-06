package org.example.dtos;

import javax.validation.constraints.NotNull;
import java.sql.Timestamp;
import java.util.Objects;

public class MeasurementDetailsDTO {

    private int id;

    @NotNull
    private Timestamp timestamp;

    @NotNull
    private int device_id;

    @NotNull
    private int measurement_value;

    public MeasurementDetailsDTO() {
    }

    public MeasurementDetailsDTO(int id, Timestamp timestamp, int device_id, int measurement_value) {
        this.id = id;
        this.timestamp = timestamp;
        this.device_id = device_id;
        this.measurement_value = measurement_value;
    }

    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }


    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public int getDeviceId() {
        return device_id;
    }

    public void setDeviceId(int device_id) {
        this.device_id = device_id;
    }

    public int getMeasurementValue() {
        return measurement_value;
    }

    public void setMeasurementValue(int measurement_value) {
        this.measurement_value = measurement_value;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MeasurementDetailsDTO)) return false;
        MeasurementDetailsDTO that = (MeasurementDetailsDTO) o;
        return id == that.id &&
                device_id == that.device_id &&
                measurement_value == that.measurement_value &&
                timestamp.equals(that.timestamp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, timestamp, device_id, measurement_value);
    }


}
