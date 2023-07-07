package be.debleserp.core.services;

import be.debleserp.core.model.Receipt;
import be.debleserp.core.model.ScannedReceipt;
import be.debleserp.model.APIRequest;
import be.debleserp.model.APIResponse;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import org.jboss.resteasy.reactive.RestForm;

@ApplicationScoped
public interface ExtractorService {

    Receipt processRequest(ScannedReceipt scannedReceipt);
}

