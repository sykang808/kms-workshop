package software.sykang.messagerestservice.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import software.sykang.messagerestservice.manager.EncryptionManager;
import software.sykang.messagerestservice.model.Message;

@Slf4j
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api")
public class EncryptionController {
   
  @PostMapping("/encryption")
  public ResponseEntity<Message> encryption(@RequestBody Message mg) {
    HttpHeaders headers = new HttpHeaders();
    
    byte[] t_ciphering = EncryptionManager.encrypt(
      mg.getKeyid(),
      mg.getPlainmessage()
    );
    if( t_ciphering == null ) return ResponseEntity.status(500).headers(headers).body(mg);
    mg.setCiphering(t_ciphering);

    log.debug("debug log={}", "key arn : " + mg.getKeyid());
    log.debug("debug log={}", "message : " + mg.getPlainmessage());
    log.debug("debug log={}", "message : " + mg.getPlainmessage());

     

    return ResponseEntity.ok().headers(headers).body(mg);
  }

  @PostMapping("/decryption")
  public Message decryption(@RequestBody Message mg) {
    String plaintext = EncryptionManager.decrypt(
      mg.getKeyid(),
      mg.getCiphering()
    );
    mg.setPlainmessage(plaintext);
    log.debug("debug log={}", "key arn : " + mg.getKeyid());
    log.debug("debug log={}", "message : " + mg.getPlainmessage());
    
    return mg;
  }
}
