package be.debleserp.model;

import jakarta.ws.rs.FormParam;
import jakarta.ws.rs.core.MediaType;
import org.jboss.resteasy.reactive.PartType;

import java.io.File;

public class APIRequest {
    @FormParam("file")
    @PartType(MediaType.MULTIPART_FORM_DATA)
    private File file;

    public APIRequest(File file) {
        this.file = file;
    }
}
