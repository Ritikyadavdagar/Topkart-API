import java.time.*;

public class LightningDeal {
    private String productName;
    private double actualPrice;
    private double finalPrice;
    private int totalUnits;
    private int availableUnits;
    private LocalDateTime expiryTime;

    public LightningDeal(String productName, double actualPrice, double finalPrice, int totalUnits, int availableUnits, LocalDateTime expiryTime) {
        this.productName = productName;
        this.actualPrice = actualPrice;
        this.finalPrice = finalPrice;
        this.totalUnits = totalUnits;
        this.availableUnits = availableUnits;
        this.expiryTime = expiryTime;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getActualPrice() {
        return actualPrice;
    }

    public void setActualPrice(double actualPrice) {
        this.actualPrice = actualPrice;
    }

    public double getFinalPrice() {
        return finalPrice;
    }

    public void setFinalPrice(double finalPrice) {
        this.finalPrice = finalPrice;
    }

    public int getTotalUnits() {
        return totalUnits;
    }

    public void setTotalUnits(int totalUnits) {
        this.totalUnits = totalUnits;
    }

    public int getAvailableUnits() {
        return availableUnits;
    }

    public void setAvailableUnits(int availableUnits) {
        this.availableUnits = availableUnits;
    }

    public LocalDateTime getExpiryTime() {
        return expiryTime;
    }

    public void setExpiryTime(LocalDateTime expiryTime) {
        this.expiryTime = expiryTime;
    }
}
