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
    private int carNumber;
    private String describe;
    private String photo;
    private String status;

    public Accident() {
    }

    public Accident(String name, String address, int carNumber, String describe, String photo, String status) {
        this.name = name;
        this.address = address;
        this.carNumber = carNumber;
        this.describe = describe;
        this.photo = photo;
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

    public int getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(int carNumber) {
        this.carNumber = carNumber;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Accident{" + "id=" + id
                + ", name='" + name + '\''
                + ", address='" + address + '\''
                + ", carNumber=" + carNumber
                + ", describe='" + describe + '\''
                + ", photo='" + photo + '\''
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
                && Objects.equals(photo, accident.photo)
                && status.equals(accident.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
