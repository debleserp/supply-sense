package be.debleserp.core.model;


public record ReceiptItem(String name, double quantity, double unity_price, double discount ) {
    public ReceiptItem(String name, double quantity, double unity_price) {
        this(name, quantity, unity_price, 0.0);
    }
}
