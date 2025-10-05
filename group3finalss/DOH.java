package group3finalss;

public class DOH {
     public void viewAllPrescriptions() {
        System.out.println("\n=== DOH: All Prescriptions ===");
        if (Prescription.all.isEmpty()) {
            System.out.println("No prescriptions in the system.");
            return;
        }
        for (Prescription p : Prescription.all) {
            System.out.println(p);
        }
    }
}
