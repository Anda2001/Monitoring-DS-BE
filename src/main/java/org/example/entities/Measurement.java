package org.example.entities;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.xml.crypto.Data;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

@Entity
public class Measurement implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Type(type = "int")
    @Column(name = "id")
    private int id;

    @Column(name = "timestamp", nullable = false)
    private Timestamp timestamp;

    @Column(name = "device_id", nullable = false)
    private int device_id;

    @Column(name = "measurement_value", nullable = false)
    private int measurement_value;

    public Measurement() {
    }

    public Measurement(Timestamp timestamp, int device_id, int measurement_value) {
        this.timestamp = timestamp;
        this.device_id = device_id;
        this.measurement_value = measurement_value;
    }

    public Measurement(int id, Timestamp timestamp, int device_id, int measurement_value) {
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
