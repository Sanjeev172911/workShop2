package CarRental;

/*
    Car Rental System
Design a Java program to manage a car rental system using a HashMap<String, Boolean>, where the key is the car registration number,
and the value is a boolean indicating whether the car is available or not.
Implement methods to add a new car, rent a car, return a car, and display the list of available cars.
*/

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Locale;

public class Car {
    String registrationNumber;
    String carName;
    String model;
    String color;
    int year;
    int price;
    boolean isAvailable;
    ArrayList<RentalHistory>rentalHistories;


    Car(String id,String name,String model,String color,int year,int price){
        registrationNumber=id;
        carName=name;
        this.color=color;
        this.model=model;
        this.year=year;
        this.price=price;
        this.isAvailable=true;
        rentalHistories=new ArrayList<>();
    }

    public void addRentalDetails(RentalHistory rentalDetails){
        this.rentalHistories.add(rentalDetails);
    }

}
