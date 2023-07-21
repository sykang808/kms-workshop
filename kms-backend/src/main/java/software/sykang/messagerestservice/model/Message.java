package software.sykang.messagerestservice.model;

import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Message {
    private String keyid;
    private String plainmessage;
    private byte[] ciphering;
}
