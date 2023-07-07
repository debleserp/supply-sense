package be.debleserp.adapters.googlevision;


import be.debleserp.core.model.Receipt;
import be.debleserp.core.model.ReceiptItem;
import be.debleserp.core.model.ScannedReceipt;
import be.debleserp.core.services.ExtractorService;
import jakarta.enterprise.context.ApplicationScoped;

import java.time.LocalDateTime;
import java.util.List;


@ApplicationScoped
public class GoogleVision implements ExtractorService {
    Receipt createDummyReceipt(){
        ReceiptItem receiptItem = new ReceiptItem("Water", 6, 1);
        return new Receipt(LocalDateTime.now(), "Colruyt", List.of(receiptItem));
    }
    @Override
    public Receipt processRequest(ScannedReceipt scannedReceipt) {
        return createDummyReceipt();
    }
}
