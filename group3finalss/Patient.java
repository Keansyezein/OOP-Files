package group3finalss;

public class Patient {
     public void viewByName(String patientName) {
        System.out.println("\n--- Prescriptions for " + patientName + " ---");
        boolean found = false;
        for (Prescription p : Prescription.all) {
            if (p.patientName.equalsIgnoreCase(patientName)) {
                System.out.println(p);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No prescriptions found for " + patientName + ".");
        }
    }
}
