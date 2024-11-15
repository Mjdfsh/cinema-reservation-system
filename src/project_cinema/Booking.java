
package project_cinema;

import java.util.ArrayList;
import java.util.Scanner;

public class Booking {

    private int IDBooking;
    private Customer customer;
    ArrayList<Snack> snack = new ArrayList<Snack>();
    private Movie movie;
    private double totalPrice;
    private double tax;
    private String time;
    Scanner input = new Scanner(System.in);

    public Booking(Customer customer) {
        this.customer = customer;
    }

    public Booking(Customer customer, Movie movie, ArrayList<Snack> snack) {
        this.customer = customer;
        this.movie = movie;
        this.snack = snack;
    }

    public void Display(ArrayList<Snack> snackList, ArrayList<Movie> movieList) {
        int flag = 1;
        while (flag == 1) {
            System.out.println("\t\tMovies\n");
            for (int i = 0; i < movieList.size(); i++) {
                System.out.print(i+1 + "- ");
                System.out.println(movieList.get(i).toString());
                System.out.println("\n");
            }

            System.out.print("waht is your choice? :");
            int choose = input.nextInt();
            if (choose > 0 && choose - 1 < movieList.size()) {
                movie = movieList.get(choose - 1);
                System.out.println("\nthe movie has been booked\n\n");
                flag = 1;
                while (flag == 1) {
                    System.out.println("\t\tSncks\n");
                    
                    for (int i = 0; i < snackList.size(); i++) {
                        System.out.print(i+1 + "- ");
                        System.out.println(snackList.get(i).toString());
                        System.out.println("\n");
                    }

                    System.out.print("waht is your choice? ");
                    choose = input.nextInt();
                    if (choose > 0 && choose - 1 < snackList.size()) {
                        snack.add(snackList.get(choose - 1));
                        System.out.println("\nthe snack has been added\n");

                        System.out.println("Do you want to choose another Snack ? (y/n)");
                        String check = input.next();
                        if (check.equals("n") || check.equals("N")) {
                            flag = 0;
                            chooseDateAndTime();
                        }
                    } else {
                        System.out.println("please enter a correct number...");
                    }
                }
                flag = 0;
            } else {
                System.out.println("choose a correct numebr!!");
            }
        }
    }

    public void chooseDateAndTime() {
        System.out.println("\t\tAvalibale time\n");
        String[] timeAndDay = {"Sun 4:30", "Mon 7:00", "Tues 10:30", "Wed 9:30", "Fri 7:00"};
        for (int i = 0; i < timeAndDay.length; i++) {

            System.out.print(i+1 + "-");
            System.out.println(timeAndDay[i]);
        }
        int choose;
        System.out.print("\nwaht is your choice? :");
        choose = input.nextInt();
        if (choose > 0 && choose - 1 < timeAndDay.length) {

            time = timeAndDay[choose-1];
            System.out.println("\nthe movie has been booked\n");
        }else{
            chooseDateAndTime();
        }
    }
    
    public void displayBooking(){
        System.out.println("\tinformation of booking\n");
        System.out.println("Customer Name: "+customer.getName()+"\n");
        
        System.out.println(movie.toString());
        for (int i = 0; i < snack.size(); i++) {
            System.out.println(snack.get(i).toString());
        }
    }

    public void updatePrice() {
        totalPrice = movie.getPrice();
        for (int i = 0; i < snack.size(); i++) {

            totalPrice += snack.get(i).getPrice();

        }

        tax = totalPrice * 0.15;
    }
    public String createBill(){
        
        String snacks="";
        
        for (int i = 0; i < snack.size(); i++) {
            
            snacks+=String.format("- %-20s $%s\n", snack.get(i).getName(),snack.get(i).getPrice());
            
        }
        
        String bill="\tBooking\n\n"+
                String.format("- %-20s $%s\n",movie.getName(),movie.getPrice())+
                snacks;
        updatePrice();
        bill +=String.format("\n- %-20s $%s\n","Total:",totalPrice+tax );
        return bill;
    }

    public ArrayList<Snack> getSnack() {
        return snack;
    }

    public void setSnack(ArrayList<Snack> snack) {
        this.snack = snack;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return createBill();
    }
    
    

}
