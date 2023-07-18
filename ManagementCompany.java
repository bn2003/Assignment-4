/*
 * Class: CMSC203 
 * Instructor: Ashique Tanveer
 * Description: (Give a brief description for each Class)
 * Due: 7/17/2023
 * Platform/compiler:
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Nguyen Tran
*/

public class ManagementCompany {
    static final int MAX_PROPERTY = 5;
    private static final int MGMT_WIDTH = 10;
    private static final int MGMT_DEPTH = 10;

    private String name;
    private String taxID;
    private double mgmFeePer;
    private Plot plot;
    private Property[] properties;
    private int propertyCount;

    // Constructors
    public ManagementCompany() {
        this("", "", 0.0);
    }

    public ManagementCompany(String name, String taxID, double mgmFeePer) {
        this(name, taxID, mgmFeePer, 0, 0, MGMT_WIDTH, MGMT_DEPTH);
    }

    public ManagementCompany(String name, String taxID, double mgmFeePer, int x, int y, int width, int depth) {
        this.name = name;
        this.taxID = taxID;
        this.mgmFeePer = mgmFeePer;
        this.plot = new Plot(x, y, width, depth);
        this.properties = new Property[MAX_PROPERTY];
        this.propertyCount = 0;
    }

    public ManagementCompany(ManagementCompany otherCompany) {
        this.name = otherCompany.name;
        this.taxID = otherCompany.taxID;
        this.mgmFeePer = otherCompany.mgmFeePer;
        this.plot = new Plot(otherCompany.plot);
        this.properties = new Property[MAX_PROPERTY];
        this.propertyCount = otherCompany.propertyCount;

        // Copy properties from the other company
        for (int i = 0; i < otherCompany.propertyCount; i++) {
            this.properties[i] = new Property(otherCompany.properties[i]);
        }
    }

    // Methods

    public int addProperty(String name, String city, double rent, String owner) {
        return addProperty(new Property(name, city, rent, owner));
    }

    public int addProperty(String name, String city, double rent, String owner, int x, int y, int width, int depth) {
        return addProperty(new Property(name, city, rent, owner, x, y, width, depth));
    }

    public int addProperty(Property property) {
        if (property == null) {
            return -2; // Property object is null
        }

        if (!plot.encompasses(property.getPlot())) {
            return -3; // Management company does not encompass the property plot
        }

        for (int i = 0; i < propertyCount; i++) {
            if (property.getPlot().overlaps(properties[i].getPlot())) {
                return -4; // Property plot overlaps any of the properties in the array
            }
        }

        if (propertyCount >= MAX_PROPERTY) {
            return -1; // Array is full
        }

        properties[propertyCount] = property;
        propertyCount++;
        return propertyCount - 1;
    }

    public void removeLastProperty() {
        if (propertyCount > 0) {
            properties[propertyCount - 1] = null;
            propertyCount--;
        }
    }

    public boolean isPropertiesFull() {
        return propertyCount >= MAX_PROPERTY;
    }

    public int getPropertiesCount() {
        return propertyCount;
    }

    public double getTotalRent() {
        double totalRent = 0.0;
        for (int i = 0; i < propertyCount; i++) {
            totalRent += properties[i].getRentAmount();
        }
        return totalRent;
    }

    public Property getHighestRentPropperty() {
        if (propertyCount == 0) {
            return null;
        }

        Property highestRentProperty = properties[0];
        for (int i = 1; i < propertyCount; i++) {
            if (properties[i].getRentAmount() > highestRentProperty.getRentAmount()) {
                highestRentProperty = properties[i];
            }
        }

        return highestRentProperty;
    }

    public boolean isManagementFeeValid() {
        return mgmFeePer >= 0.0 && mgmFeePer <= 100.0;
    }

    // Getters

    public String getName() {
        return name;
    }

    public String getTaxID() {
        return taxID;
    }

    public double getMgmFeePer() {
        return mgmFeePer;
    }

    public Plot getPlot() {
        return plot;
    }

    public Property[] getProperties() {
        return properties;
    }

    // toString

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Management Company: ").append(name).append(", TaxID: ").append(taxID).append(", Management Fee: ")
          .append(mgmFeePer).append("%\n");
        for (int i = 0; i < propertyCount; i++) {
            sb.append(properties[i].toString()).append("\n");
        }
        return sb.toString();
    }
}
