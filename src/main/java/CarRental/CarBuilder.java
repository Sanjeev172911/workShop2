package CarRental;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class CarBuilder {
    Scanner input;
    public Map<String,Car> allCars;
    CarBuilder(){
        allCars=new HashMap<>();
    }
    public void addCar(){
        input=new Scanner(System.in);
        Random random=new Random();
        Long regNo=random.nextLong();
        String registration=Long.toString(regNo);
        System.out.println("Enter Car Name");
        String carName=input.nextLine();
        System.out.println("Enter model: ");
        String model=input.nextLine();
        System.out.println("Enter color");
        String color=input.nextLine();
        System.out.println("Enter year ");
        int year=input.nextInt();
        System.out.println("Enter price");
        int price=input.nextInt();

        Car newCar=new Car(registration,carName,model,color,year,price);
        allCars.put(registration,newCar);

        System.out.println("Car with this "+ registration +" number Added Successfully");

    }

    public void updateCarDetail(){
        input=new Scanner(System.in);
        System.out.println("Enter Registration number of your Car");
        String regNo=input.nextLine();

        if(!allCars.containsKey(regNo)){
            System.out.println("Not a Valid Registration Number");
            return ;
        }

        Car car=allCars.get(regNo);

        System.out.println("Do you want to update Car Name");
        String response=input.nextLine();
        if(response.toLowerCase().equals("yes")){
            String carName=input.nextLine();
            car.carName=carName;
        }

        System.out.println("Do you want to update color of your car");
        response=input.nextLine();
        if(response.toLowerCase().equals("yes")){
            String color=input.nextLine();
            car.color=color;
        }

        System.out.println("Do you want to update price of your car");
        response=input.nextLine();
        if(response.toLowerCase().equals("yes")){
            int price=input.nextInt();
            car.price=price;
        }

        System.out.println("Car Details Updated");

    }

    public void deleteCar(){
        input=new Scanner(System.in);
        System.out.println("Enter Registration number of your Car");
        String regNo=input.nextLine();

        if(!allCars.containsKey(regNo)){
            System.out.println("Not a Valid Registration Number");
            return ;
        }else{
            allCars.remove(regNo);
        }

        System.out.println("Rental Car deleted successfully");
    }

    public void markCarAsAvailable(String carId){
        Car car=allCars.get(carId);
        car.isAvailable=true;
    }

    public void carRentalHistory(){
        input=new Scanner(System.in);
        System.out.println("Enter Registration number of your Car");
        String regNo=input.nextLine();

        if(!allCars.containsKey(regNo)){
            System.out.println("Not a Valid Registration Number");
            return ;
        }

        Car car=allCars.get(regNo);

        for(RentalHistory rentalHistory:car.rentalHistories){
            rentalHistory.print();
        }

    }

    public void getAllCars(){
        if(allCars.size()==0){
            System.out.println("There is No Car to show");
        }
        
        for(String carId:allCars.keySet()){
            System.out.println("Car Id : "+carId);
            System.out.println("  CarName : "+allCars.get(carId).carName);
        }
    }

    public void availableCars(){
        for(String carId:allCars.keySet()){
            if(allCars.get(carId).isAvailable){
                System.out.println("Car Id : "+carId);
                System.out.println("  CarName : "+allCars.get(carId).carName);
            }
        }
    }

}
