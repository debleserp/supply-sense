package be.debleserp;

import be.debleserp.model.APIRequest;
import be.debleserp.model.APIResponse;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import org.jboss.resteasy.reactive.RestForm;

@RegisterRestClient
public interface CloudVisionAPI {

    @POST
    @Path("google/api/endpoint")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    APIResponse processRequest(@RestForm APIRequest request);
}

