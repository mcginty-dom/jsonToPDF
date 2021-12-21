import java.util.Arrays;

public class Label {
    private String customerId;
    private String templateName;
    private String templateDescription;
    private Address fromAddress;
    private Address toAddress;
    private String batchJobId;
    private Item[] items;
    private ItemDescription[] itemDescriptions;
    private int totalWeight;
    private int totalChargeableWeight;
    private String goodsDescription;
    private String value;
    private String customerReference;
    private String enhancedLiability;
    private String currency;
    private String orderId;
    private boolean autoGenerateReference;
    private String dutyOrTaxPaidBy;
    private String reasonForExport;
    private String quoteId;
    private String shipmentId;
    private String selectedCourier;
    private String selectedCourierService;
    private boolean itemDescriptionAdded;
    private boolean pickupRequired;
    private boolean dropOffOrIncludeInOtherCollection;
    private int totalInvoiceValue;
    private Pickup pickupRequest;
    private String[] appliedRules;
    private String[] messages;
    private boolean createdByAdmin;
    private String selectedSurcharges;
    private String appliedRulesJsonString;
    private String quoteResponseItems;
    private String labelSize;
    private String shipmentMethod;
    private String shipperWarehouseName;
    private String shipperWarehouseCode;
    private String customFieldOne;
    private String customerFieldTwo;
    private boolean valid;
    private String externalCarrier;
    private String externalService;
    private boolean stackable;
    private boolean dangerousGoods;
    private boolean dryIce;
    private boolean saturdayDelivery;
    private boolean lithiumBatteries;
    private boolean enhancedLiabilityRequired;
    private boolean commercialInvoice;
    private String[] publicDescription;
    private boolean alternativeCollectionAddressSelected;
    private String routingCode;

    public Label() {

    }

    public Label(String customerId, String templateName, String templateDescription, Address fromAddress, Address toAddress, String batchJobId, Item[] items, ItemDescription[] itemDescriptions, int totalWeight, int totalChargeableWeight, String goodsDescription, String value, String customerReference, String enhancedLiability, String currency, String orderId, boolean autoGenerateReference, String dutyOrTaxPaidBy, String reasonForExport, String quoteId, String shipmentId, String selectedCourier, String selectedCourierService, boolean itemDescriptionAdded, boolean pickupRequired, boolean dropOffOrIncludeInOtherCollection, int totalInvoiceValue, Pickup pickupRequest, String[] appliedRules, String[] messages, boolean createdByAdmin, String selectedSurcharges, String appliedRulesJsonString, String quoteResponseItems, String labelSize, String shipmentMethod, String shipperWarehouseName, String shipperWarehouseCode, String customFieldOne, String customerFieldTwo, boolean valid, String externalCarrier, String externalService, boolean stackable, boolean dangerousGoods, boolean dryIce, boolean saturdayDelivery, boolean lithiumBatteries, boolean enhancedLiabilityRequired, boolean commercialInvoice, String[] publicDescription, boolean alternativeCollectionAddressSelected) {
        this.customerId = customerId;
        this.templateName = templateName;
        this.templateDescription = templateDescription;
        this.fromAddress = fromAddress;
        this.toAddress = toAddress;
        this.batchJobId = batchJobId;
        this.items = items;
        this.itemDescriptions = itemDescriptions;
        this.totalWeight = totalWeight;
        this.totalChargeableWeight = totalChargeableWeight;
        this.goodsDescription = goodsDescription;
        this.value = value;
        this.customerReference = customerReference;
        this.enhancedLiability = enhancedLiability;
        this.currency = currency;
        this.orderId = orderId;
        this.autoGenerateReference = autoGenerateReference;
        this.dutyOrTaxPaidBy = dutyOrTaxPaidBy;
        this.reasonForExport = reasonForExport;
        this.quoteId = quoteId;
        this.shipmentId = shipmentId;
        this.selectedCourier = selectedCourier;
        this.selectedCourierService = selectedCourierService;
        this.itemDescriptionAdded = itemDescriptionAdded;
        this.pickupRequired = pickupRequired;
        this.dropOffOrIncludeInOtherCollection = dropOffOrIncludeInOtherCollection;
        this.totalInvoiceValue = totalInvoiceValue;
        this.pickupRequest = pickupRequest;
        this.appliedRules = appliedRules;
        this.messages = messages;
        this.createdByAdmin = createdByAdmin;
        this.selectedSurcharges = selectedSurcharges;
        this.appliedRulesJsonString = appliedRulesJsonString;
        this.quoteResponseItems = quoteResponseItems;
        this.labelSize = labelSize;
        this.shipmentMethod = shipmentMethod;
        this.shipperWarehouseName = shipperWarehouseName;
        this.shipperWarehouseCode = shipperWarehouseCode;
        this.customFieldOne = customFieldOne;
        this.customerFieldTwo = customerFieldTwo;
        this.valid = valid;
        this.externalCarrier = externalCarrier;
        this.externalService = externalService;
        this.stackable = stackable;
        this.dangerousGoods = dangerousGoods;
        this.dryIce = dryIce;
        this.saturdayDelivery = saturdayDelivery;
        this.lithiumBatteries = lithiumBatteries;
        this.enhancedLiabilityRequired = enhancedLiabilityRequired;
        this.commercialInvoice = commercialInvoice;
        this.publicDescription = publicDescription;
        this.alternativeCollectionAddressSelected = alternativeCollectionAddressSelected;
        this.routingCode = generateRoutingCode();
    }

    //TODO: 2 digit iso for corresponding destination country
    private String getISO() {
        return "GB";
    }

    private String getFeatureID() {
        String routingCode = "";
        switch (this.getSelectedCourierService()) {
            case "XPRESS 24 POD":
                routingCode += "007"; //Handling codes 3
                break;
            case "XPRESS 24 NON POD":
                routingCode += "011"; //Handling codes 3
                break;
            case "XPRESS 48 POD":
                routingCode += "012"; //Handling codes 3
                break;
            case "XPRESS 48 NON POD":
                routingCode += "013"; //Handling codes 3
                break;
            case "XPRESS XS 48 NON POD":
                routingCode += "060"; //Handling codes 3
                break;
            case "XPECT 24 POD":
                routingCode += "020"; //Handling codes 3
                break;
            case "XPECT 24 NON POD":
                routingCode += "021"; //Handling codes 3
                break;
            case "XPECT 48 POD":
                routingCode += "022"; //Handling codes 3
                break;
            case "XPECT 48 NON POD":
                routingCode += "023"; //Handling codes 3
                break;
            case "XPECT 48 XL POD":
                routingCode += "024"; //Handling codes 3
                break;
            case "XPECT 48 XL NON POD":
                routingCode += "025"; //Handling codes 3
                break;
            case "XPECT SATURDAY POD":
                routingCode += "026"; //Handling codes 3
                break;
            case "XPECT SATURDAY NON POD":
                routingCode += "027"; //Handling codes 3
                break;
            case "XPECT 48 RETURN POD":
                routingCode += "028"; //Handling codes 3
                break;
            case "XPECT PRE 12 POD":
                routingCode += "085"; //Handling codes 3
                break;
            case "XPERT 24 POD DESK":
                routingCode += "077"; //Handling codes 3
                break;
            case "XPERT 24 ADDRESS ONLY":
                routingCode += "078"; //Handling codes 3
                break;
            case "XPERT 24 HVT POD":
                routingCode += "079"; //Handling codes 3
                break;
            case "XPERT 24 BFPO POD":
                routingCode += "080"; //Handling codes 3
                break;
            case "XPERT SATURDAY ADDRESS ONLY":
                routingCode += "095"; //Handling codes 3
                break;
            case "XPERT SATURDAY HVT POD":
                routingCode += "097"; //Handling codes 3
                break;
            case "XPERT SATURDAY POD EXCHANGE":
                routingCode += "083"; //Handling codes 3
                break;
            case "XPERT 24 POD EXCHANGE":
                routingCode += "084"; //Handling codes 3
                break;
            case "XPERT PRE 12 NON POD":
                routingCode += "086"; //Handling codes 3
                break;
            case "XPERT PRE 12 HVT ADDRESS ONLY":
                routingCode += "087"; //Handling codes 3
                break;
            default:
                System.out.println("default @ getService()");
                routingCode += "";
                break;
        }
        return routingCode;
    }

    public String getServiceCode() {
        String code = "";
        switch (this.getSelectedCourierService()) {
            case "XPRESS 24 POD":
                code += "1CP"; //Handling codes 3
                break;
            case "XPRESS 24 NON POD":
                code += "1CN"; //Handling codes 3
                break;
            case "XPRESS 48 POD":
                code += "2CP"; //Handling codes 3
                break;
            case "XPRESS 48 NON POD":
                code += "2CN"; //Handling codes 3
                break;
            case "XPRESS XS 48 NON POD":
                code += "2CXN"; //Handling codes 3
                break;
            case "XPECT 24 POD":
                code += "1VP"; //Handling codes 3
                break;
            case "XPECT 24 NON POD":
                code += "1VN"; //Handling codes 3
                break;
            case "XPECT 48 POD":
                code += "2VP"; //Handling codes 3
                break;
            case "XPECT 48 NON POD":
                code += "2VN"; //Handling codes 3
                break;
            case "XPECT 48 XL POD":
                code += "2VLP"; //Handling codes 3
                break;
            case "XPECT 48 XL NON POD":
                code += "2VLN"; //Handling codes 3
                break;
            case "XPECT SATURDAY POD":
                code += "1VSP"; //Handling codes 3
                break;
            case "XPECT SATURDAY NON POD":
                code += "1VSN"; //Handling codes 3
                break;
            case "XPECT 48 RETURN POD":
                code += "2VPR"; //Handling codes 3
                break;
            case "XPECT PRE 12 POD":
                code += "12P"; //Handling codes 3
                break;
            case "XPERT 24 POD DESK":
                code += "1VD"; //Handling codes 3
                break;
            case "XPERT 24 ADDRESS ONLY":
                code += "1VA"; //Handling codes 3
                break;
            case "XPERT 24 HVT POD":
                code += "1VT"; //Handling codes 3
                break;
            case "XPERT 24 BFPO POD":
                code += "1BFP"; //Handling codes 3
                break;
            case "XPERT SATURDAY ADDRESS ONLY":
                code += "1VSA"; //Handling codes 3
                break;
            case "XPERT SATURDAY HVT POD":
                code += "1VST"; //Handling codes 3
                break;
            case "XPERT SATURDAY POD EXCHANGE":
                code += "1VSX"; //Handling codes 3
                break;
            case "XPERT 24 POD EXCHANGE":
                code += "1VX"; //Handling codes 3
                break;
            case "XPERT PRE 12 NON POD":
                code += "12N"; //Handling codes 3
                break;
            case "XPERT PRE 12 HVT ADDRESS ONLY":
                code += "12T"; //Handling codes 3
                break;
            default:
                System.out.println("default @ getService()");
                code += "";
                break;
        }
        return code;
    }

    public String generateRoutingCode() {
        //"2LGBB11AA+01000024"
        String routingCode = "";
        routingCode += "2L"; //ANSI data identifier 2
        routingCode += getISO(); //ISO country code 2
        routingCode += this.getToAddress().getZip().replaceAll("\\s",""); //Postcode 5-9
        routingCode += "+"; //Field separator 1
        routingCode += "01"; //Product codes 2
        routingCode += "00"; //Date code 2
        routingCode += "0"; //Time code 1
        routingCode += getFeatureID(); //Handling codes 3
        return routingCode;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getTemplateName() {
        return templateName;
    }

    public void setTemplateName(String templateName) {
        this.templateName = templateName;
    }

    public String getTemplateDescription() {
        return templateDescription;
    }

    public void setTemplateDescription(String templateDescription) {
        this.templateDescription = templateDescription;
    }

    public Address getFromAddress() {
        return fromAddress;
    }

    public void setFromAddress(Address fromAddress) {
        this.fromAddress = fromAddress;
    }

    public Address getToAddress() {
        return toAddress;
    }

    public void setToAddress(Address toAddress) {
        this.toAddress = toAddress;
    }

    public String getBatchJobId() {
        return batchJobId;
    }

    public void setBatchJobId(String batchJobId) {
        this.batchJobId = batchJobId;
    }

    public Item[] getItems() {
        return items;
    }

    public void setItems(Item[] items) {
        this.items = items;
    }

    public ItemDescription[] getItemDescriptions() {
        return itemDescriptions;
    }

    public void setItemDescriptions(ItemDescription[] itemDescriptions) {
        this.itemDescriptions = itemDescriptions;
    }

    public int getTotalWeight() {
        return totalWeight;
    }

    public void setTotalWeight(int totalWeight) {
        this.totalWeight = totalWeight;
    }

    public int getTotalChargeableWeight() {
        return totalChargeableWeight;
    }

    public void setTotalChargeableWeight(int totalChargeableWeight) {
        this.totalChargeableWeight = totalChargeableWeight;
    }

    public String getGoodsDescription() {
        return goodsDescription;
    }

    public void setGoodsDescription(String goodsDescription) {
        this.goodsDescription = goodsDescription;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getCustomerReference() {
        return customerReference;
    }

    public void setCustomerReference(String customerReference) {
        this.customerReference = customerReference;
    }

    public String getEnhancedLiability() {
        return enhancedLiability;
    }

    public void setEnhancedLiability(String enhancedLiability) {
        this.enhancedLiability = enhancedLiability;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public boolean isAutoGenerateReference() {
        return autoGenerateReference;
    }

    public void setAutoGenerateReference(boolean autoGenerateReference) {
        this.autoGenerateReference = autoGenerateReference;
    }

    public String getDutyOrTaxPaidBy() {
        return dutyOrTaxPaidBy;
    }

    public void setDutyOrTaxPaidBy(String dutyOrTaxPaidBy) {
        this.dutyOrTaxPaidBy = dutyOrTaxPaidBy;
    }

    public String getReasonForExport() {
        return reasonForExport;
    }

    public void setReasonForExport(String reasonForExport) {
        this.reasonForExport = reasonForExport;
    }

    public String getQuoteId() {
        return quoteId;
    }

    public void setQuoteId(String quoteId) {
        this.quoteId = quoteId;
    }

    public String getShipmentId() {
        return shipmentId;
    }

    public void setShipmentId(String shipmentId) {
        this.shipmentId = shipmentId;
    }

    public String getSelectedCourier() {
        return selectedCourier;
    }

    public void setSelectedCourier(String selectedCourier) {
        this.selectedCourier = selectedCourier;
    }

    public String getSelectedCourierService() {
        return selectedCourierService;
    }

    public void setSelectedCourierService(String selectedCourierService) {
        this.selectedCourierService = selectedCourierService;
    }

    public boolean isItemDescriptionAdded() {
        return itemDescriptionAdded;
    }

    public void setItemDescriptionAdded(boolean itemDescriptionAdded) {
        this.itemDescriptionAdded = itemDescriptionAdded;
    }

    public boolean isPickupRequired() {
        return pickupRequired;
    }

    public void setPickupRequired(boolean pickupRequired) {
        this.pickupRequired = pickupRequired;
    }

    public boolean isDropOffOrIncludeInOtherCollection() {
        return dropOffOrIncludeInOtherCollection;
    }

    public void setDropOffOrIncludeInOtherCollection(boolean dropOffOrIncludeInOtherCollection) {
        this.dropOffOrIncludeInOtherCollection = dropOffOrIncludeInOtherCollection;
    }

    public int getTotalInvoiceValue() {
        return totalInvoiceValue;
    }

    public void setTotalInvoiceValue(int totalInvoiceValue) {
        this.totalInvoiceValue = totalInvoiceValue;
    }

    public Pickup getPickupRequest() {
        return pickupRequest;
    }

    public void setPickupRequest(Pickup pickupRequest) {
        this.pickupRequest = pickupRequest;
    }

    public String[] getAppliedRules() {
        return appliedRules;
    }

    public void setAppliedRules(String[] appliedRules) {
        this.appliedRules = appliedRules;
    }

    public String[] getMessages() {
        return messages;
    }

    public void setMessages(String[] messages) {
        this.messages = messages;
    }

    public boolean isCreatedByAdmin() {
        return createdByAdmin;
    }

    public void setCreatedByAdmin(boolean createdByAdmin) {
        this.createdByAdmin = createdByAdmin;
    }

    public String getSelectedSurcharges() {
        return selectedSurcharges;
    }

    public void setSelectedSurcharges(String selectedSurcharges) {
        this.selectedSurcharges = selectedSurcharges;
    }

    public String getAppliedRulesJsonString() {
        return appliedRulesJsonString;
    }

    public void setAppliedRulesJsonString(String appliedRulesJsonString) {
        this.appliedRulesJsonString = appliedRulesJsonString;
    }

    public String getQuoteResponseItems() {
        return quoteResponseItems;
    }

    public void setQuoteResponseItems(String quoteResponseItems) {
        this.quoteResponseItems = quoteResponseItems;
    }

    public String getLabelSize() {
        return labelSize;
    }

    public void setLabelSize(String labelSize) {
        this.labelSize = labelSize;
    }

    public String getShipmentMethod() {
        return shipmentMethod;
    }

    public void setShipmentMethod(String shipmentMethod) {
        this.shipmentMethod = shipmentMethod;
    }

    public String getShipperWarehouseName() {
        return shipperWarehouseName;
    }

    public void setShipperWarehouseName(String shipperWarehouseName) {
        this.shipperWarehouseName = shipperWarehouseName;
    }

    public String getShipperWarehouseCode() {
        return shipperWarehouseCode;
    }

    public void setShipperWarehouseCode(String shipperWarehouseCode) {
        this.shipperWarehouseCode = shipperWarehouseCode;
    }

    public String getCustomFieldOne() {
        return customFieldOne;
    }

    public void setCustomFieldOne(String customFieldOne) {
        this.customFieldOne = customFieldOne;
    }

    public String getCustomerFieldTwo() {
        return customerFieldTwo;
    }

    public void setCustomerFieldTwo(String customerFieldTwo) {
        this.customerFieldTwo = customerFieldTwo;
    }

    public boolean isValid() {
        return valid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }

    public String getExternalCarrier() {
        return externalCarrier;
    }

    public void setExternalCarrier(String externalCarrier) {
        this.externalCarrier = externalCarrier;
    }

    public String getExternalService() {
        return externalService;
    }

    public void setExternalService(String externalService) {
        this.externalService = externalService;
    }

    public boolean isStackable() {
        return stackable;
    }

    public void setStackable(boolean stackable) {
        this.stackable = stackable;
    }

    public boolean isDangerousGoods() {
        return dangerousGoods;
    }

    public void setDangerousGoods(boolean dangerousGoods) {
        this.dangerousGoods = dangerousGoods;
    }

    public boolean isDryIce() {
        return dryIce;
    }

    public void setDryIce(boolean dryIce) {
        this.dryIce = dryIce;
    }

    public boolean isSaturdayDelivery() {
        return saturdayDelivery;
    }

    public void setSaturdayDelivery(boolean saturdayDelivery) {
        this.saturdayDelivery = saturdayDelivery;
    }

    public boolean isLithiumBatteries() {
        return lithiumBatteries;
    }

    public void setLithiumBatteries(boolean lithiumBatteries) {
        this.lithiumBatteries = lithiumBatteries;
    }

    public boolean isEnhancedLiabilityRequired() {
        return enhancedLiabilityRequired;
    }

    public void setEnhancedLiabilityRequired(boolean enhancedLiabilityRequired) {
        this.enhancedLiabilityRequired = enhancedLiabilityRequired;
    }

    public boolean isCommercialInvoice() {
        return commercialInvoice;
    }

    public void setCommercialInvoice(boolean commercialInvoice) {
        this.commercialInvoice = commercialInvoice;
    }

    public String[] getPublicDescription() {
        return publicDescription;
    }

    public void setPublicDescription(String[] publicDescription) {
        this.publicDescription = publicDescription;
    }

    public boolean isAlternativeCollectionAddressSelected() {
        return alternativeCollectionAddressSelected;
    }

    public void setAlternativeCollectionAddressSelected(boolean alternativeCollectionAddressSelected) {
        this.alternativeCollectionAddressSelected = alternativeCollectionAddressSelected;
    }

    public String getRoutingCode() {
        return routingCode;
    }

    public void setRoutingCode(String routingCode) {
        this.routingCode = routingCode;
    }

    @Override
    public String toString() {
        return "Label{" +
                "customerId='" + customerId + '\'' +
                ", templateName='" + templateName + '\'' +
                ", templateDescription='" + templateDescription + '\'' +
                ", fromAddress=" + fromAddress.toString() +
                ", toAddress=" + toAddress.toString() +
                ", batchJobId='" + batchJobId + '\'' +
                ", items=" + Arrays.toString(items) +
                ", itemDescriptions=" + Arrays.toString(itemDescriptions) +
                ", totalWeight=" + totalWeight +
                ", totalChargeableWeight=" + totalChargeableWeight +
                ", goodsDescription='" + goodsDescription + '\'' +
                ", value='" + value + '\'' +
                ", customerReference='" + customerReference + '\'' +
                ", enhancedLiability='" + enhancedLiability + '\'' +
                ", currency='" + currency + '\'' +
                ", orderId='" + orderId + '\'' +
                ", autoGenerateReference=" + autoGenerateReference +
                ", dutyOrTaxPaidBy='" + dutyOrTaxPaidBy + '\'' +
                ", reasonForExport='" + reasonForExport + '\'' +
                ", quoteId='" + quoteId + '\'' +
                ", shipmentId='" + shipmentId + '\'' +
                ", selectedCourier='" + selectedCourier + '\'' +
                ", selectedCourierService='" + selectedCourierService + '\'' +
                ", itemDescriptionAdded=" + itemDescriptionAdded +
                ", pickupRequired=" + pickupRequired +
                ", dropOffOrIncludeInOtherCollection=" + dropOffOrIncludeInOtherCollection +
                ", totalInvoiceValue=" + totalInvoiceValue +
                ", pickupRequest=" + pickupRequest.toString() +
                ", appliedRules=" + Arrays.toString(appliedRules) +
                ", messages=" + Arrays.toString(messages) +
                ", createdByAdmin=" + createdByAdmin +
                ", selectedSurcharges='" + selectedSurcharges + '\'' +
                ", appliedRulesJsonString='" + appliedRulesJsonString + '\'' +
                ", quoteResponseItems='" + quoteResponseItems + '\'' +
                ", labelSize='" + labelSize + '\'' +
                ", shipmentMethod='" + shipmentMethod + '\'' +
                ", shipperWarehouseName='" + shipperWarehouseName + '\'' +
                ", shipperWarehouseCode='" + shipperWarehouseCode + '\'' +
                ", customFieldOne='" + customFieldOne + '\'' +
                ", customerFieldTwo='" + customerFieldTwo + '\'' +
                ", valid=" + valid +
                ", externalCarrier='" + externalCarrier + '\'' +
                ", externalService='" + externalService + '\'' +
                ", stackable=" + stackable +
                ", dangerousGoods=" + dangerousGoods +
                ", dryIce=" + dryIce +
                ", saturdayDelivery=" + saturdayDelivery +
                ", lithiumBatteries=" + lithiumBatteries +
                ", enhancedLiabilityRequired=" + enhancedLiabilityRequired +
                ", commercialInvoice=" + commercialInvoice +
                ", publicDescription=" + Arrays.toString(publicDescription) +
                ", alternativeCollectionAddressSelected=" + alternativeCollectionAddressSelected +
                ", routingCode=" + routingCode +
                '}';
    }
}
