package CarRental;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

/*
    Store customer details such as name, contact information, and rental history.
    Implement functionalities to add, update, or delete customer records.
 */

public class CustomerBuilder {
    public Map<String ,Customer>allCustomer;
    Scanner input;
    CustomerBuilder() {
        allCustomer=new HashMap<>();
        input =new Scanner(System.in);
    }

    public void addCustomer(){
        input =new Scanner(System.in);
        System.out.println("Enter the details of Customer");
        Random random=new Random();
        Long regNo=random.nextLong();
        String registration=Long.toString(regNo);

        System.out.println("Enter your Name :");
        String name=input.nextLine();
        System.out.println("Enter your Address :");
        String address=input.nextLine();
        System.out.println("Enter your PhoneNumber :");
        String phoneNumber=input.nextLine();
        System.out.println("Enter your Email:");
        String email=input.nextLine();

        Customer newCustomer=new Customer(registration,name,address,phoneNumber,email);
        allCustomer.put(registration,newCustomer);

        System.out.println("Customer with "+registration+" Created successfully");

    }

    public void updateCustomerDetails(){
        input =new Scanner(System.in);
        System.out.println("Enter your Customer Registration Id");
        String Id=input.nextLine();

        if(!allCustomer.containsKey(Id)){
            System.out.println("No Customer with this Id");
            return ;
        }

        Customer customer=allCustomer.get(Id);
        System.out.println("Enter your Updated Name :");
        String name=input.nextLine();
        customer.name=name;
        System.out.println("Enter your Updated Address :");
        String address=input.nextLine();
        customer.address=address;
        System.out.println("Enter your Updated PhoneNumber :");
        String phoneNumber=input.nextLine();
        customer.phoneNumber=phoneNumber;
        System.out.println("Enter your Updated Email:");
        String email=input.nextLine();
        customer.email=email;

        System.out.println("Updated Customer Details");
    }

    public void deleteCustomerDetails(){
        input =new Scanner(System.in);
        System.out.println("Enter your Customer Registration Id");
        String Id=input.nextLine();

        if(!allCustomer.containsKey(Id)){
            System.out.println("No Customer with this Id");
            return ;
        }

        allCustomer.remove(Id);

        System.out.println("Customer with "+Id+" deleted successfully");
    }

    public void customerRentalHistory(){
        input =new Scanner(System.in);
        System.out.println("Enter your Customer Registration Id");
        String Id=input.nextLine();

        if(!allCustomer.containsKey(Id)){
            System.out.println("No Customer with this Id");
            return ;
        }

        Customer customer=allCustomer.get(Id);

        for(RentalHistory rentalHistory:customer.rentalHistories){
            rentalHistory.print();
        }

    }

    public void getAllCustomer(){
        if(allCustomer.size()==0){
            System.out.println("There is no customer to show");
        }
        for(String carId:allCustomer.keySet()){
            System.out.println("Customer Id : "+carId);
            System.out.println("  Customer Name : "+allCustomer.get(carId).name);
        }
    }
}
