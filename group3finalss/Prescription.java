package group3finalss;

import java.util.ArrayList;

public class Prescription {
    public int id;                 // simple id to reference a prescription
    public String patientName;
    public String medicine;
    public String dosage;
    public String duration;
    public boolean delivered;      // set true when Distributor delivers to Pharmacist
    public boolean dispensed;      // set true when Pharmacist dispenses to patient

    // Global list of all prescriptions (shared by all roles)
    public static ArrayList<Prescription> all = new ArrayList<>();

    // For creating simple incremental ids
    private static int nextId = 1;

    public Prescription(String patientName, String medicine, String dosage, String duration) {
        this.id = nextId++;
        this.patientName = patientName;
        this.medicine = medicine;
        this.dosage = dosage;
        this.duration = duration;
        this.delivered = false;
        this.dispensed = false;
    }

    // Helper: mark as delivered
    public void markDelivered() {
        this.delivered = true;
    }

    // Helper: mark as dispensed
    public void markDispensed() {
        this.dispensed = true;
    }

    @Override
    public String toString() {
        return "ID:" + id +
               " | Patient: " + patientName +
               " | Medicine: " + medicine +
               " | Dosage: " + dosage +
               " | Duration: " + duration +
               " | Delivered: " + (delivered ? "Yes" : "No") +
               " | Dispensed: " + (dispensed ? "Yes" : "No");
    }

    // Add 3 sample prescriptions for quick testing
    static {
        Prescription p1 = new Prescription("John", "Paracetamol 500mg", "1 tablet x 3/day", "3 days");
        Prescription p2 = new Prescription("Maria", "Amoxicillin 250mg", "1 capsule x 3/day", "7 days");
        Prescription p3 = new Prescription("Alex", "Cetirizine 10mg", "1 tablet once", "1 day");

        all.add(p1);
        all.add(p2);
        all.add(p3);
    }
}
