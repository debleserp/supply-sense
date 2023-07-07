package be.debleserp.core.model;

import java.io.File;

public class ScannedReceipt {
    File scannedReceipt;

    public ScannedReceipt(File scannedReceipt) {
        this.scannedReceipt = scannedReceipt;
    }

    public File getScannedReceipt() {
        return scannedReceipt;
    }

    public void setScannedReceipt(File scannedReceipt) {
        this.scannedReceipt = scannedReceipt;
    }
}
