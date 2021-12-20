public class Item {
    private int quantity;
    private String boxType;
    private float length;
    private float width;
    private float height;
    private float weight;
    private String shipmentLabel;
    private float totalValue;

    public Item(int quantity, String boxType, float length, float width, float height, float weight, String shipmentLabel, float totalValue) {
        this.quantity = quantity;
        this.boxType = boxType;
        this.length = length;
        this.width = width;
        this.height = height;
        this.weight = weight;
        this.shipmentLabel = shipmentLabel;
        this.totalValue = totalValue;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getBoxType() {
        return boxType;
    }

    public void setBoxType(String boxType) {
        this.boxType = boxType;
    }

    public float getLength() {
        return length;
    }

    public void setLength(float length) {
        this.length = length;
    }

    public float getWidth() {
        return width;
    }

    public void setWidth(float width) {
        this.width = width;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public String getShipmentLabel() {
        return shipmentLabel;
    }

    public void setShipmentLabel(String shipmentLabel) {
        this.shipmentLabel = shipmentLabel;
    }

    public float getTotalValue() {
        return totalValue;
    }

    public void setTotalValue(float totalValue) {
        this.totalValue = totalValue;
    }

    @Override
    public String toString() {
        return "Item{" +
                "quantity=" + quantity +
                ", boxType='" + boxType + '\'' +
                ", length=" + length +
                ", width=" + width +
                ", height=" + height +
                ", weight=" + weight +
                ", shipmentLabel='" + shipmentLabel + '\'' +
                ", totalValue=" + totalValue +
                '}';
    }
}
