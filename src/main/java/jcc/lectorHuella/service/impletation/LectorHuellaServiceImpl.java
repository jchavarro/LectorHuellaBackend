package jcc.lectorHuella.service.impletation;

import jcc.lectorHuella.service.LectorHuellaService;
import jcc.lectorHuella.service.utils.LectorHuella;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Base64;

import static java.nio.file.Files.readAllBytes;

@Service
public class LectorHuellaServiceImpl implements LectorHuellaService {

    @Override
    public boolean validarHuella(String huellaCandidata) throws IOException {
        //Huella guardada en repo
        byte[] nuevaHuellaPrueba = Base64.getDecoder()
                .decode(readAllBytes(Paths.get("C:\\Users\\Diego Calvera\\Desktop\\LectorHuellaBackend\\src\\main\\resources\\static\\huella11.txt")));
        byte[] nuevaHuellaCandidata = Base64.getDecoder().decode(huellaCandidata.getBytes());
        return LectorHuella.FingerImageMatch(nuevaHuellaPrueba, nuevaHuellaCandidata);
    }
}
