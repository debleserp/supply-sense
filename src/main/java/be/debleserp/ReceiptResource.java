package be.debleserp;

import be.debleserp.model.APIRequest;
import be.debleserp.model.APIResponse;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.jboss.resteasy.reactive.RestForm;

import java.io.File;
import java.io.FileNotFoundException;

@Path("/receipt")
public class ReceiptResource {

    @Inject
    @RestClient
    CloudVisionAPI cloudVisionAPI;

    @POST
    @Path("/uploadFile")
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
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("An unknown error occurred: " + e.getMessage())
                    .build();
        }
    }

    @POST
    @Path("/uploadFilepath")
    @Produces(MediaType.APPLICATION_JSON)
    public Response uploadReceipt(@RestForm String filePath) {
        try {
            APIRequest googleAPIRequest = new APIRequest(filePath);

            APIResponse visionResponse = cloudVisionAPI.processRequest(googleAPIRequest);

            return Response.status(Response.Status.OK)
                    .entity("Receipt uploaded successfully")
                    .type(MediaType.TEXT_PLAIN)
                    .build();
        } catch (FileNotFoundException fileNotFoundException){
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity(fileNotFoundException.getMessage())
                    .type(MediaType.TEXT_PLAIN)
                    .build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("An unknown error occurred: " + e.getMessage())
                    .build();
        }
    }

}
