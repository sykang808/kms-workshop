package software.sykang.messagerestservice.manager;


import com.amazonaws.encryptionsdk.AwsCrypto;
import com.amazonaws.encryptionsdk.CommitmentPolicy;
import com.amazonaws.encryptionsdk.CryptoResult;
import com.amazonaws.encryptionsdk.kmssdkv2.AwsKmsMrkAwareMasterKey;
import com.amazonaws.encryptionsdk.kmssdkv2.AwsKmsMrkAwareMasterKeyProvider;

import lombok.extern.slf4j.Slf4j;

import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.Map;


@Slf4j
public class EncryptionManager {
    
    private EncryptionManager() {
        throw new IllegalStateException("Utility class");
    }
    public static byte[] encrypt(final String multiRegionEncryptKey, final String PLAIN_MESSAGE) {

        try {
            byte[] plain = PLAIN_MESSAGE.getBytes(StandardCharsets.UTF_8);
            final AwsCrypto crypto = AwsCrypto.builder()
                .withCommitmentPolicy(CommitmentPolicy.RequireEncryptRequireDecrypt)
                .build();
            final AwsKmsMrkAwareMasterKeyProvider encryptingKeyProvider = AwsKmsMrkAwareMasterKeyProvider
                .builder()
                .buildStrict(multiRegionEncryptKey);

            final Map<String, String> encryptionContext = Collections.singletonMap("ExampleContextKey", "ExampleContextValue");

            final CryptoResult<byte[], AwsKmsMrkAwareMasterKey> encryptResult = crypto.encryptData(encryptingKeyProvider, plain, encryptionContext);
            final byte[] byteArray = encryptResult.getResult();

            return byteArray;
                
        } catch (Exception e) {
            // TODO: handle exception

            log.error("error log={}", e.getMessage());
            return null;
        }

    }
    public static String decrypt(final String multiRegionDecryptKey, final byte[] cipherstring) {
        final AwsCrypto crypto = AwsCrypto.builder()
            .withCommitmentPolicy(CommitmentPolicy.RequireEncryptRequireDecrypt)
            .build();
        final AwsKmsMrkAwareMasterKeyProvider decryptKeyProvider = AwsKmsMrkAwareMasterKeyProvider
            .builder()
            .buildStrict(multiRegionDecryptKey);
        final CryptoResult<byte[], AwsKmsMrkAwareMasterKey> decryptResult = crypto.decryptData(decryptKeyProvider, cipherstring);
        return new String(decryptResult.getResult(), StandardCharsets.US_ASCII);
    }
}