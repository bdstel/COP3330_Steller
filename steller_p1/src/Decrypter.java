import java.util.Arrays;

public class Decrypter
{
    public static String decrypt(String value)
    {
        char[] valueChars = value.toCharArray();
        int[] decryptedValue = { 0, 0, 0, 0 };

        for (int i = 0; i < value.length(); i++) {
            if ((valueChars[i] - 48) < 7)
                decryptedValue[i] = (valueChars[i] - 48) + 3;
            else
                decryptedValue[i] = (valueChars[i] - 48) - 7;
        }

        int tmp = decryptedValue[0];
        decryptedValue[0] = decryptedValue[2];
        decryptedValue[2] = tmp;

        int tmp2 = decryptedValue[1];
        decryptedValue[1] = decryptedValue[3];
        decryptedValue[3] = tmp2;

        char[] decryptedValueChars = { '0', '0', '0', '0' };
        for (int i = 0; i < value.length(); i++)
        {
            decryptedValueChars[i] = (char) (decryptedValue[i] + 48);
        }

        String decrypted = Arrays.toString(decryptedValueChars).replace(", ", "");

        return decrypted.substring(1, decrypted.length() - 1);
    }
}
