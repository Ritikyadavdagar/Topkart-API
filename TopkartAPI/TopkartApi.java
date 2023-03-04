import java.time.LocalDateTime;
import java.util.*;

public class TopkartApi {
    private Map<String, LightningDeal> lightningDeals;
    private List<Order> orders;
    private LocalDateTime time;
    private static final int MAX_DEAL_EXPIRY = 12 * 60 * 60 * 1000; // 12 hours in milliseconds
    
    public TopkartApi() {
        lightningDeals = new HashMap<>();
        orders = new ArrayList<>();
    }

    private Order getOrder(String orderId) {
        for (Order order : orders) {
            if (order.getOrderId().equals(orderId)) {
                return order;
            }
        }
        return null;
    }
    
    // Admin actions
    public void createLightningDeal(String productName, double actualPrice, double finalPrice, int totalUnits, int availableUnits, LocalDateTime expiryTime) {
        if (expiryTime.getNano() < System.currentTimeMillis() || expiryTime.getNano() - System.currentTimeMillis() > MAX_DEAL_EXPIRY) {
            throw new IllegalArgumentException("Invalid expiry time");
        }
        
        LightningDeal deal = new LightningDeal(productName, actualPrice, finalPrice, totalUnits, availableUnits, expiryTime);
        lightningDeals.put(productName, deal);
    }
    
    public void updateLightningDeal(String productName, double actualPrice, double finalPrice, int totalUnits, int availableUnits, LocalDateTime expiryTime) {
        if (!lightningDeals.containsKey(productName)) {
            throw new IllegalArgumentException("Lightning deal does not exist");
        }
        
        if (expiryTime.getNano() < System.currentTimeMillis() || expiryTime.getNano() - System.currentTimeMillis() > MAX_DEAL_EXPIRY) {
            throw new IllegalArgumentException("Invalid expiry time");
        }
        
        LightningDeal deal = new LightningDeal(productName, actualPrice, finalPrice, totalUnits, availableUnits, expiryTime);
        lightningDeals.put(productName, deal);
    }
    
    public void approveOrder(String orderId) {
        Order order = getOrder(orderId);
        if (order != null) {
            order.setApproved(true);;
        }
    }
    
    // Customer actions
    public List<LightningDeal> getAvailableDeals() {
        List<LightningDeal> availableDeals = new ArrayList<>();
        for (LightningDeal deal : lightningDeals.values()) {
            if (deal.getExpiryTime().getNano() > System.currentTimeMillis() && deal.getAvailableUnits() > 0) {
                availableDeals.add(deal);
            }
        }
        return availableDeals;
    }
    
    public String placeOrder(String productName, int quantity) {
        LightningDeal deal = lightningDeals.get(productName);
        if (deal == null || deal.getExpiryTime().getNano() < System.currentTimeMillis() || deal.getAvailableUnits() < quantity) {
            return null;
        }
        
        Order order = new Order(UUID.randomUUID().toString(), productName, deal.getFinalPrice(), quantity, time.now(), false);
        orders.add(order);
        deal.setAvailableUnits(deal.getAvailableUnits() - quantity);
        
        return order.getOrderId();
    }

    public String getOrderStatus(String orderId){
        Order order = getOrder(orderId);
        if (order!=null) {
            if (order.isApproved()) {
                return "Approved";
            } else {
                return "Not approved";
            }
        } else {
            return "Order not found";
        }
    }
}

