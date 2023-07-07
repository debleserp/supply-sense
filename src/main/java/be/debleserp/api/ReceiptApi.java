package be.debleserp.api;

import be.debleserp.core.model.Receipt;
import be.debleserp.core.model.ScannedReceipt;
import be.debleserp.core.services.ExtractorService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.jboss.resteasy.reactive.RestForm;

import java.io.File;

@Path("/receipt-uploads")
public class ReceiptApi {
    @Inject
    ExtractorService extractorService;

    @POST
    @Path("/")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Produces(MediaType.APPLICATION_JSON)
    public Response uploadReceipt(@RestForm File file) {
        Receipt receipt = extractorService.processRequest(new ScannedReceipt(file));

        return Response.status(Response.Status.OK)
                .entity(receipt)
                .build();
    }
}
