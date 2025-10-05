package group3finalss;

public class Doctor {
    // Create a new prescription and add it to the global list
    public void createPrescription(String patientName, String medicine, String dosage, String duration) {
        Prescription p = new Prescription(patientName, medicine, dosage, duration);
        Prescription.all.add(p);
        System.out.println("Prescription created. ID: " + p.id);
}
}