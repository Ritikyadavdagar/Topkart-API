# Topkart-API

### Lightning Deal class

We are going to make a Lightning deal class to represent a deal. The LightningDeal class is responsible for representing the data points of a single lightning deal. The class has six private fields:

productName: represents the name of the product.
actualPrice: represents the actual price of the product before the discount.
finalPrice: represents the discounted price of the product.
totalUnits: represents the total units of the product available.
availableUnits: represents the units of the product that are still available.
expiryTime: represents the time when deal will expire.

### Order class
The Order class represents a single order placed by a customer for a particular lightning deal.

quantity: represents the number of units of the product ordered by the customer.
orderTime: represents the time at which the order was placed.
approved: represents the status of the order.


### Topkart API class
The TopkartAPI class represents the main API class for handling lightning deals on the Topkart e-commerce website. The class has private fields:

deals: represents the key-value of lightning deals.
orders: represents the list of orders placed by customers.

We are taking orders as lists because if we make it a hashMap then we can’t predict orderId which is UUID to search it in hashMap.

The TopkartAPI class has several public methods that can be used by both administrators and customers:

createDeal: used by administrators to create a new lightning deal.
updateDeal: used by administrators to update an existing lightning deal.
getAvailableDeals: used by customers to access available unexpired deals.
placeOrder: used by customers to place an order for a lightning deal.
approveOrder: used by administrators to approve an order placed by a customer.
getOrderStatus: used by customers to check the status of their order.
