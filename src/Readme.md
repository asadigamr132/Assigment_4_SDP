# Assignment #4 — Facade Pattern

**Student`s name** - Abdraissov Altair
**Course:** SE-2528 — Software Design Patterns  
**Language:** Java 17  
**Design Pattern:** Facade  
**Project:** Online Order Processing System

## 1. Project Overview

This project demonstrates the **Facade structural design pattern** through a simplified online order processing system.

Placing or cancelling an order requires several operations involving inventory management, payment processing, shipping, and customer notifications. Without a Facade, the client would need to coordinate these services directly.

The `OrderFacade` provides a simple interface that hides the coordination details and allows the client to interact with the system through a small set of methods.

## 2. Main Features

- Place an order by providing the customer's name, address, and payment amount.
- Check product availability and reserve stock.
- Process payments and handle declined transactions.
- Release reserved stock if payment fails.
- Create shipments and send order confirmation notifications.
- Cancel an existing order.
- Update the order status after cancellation.
- Prevent repeated cancellation of an already cancelled order.
- Handle invalid order amounts and unknown order IDs.

## 3. Project Structure

```text
src/
├── Main.java
├── OrderFacade.java
├── Order.java
├── InventoryService.java
├── PaymentProcessor.java
├── ShippingService.java
└── NotificationService.java
```

### Class Responsibilities

| Class | Responsibility |
|---|---|
| `Main` | Acts as the client and demonstrates the system through the Facade. |
| `OrderFacade` | Coordinates the subsystem services and exposes a simplified API. |
| `Order` | Stores order information, including its ID, customer, address, amount, and status. |
| `InventoryService` | Checks product availability and reserves or releases stock. |
| `PaymentProcessor` | Simulates payment processing and payment failures. |
| `ShippingService` | Simulates shipment creation and cancellation. |
| `NotificationService` | Sends simulated order confirmation, payment failure, and cancellation notifications. |

## 4. How the Facade Works

### Placing an Order

1. The client calls `OrderFacade.placeOrder()`.
2. The Facade validates the payment amount.
3. The inventory service checks availability and reserves the product.
4. The payment processor attempts to process the payment.
5. If payment succeeds, the Facade creates a shipment, sends a confirmation, and stores the order.
6. If payment fails, the Facade releases the reserved stock and notifies the customer.

### Cancelling an Order

1. The client calls `OrderFacade.cancelOrder(orderId)`.
2. The Facade searches for the order.
3. If the order exists and has the `PLACED` status, the shipment is cancelled, the stock is released, the order status is updated, and the customer is notified.
4. If the order cannot be cancelled or does not exist, the Facade reports the problem.

## 5. Technologies

- Java Development Kit (JDK) 17
- IntelliJ IDEA
- Object-Oriented Programming
- Facade Structural Design Pattern

## 6. How to Run

1. Clone or download this repository.
2. Open the project in IntelliJ IDEA.
3. Configure JDK 17.
4. Build the project.
5. Run `Main.java`.
6. Enter the customer's name, address, and payment amount when prompted.

The application demonstrates a successful order, order cancellation, and a declined payment.

## 7. Design Benefits

The Facade reduces coupling between the client and the subsystem classes. The client does not need to know the internal sequence of inventory, payment, shipping, and notification operations.

Each subsystem class remains focused on its own responsibility and does not depend on the Facade. Advanced clients can still use the subsystem classes directly when necessary.

## 8. Conclusion

This project demonstrates how the Facade pattern simplifies access to a subsystem containing several collaborating services. It centralizes workflow coordination, makes the client code easier to understand, and keeps subsystem implementation details out of the client's normal interaction with the system.
