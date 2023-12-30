package CarRental;
/*
Rental History:
    Maintain a record of all rental transactions, including rental date, return date, rental duration,
    customer details, and car details.
    Implement functionalities to view rental history by customer or by car.
*/

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;
import java.util.Locale;
import java.util.stream.Stream;

public class RentalHistory {
    String rentalId;
    String rentalStartDate;
    String rentalEndDate;
    String customerId;
    String carId;

    RentalHistory(String rentalId,String startDate,String endDate,String CustomerId,String CarId){
        this.rentalId=rentalId;
        this.rentalStartDate=startDate;
        this.rentalEndDate=endDate;
        this.customerId=CustomerId;
        this.carId=CarId;
    }

    public void print(){
        System.out.println("CustomerId : "+customerId);
        System.out.println("Rental Id : "+rentalId);
        System.out.println("Car Id : "+carId);
        System.out.println("Rental start date : "+rentalStartDate);
        System.out.println("Rental End Date : "+rentalEndDate);
        rentalDuration();
    }

    public LocalDate formatDate(String date){
        LocalDate formattedDate=null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            java.util.Date utilDate = sdf.parse(date);
            formattedDate = utilDate.toInstant().atZone(java.time.ZoneId.systemDefault()).toLocalDate();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return formattedDate;
    }

    public void rentalDuration(){
        LocalDate startDate =formatDate(rentalStartDate);
        LocalDate endDate=formatDate(rentalEndDate);
        Duration duration = Duration.between(startDate.atStartOfDay(), endDate.atStartOfDay());
        System.out.println("Duration: " + duration.toDays() + " days");
    }
}
