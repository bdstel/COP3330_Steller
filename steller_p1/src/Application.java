public class Application {
    public static void main(String[] args)
    {
        String encryptedValue = Encrypter.encrypt("0573");
        System.out.println(encryptedValue);

        String decryptedValue = Decrypter.decrypt("4072");
        System.out.println(decryptedValue);
    }
}
