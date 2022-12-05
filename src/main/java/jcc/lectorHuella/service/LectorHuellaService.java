package jcc.lectorHuella.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface LectorHuellaService {

    boolean validarHuella(MultipartFile huellaCandidata) throws IOException;

}
