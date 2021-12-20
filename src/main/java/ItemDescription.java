public class ItemDescription {
    private String description;
    private String commodityCode;
    private String sku;
    private int quantity;
    private int value;
    private String currency;
    private float weight;
    private String countryOfOrigin;
    private String manufacturerDetails;
    private String lineValue;

    public ItemDescription(String description, String commodityCode, String sku, int quantity, int value, String currency, float weight, String countryOfOrigin, String manufacturerDetails, String lineValue) {
        this.description = description;
        this.commodityCode = commodityCode;
        this.sku = sku;
        this.quantity = quantity;
        this.value = value;
        this.currency = currency;
        this.weight = weight;
        this.countryOfOrigin = countryOfOrigin;
        this.manufacturerDetails = manufacturerDetails;
        this.lineValue = lineValue;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCommodityCode() {
        return commodityCode;
    }

    public void setCommodityCode(String commodityCode) {
        this.commodityCode = commodityCode;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public String getCountryOfOrigin() {
        return countryOfOrigin;
    }

    public void setCountryOfOrigin(String countryOfOrigin) {
        this.countryOfOrigin = countryOfOrigin;
    }

    public String getManufacturerDetails() {
        return manufacturerDetails;
    }

    public void setManufacturerDetails(String manufacturerDetails) {
        this.manufacturerDetails = manufacturerDetails;
    }

    public String getLineValue() {
        return lineValue;
    }

    public void setLineValue(String lineValue) {
        this.lineValue = lineValue;
    }

    @Override
    public String toString() {
        return "ItemDescription{" +
                "description='" + description + '\'' +
                ", commodityCode='" + commodityCode + '\'' +
                ", sku='" + sku + '\'' +
                ", quantity=" + quantity +
                ", value=" + value +
                ", currency='" + currency + '\'' +
                ", weight=" + weight +
                ", countryOfOrigin='" + countryOfOrigin + '\'' +
                ", manufacturerDetails='" + manufacturerDetails + '\'' +
                ", lineValue='" + lineValue + '\'' +
                '}';
    }
}
