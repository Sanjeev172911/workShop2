package CarRental;

import java.util.ArrayList;

public class Customer {
    String customerId;
    String name;
    String address;
    String phoneNumber;
    String email;
    ArrayList<RentalHistory>rentalHistories;
    Customer(String id,String name,String address,String phoneNumber,String email){
        this.customerId=id;
        this.name=name;
        this.address=address;
        this.phoneNumber=phoneNumber;
        this.email=email;
        this.rentalHistories=new ArrayList<>();
    }

    public void addRentalDetails(RentalHistory rentalDetails){
        this.rentalHistories.add(rentalDetails);
    }
}
