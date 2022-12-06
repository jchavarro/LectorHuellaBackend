package jcc.lectorHuella.service;

import java.io.IOException;

public interface LectorHuellaService {

    boolean validarHuella(String huellaCandidata) throws IOException;

}
