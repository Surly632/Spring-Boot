package com.abmhimel.staticcontext;

import java.io.IOException;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.MediaType;

@RestController
public class StaticController {
  @GetMapping("/download")
public ResponseEntity<Resource> downloadFile() throws IOException {
    String currentWorkingDirectory = System.getProperty("user.dir");

    String filePath = currentWorkingDirectory + "\\src\\main\\resources\\static\\a.jpg";
    System.out.println(filePath);

    Resource resource = new FileSystemResource(filePath);
    HttpHeaders headers = new HttpHeaders();
    String fileName = resource.getFilename();
    System.out.println("filename with extension: "+fileName);
    System.out.println("Resource Details: "+resource);
    headers.add(HttpHeaders.CONTENT_DISPOSITION, "application;filename="+fileName);
    headers.add(HttpHeaders.CONTENT_TYPE,MediaType.APPLICATION_OCTET_STREAM_VALUE);

    return ResponseEntity.ok()
            .headers(headers)
            .contentLength(resource.contentLength())
            .body(resource);
}

@GetMapping("/show")
public ResponseEntity<Resource> showMedia() throws IOException {
    String filePath = System.getProperty("user.dir");
    filePath+="\\src\\main\\resources\\static\\a.jpg";

    Resource resource = new FileSystemResource(filePath);
    HttpHeaders headers = new HttpHeaders();
    String filename = resource.getFilename();
    headers.add(HttpHeaders.CONTENT_DISPOSITION, "inline;filename="+filename);
    headers.add(HttpHeaders.CONTENT_TYPE, MediaType.IMAGE_JPEG_VALUE);

    return ResponseEntity.ok()
    .headers(headers)
    .contentLength(resource.contentLength())
    .contentType(MediaType.IMAGE_JPEG)
    .body(resource);
}


@GetMapping("/show1")
public ResponseEntity<Void> showMedia1() throws IOException {
    String filePath = System.getProperty("user.dir");
    filePath+="\\src\\main\\resources\\static\\a.jpg";

    Resource resource = new FileSystemResource(filePath);
    HttpHeaders headers = new HttpHeaders();
    String filename = resource.getFilename();
    headers.add(HttpHeaders.CONTENT_DISPOSITION, "inline;filename="+filename);
    headers.add(HttpHeaders.CONTENT_TYPE, MediaType.IMAGE_JPEG_VALUE);
    // headers.add(HttpHeaders.LOCATION, "/a.jpg");
    return new ResponseEntity<>(headers,HttpStatus.OK);
}

   @GetMapping("/redirectToIndex")
    public ResponseEntity<Void> redirectToIndex() {
        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.LOCATION, "/index.html");
        return new ResponseEntity<>(headers, HttpStatus.FOUND);
    }

    @GetMapping("/redirectToIndex1")
    public ResponseEntity<Resource> redirectToIndex1() throws IOException {

        String filePath = System.getProperty("user.dir");
          filePath +="\\src\\main\\resources\\static\\index.html";

        Resource resource = new FileSystemResource(filePath);
        System.err.println("Uri: "+resource.getURI());

        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_DISPOSITION, "inline;filename=" + resource.getFilename());
        headers.add(HttpHeaders.LOCATION, "/index.html");
        headers.add(HttpHeaders.CONTENT_TYPE, MediaType.TEXT_HTML_VALUE);

        return ResponseEntity.ok()
                .headers(headers)
                .contentLength(resource.contentLength())
                .body(resource);
    }
}
