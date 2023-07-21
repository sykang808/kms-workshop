import axios from 'axios';
import { UseMutationOptions, useMutation } from 'react-query';

interface DecryptMessageInput {
  keyId: string;
  ciphering: string;
}

export const useDecryptMessage = (options: UseMutationOptions<unknown, unknown, DecryptMessageInput>) => {
  return useMutation('decryptMessage', async (input: DecryptMessageInput) => {
    const { keyId: keyid, ciphering } = input;
    const { data } = await axios.post(
      'http://localhost:8080/api/decryption',
      {
        keyid,
        ciphering
      }
    );
    return data;
  }, options);
};
