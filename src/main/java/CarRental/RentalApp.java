package CarRental;
import java.util.Scanner;

/*
Design a Java program to manage a car rental system using a HashMap<String, Boolean>,
 where the key is the car registration number, and the value is a boolean indicating whether the car is available or not.
Implement methods to add a new car, rent a car, return a car, and display the list of available cars.
Refactor the code with this method
Customer Management:
    Store customer details such as name, contact information, and rental history.
    Implement functionalities to add, update, or delete customer records.
Car Details:
    Store more details about each car, such as make, model, year, color, price, etc.
    Implement functionalities to add, update, or delete car details.
Rental History:
    Maintain a record of all rental transactions, including rental date, return date, rental duration, customer details, and car details.
    Implement functionalities to view rental history by customer or by car.

*/

public class RentalApp {
    static CarBuilder carBuilder=new CarBuilder();
    static CustomerBuilder customerBuilder=new CustomerBuilder();
    static  RentalHistoryBuilder rentalHistoryBuilder= new RentalHistoryBuilder();
    public static void DisplayMessage(){
        System.out.println("Type 0 for Adding a car");
        System.out.println("Type 1 for Updating a Car");
        System.out.println("Type 2 for deleting a Car");
        System.out.println("Type 3 for Adding a Customer");
        System.out.println("Type 4 for Updating  a Customer");
        System.out.println("Type 5 for Deleting a Customer");
        System.out.println("Type 6 for Renting a Car");
        System.out.println("Type 7 for getting Customer Rental History");
        System.out.println("Type 8 for getting Car Rental History");
        System.out.println("Type 9 for getting all Car");
        System.out.println("Type 10 for getting all Customer");
        System.out.println("Type 11 for listing available cars");
    }
    public static void main(String[] args) {
        int flag=1;

        Scanner input=new Scanner(System.in);
        while(flag==1){
            DisplayMessage();
            System.out.println("Type Case: ");
            int id=input.nextInt();
            switch(id){
                case 0:{
                   carBuilder.addCar();
                   break;
                }
                case 1:{
                    carBuilder.updateCarDetail();
                    break;
                }
                case 2:{
                    carBuilder.deleteCar();
                    break;
                }
                case 3:{
                    customerBuilder.addCustomer();
                    break;
                }
                case 4:{
                    customerBuilder.updateCustomerDetails();
                    break;
                }
                case 5:{
                    customerBuilder.deleteCustomerDetails();
                    break;
                } case 6:{
                    rentalHistoryBuilder.rentCar(carBuilder.allCars,customerBuilder.allCustomer);
                    break;
                } case 7:{
                    customerBuilder.customerRentalHistory();
                    break;
                }
                case 8:{
                    carBuilder.carRentalHistory();
                    break;
                }
                case 9:{
                    carBuilder.getAllCars();
                    break;
                }
                case 10:{
                    customerBuilder.getAllCustomer();
                    break;
                }
                case 11:{
                    carBuilder.availableCars();
                }
                default:
                    flag=0;
            }
        }
    }
}
