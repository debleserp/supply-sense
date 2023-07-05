package be.debleserp.model;

import jakarta.ws.rs.FormParam;
import jakarta.ws.rs.core.MediaType;
import org.jboss.resteasy.reactive.PartType;

import java.io.File;
import java.io.FileNotFoundException;

public class APIRequest {
    @FormParam("file")
    @PartType(MediaType.MULTIPART_FORM_DATA)
    private File file;

    @FormParam("filePath")
    private String filePath;

    public APIRequest(File file) {
        this.file = file;
    }

    public APIRequest(String filePath) throws FileNotFoundException {
        if (new File(filePath).isFile())
        {
            file = new File(filePath);
            new APIRequest(file);
        }
        else { throw new FileNotFoundException("Invalid file path provided.");}
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }
}
