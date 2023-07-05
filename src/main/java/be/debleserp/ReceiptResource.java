package be.debleserp;

import be.debleserp.model.APIRequest;
import be.debleserp.model.APIResponse;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.jboss.resteasy.reactive.RestForm;

import java.io.File;

@Path("/receipt")
public class ReceiptResource {

    @Inject
    @RestClient
    CloudVisionAPI cloudVisionAPI;

    @POST
    @Path("/upload")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Produces(MediaType.APPLICATION_JSON)
    public Response uploadReceipt(@RestForm File file) {
        try {
            APIRequest googleAPIRequest = new APIRequest(file);

            APIResponse visionResponse = cloudVisionAPI.processRequest(googleAPIRequest);

            return Response.status(Response.Status.OK)
                    .entity("Receipt uploaded successfully")
                    .type(MediaType.TEXT_PLAIN)
                    .build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("Error")
                    .type(MediaType.TEXT_PLAIN)
                    .build();
        }
    }
}
