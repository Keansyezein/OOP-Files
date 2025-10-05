package group3finalss;

import java.util.Scanner;

public class Pharmacist {
    public void viewDelivered() {
        System.out.println("\n--- Delivered Prescriptions ---");
        boolean found = false;
        for (Prescription p : Prescription.all) {
            if (p.delivered) {
                System.out.println(p);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No delivered prescriptions yet.");
        }
    }

    // Dispense by id (only if delivered and not yet dispensed)
    public void dispenseById(int id) {
        for (Prescription p : Prescription.all) {
            if (p.id == id) {
                if (!p.delivered) {
                    System.out.println("Cannot dispense: prescription ID " + id + " has not been delivered.");
                } else if (p.dispensed) {
                    System.out.println("Prescription ID " + id + " is already dispensed.");
                } else {
                    p.markDispensed();
                    System.out.println("Dispensed prescription ID " + id + " to patient " + p.patientName + ".");
                }
                return;
            }
        }
        System.out.println("Prescription ID " + id + " not found.");
    }

    // Interactive helper for console
    public void dispenseInteractive(Scanner sc) {
        viewDelivered();
        System.out.print("Enter prescription ID to dispense (or 0 to cancel): ");
        String s = sc.nextLine().trim();
        try {
            int id = Integer.parseInt(s);
            if (id == 0) {
                System.out.println("Dispense canceled.");
                return;
            }
            dispenseById(id);
        } catch (NumberFormatException e) {
            System.out.println("Invalid number.");
        }
    }
}
