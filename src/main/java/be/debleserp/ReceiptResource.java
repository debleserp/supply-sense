package be.debleserp;

import be.debleserp.model.APIRequest;
import be.debleserp.model.APIResponse;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.jboss.resteasy.reactive.RestForm;

import java.io.File;
import java.io.IOException;

@Path("/receipt")
public class ReceiptResource {

    @Inject
    @RestClient
    CloudVisionAPI cloudVisionAPI;

    @POST
    @Path("/upload")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Produces(MediaType.APPLICATION_JSON)
    public String uploadReceipt(@RestForm File file) {
        try {
            APIRequest googleAPIRequest = new APIRequest(file);

            APIResponse visionResponse = cloudVisionAPI.processRequest(googleAPIRequest);

            return "SUCCESSg";
        } catch (Exception e) {
            e.printStackTrace();
            return "ERROR";
        }
    }
}
