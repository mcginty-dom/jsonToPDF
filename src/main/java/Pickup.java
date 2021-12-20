public class Pickup {
    private String reference;
    private String minDateTime;
    private String maxDateTime;
    private String instructions;
    private String collectionDate;

    public Pickup(String reference, String minDateTime, String maxDateTime, String instructions, String collectionDate) {
        this.reference = reference;
        this.minDateTime = minDateTime;
        this.maxDateTime = maxDateTime;
        this.instructions = instructions;
        this.collectionDate = collectionDate;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getMinDateTime() {
        return minDateTime;
    }

    public void setMinDateTime(String minDateTime) {
        this.minDateTime = minDateTime;
    }

    public String getMaxDateTime() {
        return maxDateTime;
    }

    public void setMaxDateTime(String maxDateTime) {
        this.maxDateTime = maxDateTime;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    public String getCollectionDate() {
        return collectionDate;
    }

    public void setCollectionDate(String collectionDate) {
        this.collectionDate = collectionDate;
    }

    @Override
    public String toString() {
        return "Pickup{" +
                "reference='" + reference + '\'' +
                ", minDateTime='" + minDateTime + '\'' +
                ", maxDateTime='" + maxDateTime + '\'' +
                ", instructions='" + instructions + '\'' +
                ", collectionDate='" + collectionDate + '\'' +
                '}';
    }
}
