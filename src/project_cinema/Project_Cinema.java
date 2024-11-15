
package project_cinema;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.PrintWriter;


public class Project_Cinema {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {

        Scanner input = new Scanner(System.in);

        ArrayList<Customer> customers = new ArrayList<>();
        ArrayList<Booking> books = new ArrayList<>();

        ArrayList<Movie> movies = new ArrayList<>();
        ArrayList<Snack> snacks = new ArrayList<>();
        
        addItems(movies, snacks);
        
        
        String array[];
        try {
            File read = new File("file.txt");
            Scanner readFile = new Scanner(read);
            while (readFile.hasNextLine()) {
                String readArray = readFile.nextLine();
                array = readArray.split("_");
                Customer customer=new Customer(array[0],Integer.parseInt(array[1]));
                Booking book = new Booking(customer);
                for (Movie movie:movies) {
                    if (array[2].equals(movie.getName())) {
                        book.setMovie(movie);
                        book.setTime(array[3]);
                    }
                }
                for (int i =4;i<array.length;i++) {
                    for (Snack snack:snacks) {
                        if (array[i].equals(snack.getName())) {
                            book.snack.add(snack);
                        }
                    }
                }
                customers.add(customer);
                books.add(book);
            }
            readFile.close();
        } catch (Exception e) {

        }

        int choose;
        while (true) {

            System.out.println("\n\t\tWELCOME TO Movie cinema");

            System.out.println("1- Booking");
            System.out.println("2- Display Booking");
            System.out.println("0- EXIT");
            choose = input.nextInt();

            if (choose == 1) {

                System.out.println("Enter Name:");
                String name = input.next();
                System.out.println("Enter Phone number:");
                int phone = input.nextInt();

                System.out.println("Enter your Age:");
                int age = input.nextInt();

                if (age < 18) {
                    System.out.println("Sorry!, your are under age of 18");
                    System.exit(0);
                }

                Customer customer = new Customer(name, phone);

                Booking book = new Booking(customer);
                
                book.Display(snacks, movies);
                customers.add(customer);
                books.add(book);
                System.out.println(book.toString());
            } else if (choose == 2) {
                

                System.out.println("Enter customer phone number:");
                int phone = input.nextInt();
                boolean flag = false;
                for (int i = 0; i < customers.size(); i++) {
                    if (customers.get(i).getPhoneNumber() == phone) {
                        books.get(i).displayBooking();
                        flag = true;
                        break;
                    }

                }
                if (!flag) {
                    System.out.println("Phone number is wrong!\n");
                }

            } else if (choose == 0) {

                System.out.println("Thank You");
                PrintWriter printer = new PrintWriter("file.txt");
                for (int i = 0; i < customers.size(); i++) {

                    printer.print(customers.get(i).getName() + "_" + customers.get(i).getPhoneNumber());
                    printer.print("_" + books.get(i).getMovie().getName() + "_" + books.get(i).getTime());
                    for (Snack snack : books.get(i).snack) {

                        printer.print("_" + snack.getName());

                    }
                    printer.write("\n");
                }
                printer.close();
                break;

            } else {
                System.out.println("Error!,please enter valid input!\n");
            }

        }
    }

    public static void addItems(ArrayList<Movie> movies, ArrayList<Snack> snacks) {
        
        Movie movie = new Movie("Uncharted","Action",55);
        movies.add(movie);
        
        movie = new Movie("Spider man","Action",80);
        movies.add(movie);
        
        movie = new Movie("Sonic","Animation",65);
        movies.add(movie);
        
        movie = new Movie("The lost city","Comedy",110);
        movies.add(movie);
        
        movie = new Movie("The Godfather","Crime",80);
        movies.add(movie);
        
        Snack snack = new Snack("Lipton Ice tea","Drink",16);
        snacks.add(snack);
        
        snack = new Snack("Coca cola","Snack",16);
        snacks.add(snack);
        
        snack = new Snack("Nachos","Snack",40);
        snacks.add(snack);
        
        snack = new Snack("Popcorn","Snack",20);
        snacks.add(snack);
        
        snack = new Snack("Mozzarella sticks","Snack",26);
        snacks.add(snack);
        
    }


   

}
