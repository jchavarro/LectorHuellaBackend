package jcc.lectorHuella.controller;

import jcc.lectorHuella.service.LectorHuellaService;
import jcc.lectorHuella.web.dto.HuellaDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;

@RestController
@RequestMapping("biometria")
public class LectorHuellaController {

    private LectorHuellaService lectorHuellaService;

    public LectorHuellaController(LectorHuellaService lectorHuellaService) {
        this.lectorHuellaService = lectorHuellaService;
    }

    @RequestMapping(value = "/huellas", method = RequestMethod.POST)
    public ResponseEntity<Boolean> validarHuellas(@RequestBody HuellaDTO huellaCandidata) throws IOException {
        return new ResponseEntity<>(lectorHuellaService.validarHuella(huellaCandidata.getHuella()), HttpStatus.ACCEPTED);
    }

}
