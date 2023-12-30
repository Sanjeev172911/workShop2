package CarRental;

/*
Rental History:
    Maintain a record of all rental transactions, including rental date, return date, rental duration, customer details, and car details.
    Implement functionalities to view rental history by customer or by car.

 */

import java.time.LocalDate;
import java.util.*;

public class RentalHistoryBuilder {
    static Map<String,RentalHistory>allRentalDetails;
    static Scanner input;

    RentalHistoryBuilder(){
        allRentalDetails=new HashMap<>();
    }

    public void rentCar(Map<String,Car>allCars,Map<String,Customer>allCustomer){
        input=new Scanner(System.in);
        System.out.println("Welcome to rental Car service");

        System.out.println("Enter your CustomerId");
        String customerId=input.nextLine();
        if(!allCustomer.containsKey(customerId)){
            System.out.println("Customer Id not found");
            return;
        }

        System.out.println("Enter CarId");
        String carId=input.nextLine();

        if(allCars.containsKey(carId)){
            if(!allCars.get(carId).isAvailable){
                System.out.println("Car not available");
                return;
            }
        }else{
            System.out.println("there is no acr with this "+carId+" number.");
            return;
        }

        Car car=allCars.get(carId);
        car.isAvailable=false;

        Random random=new Random();
        Long regNo=random.nextLong();
        String rentalId=Long.toString(regNo);

        System.out.println("Enter the start rental date ");
        String startDate=input.nextLine();

        System.out.println("Enter the end rental date ");
        String endDate=input.nextLine();

        RentalHistory newRental=new RentalHistory(rentalId,startDate,endDate,customerId,carId);

        allRentalDetails.put(rentalId,newRental);

        Car rentedCar=allCars.get(carId);
        rentedCar.rentalHistories.add(newRental);

        Customer rentedCustomer=allCustomer.get(customerId);
        rentedCustomer.rentalHistories.add(newRental);
    }

}
