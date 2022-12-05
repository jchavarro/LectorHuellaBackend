package jcc.lectorHuella.service.utils;

import com.machinezoo.sourceafis.FingerprintMatcher;
import com.machinezoo.sourceafis.FingerprintTemplate;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static java.nio.file.Files.readAllBytes;

@Component
public class LectorHuella {

    public void FingerTemplateMatch() throws IOException {
        byte[] templateProbe = readAllBytes(Paths.get("X:\\rutaTemplateISO_P"));
        byte[] templateCandidate = readAllBytes(Paths.get("X:\\rutaTemplateISO_C"));
        FingerprintTemplate probe = new FingerprintTemplate().convert(templateProbe);
        FingerprintTemplate candidate = new FingerprintTemplate().convert(templateCandidate);
        double score = new FingerprintMatcher().index(probe).match(candidate);
        double threshold = 40;
        boolean matches = score >= threshold;
        System.out.println(matches);
    }

    public static boolean FingerTemplateMatch(byte[] templateProbe, byte[] templateCandidate, double threshold)
            throws IOException {
        FingerprintTemplate probe = new FingerprintTemplate().convert(templateProbe);
        FingerprintTemplate candidate = new FingerprintTemplate().convert(templateCandidate);
        double score = new FingerprintMatcher().index(probe).match(candidate);
        return score >= threshold;
    }

    public static void FingerImageMatch () throws IOException {
        byte[] probeImage = Files.readAllBytes(Paths.get("D:\\huella.jpg"));
        byte[] candidateImage = Files.readAllBytes(Paths.get("D:\\huella2.jpg"));
        FingerprintTemplate probe = new FingerprintTemplate().dpi(500).create(probeImage);
        FingerprintTemplate candidate = new FingerprintTemplate().dpi(500).create(candidateImage);
        double score = new FingerprintMatcher().index(probe).match(candidate);
        double threshold = 40;
        boolean matches = score >= threshold;
        System.out.println(matches);
    }

    public static boolean FingerImageMatch (byte[] probeImage, byte[] candidateImage) throws IOException {
        FingerprintTemplate probe = new FingerprintTemplate().dpi(500).create(probeImage);
        FingerprintTemplate candidate = new FingerprintTemplate().dpi(500).create(candidateImage);
        double score = new FingerprintMatcher().index(probe).match(candidate);
        return score >= 40;
    }

}
