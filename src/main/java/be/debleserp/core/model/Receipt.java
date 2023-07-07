package be.debleserp.core.model;

import java.time.LocalDateTime;
import java.util.List;

public class Receipt {
    LocalDateTime purchaseDate;
    String store;
    double totalAmount;
    List<ReceiptItem> items;

    public Receipt(LocalDateTime purchaseDate, String store, List<ReceiptItem> items) {
        this.purchaseDate = purchaseDate;
        this.store = store;
        this.items = items;
        this.totalAmount = getTotalAmount();
    }

    public Receipt(LocalDateTime purchaseDate, String store) {
        this.purchaseDate = purchaseDate;
        this.store = store;
    }

    private double getTotalAmount(){
        return items.stream()
                .map(item -> item.quantity() * item.unity_price() * (1.0 -item.discount()))
                .reduce(0.0, Double::sum);
    }


}
