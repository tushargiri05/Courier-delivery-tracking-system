// Parcel.java
// Represents a courier parcel with tracking details

public class Parcel {

    // Private fields - Encapsulation
    private String parcelId;
    private String senderName;
    private String receiverName;
    private String destination;
    private String status;

    // Constructor - initializes parcel with default status "Dispatched"
    public Parcel(String parcelId, String senderName, String receiverName, String destination) {
        this.parcelId = parcelId;
        this.senderName = senderName;
        this.receiverName = receiverName;
        this.destination = destination;
        this.status = "Dispatched"; // Default status
    }

    // Method to update delivery status
    public void updateStatus(String newStatus) {
        this.status = newStatus;
    }

    // Getter methods
    public String getParcelId() {
        return parcelId;
    }

    public String getSenderName() {
        return senderName;
    }

    public String getReceiverName() {
        return receiverName;
    }

    public String getDestination() {
        return destination;
    }

    public String getStatus() {
        return status;
    }

    // Display parcel details
    public void displayDetails() {
        System.out.println("----------------------------------------");
        System.out.println("  Parcel ID     : " + parcelId);
        System.out.println("  Sender        : " + senderName);
        System.out.println("  Receiver      : " + receiverName);
        System.out.println("  Destination   : " + destination);
        System.out.println("  Status        : " + status);
        System.out.println("----------------------------------------");
    }
}