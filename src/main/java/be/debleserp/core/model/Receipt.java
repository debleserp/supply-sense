package be.debleserp.core.model;


import jakarta.json.bind.annotation.JsonbProperty;

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

    public LocalDateTime getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(LocalDateTime purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public String getStore() {
        return store;
    }

    public void setStore(String store) {
        this.store = store;
    }

    public List<ReceiptItem> getItems() {
        return items;
    }

    public void setItems(List<ReceiptItem> items) {
        this.items = items;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }
}
