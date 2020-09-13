import java.util.Arrays;

public class Encrypter
{
    public static String encrypt(String value)
    {
        char[] valueChars = value.toCharArray();
        int[] encryptedValue = { 0, 0, 0, 0};

        for (int i = 0; i < value.length(); i++)
        {
            encryptedValue[i] = ((valueChars[i] - 48) + 7) % 10;
        }

        int tmp = encryptedValue[0];
        encryptedValue[0] = encryptedValue[2];
        encryptedValue[2] = tmp;

        int tmp2 = encryptedValue[1];
        encryptedValue[1] = encryptedValue[3];
        encryptedValue[3] = tmp2;

        char[] encryptedValueChars = { '0', '0', '0', '0' };
        for (int i = 0; i < value.length(); i++)
        {
            encryptedValueChars[i] = (char) (encryptedValue[i] + 48);
        }

        String encrypted = Arrays.toString(encryptedValueChars).replace(", ", "");

        return encrypted.substring(1, encrypted.length() - 1);
    }
}