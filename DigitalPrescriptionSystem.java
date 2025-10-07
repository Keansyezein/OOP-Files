package digitalprescriptionsystem;
import java.util.*;
import java.util.UUID;

public class DigitalPrescriptionSystem {
    // 🔹 Global storage for prescriptions
    static ArrayList<Prescription> prescriptions = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
    
        int choice;
        do {
            System.out.println("\n==== DIGITAL PRESCRIPTION MANAGEMENT SYSTEM ====");
            System.out.println("1. Doctor");
            System.out.println("2. Pharmacist");
            System.out.println("3. DOH");
            System.out.println("4. Exit");
            System.out.print("Choose: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 -> doctorMenu();
                case 2 -> pharmacistMenu();
                case 3 -> dohMenu();
                case 4 -> System.out.println("Exiting system...");
                default -> System.out.println("Invalid option!");
            }
        } while (choice != 4);
    }

    //  DOCTOR SECTION
    public static void doctorMenu() {
        System.out.print("\nEnter Doctor Name: ");
        String doctorName = sc.nextLine();

        System.out.print("Enter Patient Name: ");
        String patientName = sc.nextLine();

        System.out.print("Enter Medicine Name: ");
        String medName = sc.nextLine();

        System.out.print("Enter Dosage: ");
        String dosage = sc.nextLine();

        System.out.print("Enter Duration (e.g., 7 days): ");
        String duration = sc.nextLine();

        // Generate unique Prescription ID
        String prescID = UUID.randomUUID().toString().substring(0, 8);

        // Add new prescription
        Prescription p = new Prescription(prescID, doctorName, patientName, medName, dosage, duration);
        prescriptions.add(p);

        System.out.println("\n- Prescription Created Successfully!");
        System.out.println("Prescription ID (QR Code Reference): " + prescID);
        System.out.println("[QR CODE LINK] https://qrcode.show/" + prescID);
    }

    //  PHARMACIST SECTION
    static void pharmacistMenu() {
        System.out.print("\nEnter Prescription QR Code (ID) to Validate: ");
        String qr = sc.nextLine();

        Prescription found = null;
        for (Prescription p : prescriptions) {
            if (p.getId().equals(qr)) {
                found = p;
                break;
            }
        }

        if (found != null) {
            System.out.println("\n- QR Validated Successfully!");
            System.out.println("Doctor: " + found.getDoctor());
            System.out.println("Patient: " + found.getPatient());
            System.out.println("Medicine: " + found.getMedicine());
            System.out.println("Dosage: " + found.getDosage());
            System.out.println("Duration: " + found.getDuration());

            if (!found.isDelivered()) {
                System.out.print("\nDispense medicine to patient? (yes/no): ");
                String ans = sc.nextLine();
                if (ans.equalsIgnoreCase("yes")) {
                    found.setDelivered(true);
                    System.out.println("- Medicine delivered successfully!");
                } else if (ans.equalsIgnoreCase("no")) {
                    System.out.println("- Medicine not dispensed.");
                }
                else{
                    System.out.println("Sorry \"" + ans + "\" is not a valid input. Pls try again!");
                }
            } else {
                System.out.println("- This prescription was already delivered.");
            }
        } else {
            System.out.println("- Invalid or unknown QR code!");
        }
    }

    //  DOH SECTION
    static void dohMenu() {
        System.out.println("\n==== Department of Health - Prescription Records ====");
        if (prescriptions.isEmpty()) {
            System.out.println("No prescriptions found.");
            return;
        }

        for (Prescription p : prescriptions) {
            System.out.println("\nPrescription ID: " + p.getId());
            System.out.println("Doctor: " + p.getDoctor());
            System.out.println("Patient: " + p.getPatient());
            System.out.println("Medicine: " + p.getMedicine());
            System.out.println("Dosage: " + p.getDosage());
            System.out.println("Duration: " + p.getDuration());
            System.out.println("Delivered: " + (p.isDelivered() ? "Yes" : "No"));
        }
    }
}

//  PRESCRIPTION CLASS
class Prescription {
    private String id;
    private String doctor;
    private String patient;
    private String medicine;
    private String dosage;
    private String duration;
    private boolean delivered;

    public Prescription(String id, String doctor, String patient, String medicine, String dosage, String duration) {
        this.id = id;
        this.doctor = doctor;
        this.patient = patient;
        this.medicine = medicine;
        this.dosage = dosage;
        this.duration = duration;
        this.delivered = false;
    }

    // Getters
    public String getId() { return id; }
    public String getDoctor() { return doctor; }
    public String getPatient() { return patient; }
    public String getMedicine() { return medicine; }
    public String getDosage() { return dosage; }
    public String getDuration() { return duration; }
    public boolean isDelivered() { return delivered; }

    // Setter
    public void setDelivered(boolean delivered) { this.delivered = delivered; }
}
