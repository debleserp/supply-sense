package be.debleserp.core.services;

import be.debleserp.core.model.Receipt;
import be.debleserp.core.model.ScannedReceipt;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public interface ExtractorService {

    Receipt processRequest(ScannedReceipt scannedReceipt);
}

