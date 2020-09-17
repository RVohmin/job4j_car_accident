package ru.job4j.accident.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "accident")
public class Accident {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name")
    private String name;
    private String address;
    private String carNumber;
    private String describe;
    private String fileName;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "statusID")
    private Status status;

    public Accident() {
    }


    public Accident(String name, String address, String carNumber, String describe, String fileName, Status status) {
        this.name = name;
        this.address = address;
        this.carNumber = carNumber;
        this.describe = describe;
        this.fileName = fileName;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public String toString() {
        return "Accident{" + "id=" + id
                + ", name='" + name + '\''
                + ", address='" + address + '\''
                + ", carNumber=" + carNumber
                + ", describe='" + describe + '\''
                + ", photo='" + fileName + '\''
                + ", status='" + status + '\'' + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Accident accident = (Accident) o;
        return id == accident.id
                && carNumber == accident.carNumber
                && name.equals(accident.name)
                && address.equals(accident.address)
                && describe.equals(accident.describe)
//                && Objects.equals(photo, accident.photo)
                && status.equals(accident.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
