package group3finalss;

import java.util.Scanner;

public class Distributor {
     // View prescriptions that are not yet delivered
    public void viewUndelivered() {
        System.out.println("\n--- Undelivered Prescriptions ---");
        boolean found = false;
        for (Prescription p : Prescription.all) {
            if (!p.delivered) {
                System.out.println(p);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No undelivered prescriptions.");
        }
    }

    // Deliver a prescription by id (simple console-based selection)
    public void deliverById(int id) {
        for (Prescription p : Prescription.all) {
            if (p.id == id) {
                if (p.delivered) {
                    System.out.println("Prescription ID " + id + " is already delivered.");
                } else {
                    p.markDelivered();
                    System.out.println("Delivered prescription ID " + id + " to Pharmacist.");
                }
                return;
            }
        }
        System.out.println("Prescription ID " + id + " not found.");
    }

    // Simple helper combined: show list then deliver selected id
    public void deliverInteractive(Scanner sc) {
        viewUndelivered();
        System.out.print("Enter prescription ID to deliver (or 0 to cancel): ");
        String s = sc.nextLine().trim();
        try {
            int id = Integer.parseInt(s);
            if (id == 0) {
                System.out.println("Delivery canceled.");
                return;
            }
            deliverById(id);
        } catch (NumberFormatException e) {
            System.out.println("Invalid number.");
        }
    }
}
