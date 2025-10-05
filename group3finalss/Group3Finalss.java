package group3finalss;

import java.util.Scanner;

public class Group3Finalss {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Doctor doctor = new Doctor();
        Distributor distributor = new Distributor();
        Pharmacist pharmacist = new Pharmacist();
        Patient patient = new Patient();
        DOH doh = new DOH();

        System.out.println("=== Simple Prescription System (Beginner Friendly) ===");
        System.out.println("Sample prescriptions are already loaded.");

        while (true) {
            System.out.println("\n--- Main Menu ---");
            System.out.println("1. Doctor");
            System.out.println("2. Distributor");
            System.out.println("3. Pharmacist");
            System.out.println("4. Patient");
            System.out.println("5. DOH");
            System.out.println("6. Exit");
            System.out.print("Choose a role: ");
            String choice = sc.nextLine().trim();

            switch (choice) {
                case "1":
                    // Doctor menu: create
                    System.out.println("\n-- Doctor --");
                    System.out.print("Patient name: ");
                    String pn = sc.nextLine().trim();
                    System.out.print("Medicine: ");
                    String med = sc.nextLine().trim();
                    System.out.print("Dosage: ");
                    String dos = sc.nextLine().trim();
                    System.out.print("Duration: ");
                    String dur = sc.nextLine().trim();
                    doctor.createPrescription(pn, med, dos, dur);
                    break;

                case "2":
                    // Distributor menu: view undelivered and deliver
                    System.out.println("\n-- Distributor --");
                    System.out.println("1) View undelivered");
                    System.out.println("2) Deliver by ID");
                    System.out.println("0) Back");
                    System.out.print("Choose: ");
                    String dChoice = sc.nextLine().trim();
                    if ("1".equals(dChoice)) {
                        distributor.viewUndelivered();
                    } else if ("2".equals(dChoice)) {
                        distributor.deliverInteractive(sc);
                    }
                    break;

                case "3":
                    // Pharmacist menu: view delivered and dispense
                    System.out.println("\n-- Pharmacist --");
                    System.out.println("1) View delivered (ready to dispense)");
                    System.out.println("2) Dispense by ID");
                    System.out.println("0) Back");
                    System.out.print("Choose: ");
                    String pChoice = sc.nextLine().trim();
                    if ("1".equals(pChoice)) {
                        pharmacist.viewDelivered();
                    } else if ("2".equals(pChoice)) {
                        pharmacist.dispenseInteractive(sc);
                    }
                    break;

                case "4":
                    // Patient menu: view own prescriptions
                    System.out.println("\n-- Patient --");
                    System.out.print("Enter your name: ");
                    String name = sc.nextLine().trim();
                    patient.viewByName(name);
                    break;

                case "5":
                    // DOH menu: view all prescriptions
                    System.out.println("\n-- DOH --");
                    doh.viewAllPrescriptions();
                    break;

                case "6":
                    System.out.println("Exiting. Goodbye!");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
