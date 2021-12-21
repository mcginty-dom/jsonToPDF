public class Address {
    private String id;
    private String externalId;
    private String externalSource;
    private String street1;
    private String street2;
    private String street3;
    private String city;
    private String state;
    private String zip;
    private String country;
    private boolean residential;
    private String carrierFacility;
    private String name;
    private String company;
    private String phone;
    private String email;
    private String federalTaxId;
    private String stateTaxId;
    private String clientId;
    private boolean verified;
    private String defaultAddress;
    private String firstName;
    private String lastName;
    private String type;
    private String deliveryInstructions;

    public Address(String id, String externalId, String externalSource, String street1, String street2, String street3, String city, String state, String zip, String country, boolean residential, String carrierFacility, String name, String company, String phone, String email, String federalTaxId, String stateTaxId, String clientId, boolean verified, String defaultAddress, String firstName, String lastName, String type, String deliveryInstructions) {
        this.id = id;
        this.externalId = externalId;
        this.externalSource = externalSource;
        this.street1 = street1;
        this.street2 = street2;
        this.street3 = street3;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.country = country;
        this.residential = residential;
        this.carrierFacility = carrierFacility;
        this.name = name;
        this.company = company;
        this.phone = phone;
        this.email = email;
        this.federalTaxId = federalTaxId;
        this.stateTaxId = stateTaxId;
        this.clientId = clientId;
        this.verified = verified;
        this.defaultAddress = defaultAddress;
        this.firstName = firstName;
        this.lastName = lastName;
        this.type = type;
        this.deliveryInstructions = deliveryInstructions;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getExternalId() {
        return externalId;
    }

    public void setExternalId(String externalId) {
        this.externalId = externalId;
    }

    public String getExternalSource() {
        return externalSource;
    }

    public void setExternalSource(String externalSource) {
        this.externalSource = externalSource;
    }

    public String getStreet1() {
        return street1;
    }

    public void setStreet1(String street1) {
        this.street1 = street1;
    }

    public String getStreet2() {
        return street2;
    }

    public void setStreet2(String street2) {
        this.street2 = street2;
    }

    public String getStreet3() {
        return street3;
    }

    public void setStreet3(String street3) {
        this.street3 = street3;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public boolean isResidential() {
        return residential;
    }

    public void setResidential(boolean residential) {
        this.residential = residential;
    }

    public String getCarrierFacility() {
        return carrierFacility;
    }

    public void setCarrierFacility(String carrierFacility) {
        this.carrierFacility = carrierFacility;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFederalTaxId() {
        return federalTaxId;
    }

    public void setFederalTaxId(String federalTaxId) {
        this.federalTaxId = federalTaxId;
    }

    public String getStateTaxId() {
        return stateTaxId;
    }

    public void setStateTaxId(String stateTaxId) {
        this.stateTaxId = stateTaxId;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public boolean isVerified() {
        return verified;
    }

    public void setVerified(boolean verified) {
        this.verified = verified;
    }

    public String getDefaultAddress() {
        return defaultAddress;
    }

    public void setDefaultAddress(String defaultAddress) {
        this.defaultAddress = defaultAddress;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDeliveryInstructions() {
        return deliveryInstructions;
    }

    public void setDeliveryInstructions(String deliveryInstructions) {
        this.deliveryInstructions = deliveryInstructions;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id='" + id + '\'' +
                ", externalId='" + externalId + '\'' +
                ", externalSource='" + externalSource + '\'' +
                ", streetOne='" + street1 + '\'' +
                ", streetTwo='" + street2 + '\'' +
                ", streetThree='" + street3 + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zip='" + zip + '\'' +
                ", country='" + country + '\'' +
                ", residential=" + residential +
                ", carrierFacility='" + carrierFacility + '\'' +
                ", name='" + name + '\'' +
                ", company='" + company + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", federalTaxId='" + federalTaxId + '\'' +
                ", stateTaxId='" + stateTaxId + '\'' +
                ", clientId='" + clientId + '\'' +
                ", verified=" + verified +
                ", defaultAddress='" + defaultAddress + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", type='" + type + '\'' +
                ", deliveryInstructions='" + deliveryInstructions + '\'' +
                '}';
    }
}
