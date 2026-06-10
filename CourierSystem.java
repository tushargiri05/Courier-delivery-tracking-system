// CourierSystem.java
// Main class - Entry point for the Courier Delivery Tracking System

import java.util.ArrayList;
import java.util.Scanner;

public class CourierSystem {

    // ArrayList to store all parcels
    static ArrayList<Parcel> parcelList = new ArrayList<>();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Pre-load some sample parcels for demonstration
        loadSampleData();

        int choice;

        System.out.println("========================================");
        System.out.println("   COURIER DELIVERY TRACKING SYSTEM     ");
        System.out.println("========================================");

        do {
            System.out.println("\n-------------- MAIN MENU ---------------");
            System.out.println("  1. Add New Parcel");
            System.out.println("  2. Track Parcel by ID");
            System.out.println("  3. Update Parcel Status");
            System.out.println("  4. View All Parcels");
            System.out.println("  5. Exit");
            System.out.println("----------------------------------------");
            System.out.print("  Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    addParcel(sc);
                    break;
                case 2:
                    trackParcel(sc);
                    break;
                case 3:
                    updateParcelStatus(sc);
                    break;
                case 4:
                    viewAllParcels();
                    break;
                case 5:
                    System.out.println("\n  Thank you for using Courier Tracking System!");
                    System.out.println("  Goodbye!\n");
                    break;
                default:
                    System.out.println("  Invalid choice! Please try again.");
            }

        } while (choice != 5);

        sc.close();
    }

    // -----------------------------------------------
    // Method to add a new parcel
    // -----------------------------------------------
    static void addParcel(Scanner sc) {
        System.out.println("\n---------- ADD NEW PARCEL ----------");
        System.out.print("  Enter Parcel ID   : ");
        String id = sc.nextLine().toUpperCase();

        // Check if ID already exists
        if (searchParcel(id) != null) {
            System.out.println("  Parcel ID already exists! Try a different ID.");
            return;
        }

        System.out.print("  Enter Sender Name : ");
        String sender = sc.nextLine();

        System.out.print("  Enter Receiver Name: ");
        String receiver = sc.nextLine();

        System.out.print("  Enter Destination : ");
        String destination = sc.nextLine();

        Parcel newParcel = new Parcel(id, sender, receiver, destination);
        parcelList.add(newParcel);

        System.out.println("\n  Parcel added successfully! Status: Dispatched");
    }

    // -----------------------------------------------
    // Method to track parcel by ID
    // -----------------------------------------------
    static void trackParcel(Scanner sc) {
        System.out.println("\n---------- TRACK PARCEL ----------");
        System.out.print("  Enter Parcel ID: ");
        String id = sc.nextLine().toUpperCase();

        Parcel found = searchParcel(id);

        if (found != null) {
            System.out.println("\n  Parcel Found!");
            found.displayDetails();
        } else {
            System.out.println("  Parcel with ID '" + id + "' not found.");
        }
    }

    // -----------------------------------------------
    // Method to update delivery status
    // -----------------------------------------------
    static void updateParcelStatus(Scanner sc) {
        System.out.println("\n---------- UPDATE PARCEL STATUS ----------");
        System.out.print("  Enter Parcel ID: ");
        String id = sc.nextLine().toUpperCase();

        Parcel found = searchParcel(id);

        if (found != null) {
            System.out.println("  Current Status: " + found.getStatus());
            System.out.println("\n  Select New Status:");
            System.out.println("    1. Dispatched");
            System.out.println("    2. In Transit");
            System.out.println("    3. Out for Delivery");
            System.out.println("    4. Delivered");
            System.out.print("  Enter choice: ");
            int statusChoice = sc.nextInt();
            sc.nextLine();

            String[] statuses = {"Dispatched", "In Transit", "Out for Delivery", "Delivered"};

            if (statusChoice >= 1 && statusChoice <= 4) {
                found.updateStatus(statuses[statusChoice - 1]);
                System.out.println("  Status updated to: " + found.getStatus());
            } else {
                System.out.println("  Invalid status choice!");
            }
        } else {
            System.out.println("  Parcel with ID '" + id + "' not found.");
        }
    }

    // -----------------------------------------------
    // Method to display all parcels
    // -----------------------------------------------
    static void viewAllParcels() {
        if (parcelList.isEmpty()) {
            System.out.println("\n  No parcels in the system.");
            return;
        }

        System.out.println("\n---------- ALL PARCELS ----------");
        System.out.println("Total Parcels: " + parcelList.size());
        for (Parcel p : parcelList) {
            p.displayDetails();
        }
    }

    // -----------------------------------------------
    // Search parcel by ID (returns null if not found)
    // -----------------------------------------------
    static Parcel searchParcel(String id) {
        for (Parcel p : parcelList) {
            if (p.getParcelId().equalsIgnoreCase(id)) {
                return p;
            }
        }
        return null;
    }

    // -----------------------------------------------
    // Pre-load sample data for testing/demo
    // -----------------------------------------------
    static void loadSampleData() {
        Parcel p1 = new Parcel("P101", "Ravi Kumar", "Anita Sharma", "Mumbai");
        p1.updateStatus("In Transit");

        Parcel p2 = new Parcel("P102", "Suresh Mehta", "Priya Nair", "Bangalore");
        p2.updateStatus("Delivered");

        Parcel p3 = new Parcel("P103", "Deepak Verma", "Neha Singh", "Delhi");
        p3.updateStatus("Out for Delivery");

        Parcel p4 = new Parcel("P104", "Arjun Das", "Kavya Menon", "Chennai");
        // Status remains "Dispatched" (default)

        parcelList.add(p1);
        parcelList.add(p2);
        parcelList.add(p3);
        parcelList.add(p4);
    }
}

