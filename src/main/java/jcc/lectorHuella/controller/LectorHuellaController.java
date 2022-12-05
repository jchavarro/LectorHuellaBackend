package jcc.lectorHuella.controller;

import jcc.lectorHuella.service.LectorHuellaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("biometria")
public class LectorHuellaController {

    private LectorHuellaService lectorHuellaService;

    public LectorHuellaController(LectorHuellaService lectorHuellaService) {
        this.lectorHuellaService = lectorHuellaService;
    }

    @GetMapping("huellas")
    public ResponseEntity<Boolean> validarHuellas(@RequestParam final MultipartFile huellaCandidata) throws IOException {
        return new ResponseEntity<>(lectorHuellaService.validarHuella(huellaCandidata), HttpStatus.ACCEPTED);
    }

}
