public class VigenereCipher {

    public static String encrypt(String plaintext, String keyword) {
        StringBuilder ciphertext = new StringBuilder();
        keyword = keyword.toUpperCase();
        plaintext = plaintext.toUpperCase();
        
        for (int i = 0, j = 0; i < plaintext.length(); i++) {
            char letter = plaintext.charAt(i);
            
            if (letter < 'A' || letter > 'Z') {
                // Non-alphabetic characters are not changed
                ciphertext.append(letter);
                continue;
            }
            
            // Shift the plaintext letter by the keyword letter
            char shift = keyword.charAt(j % keyword.length());
            char encryptedLetter = (char)((letter + shift - 2 * 'A') % 26 + 'A');
            ciphertext.append(encryptedLetter);
            
            j++;
        }
        
        return ciphertext.toString();
    }
    
    public static String decrypt(String ciphertext, String keyword) {
        StringBuilder plaintext = new StringBuilder();
        keyword = keyword.toUpperCase();
        ciphertext = ciphertext.toUpperCase();
        
        for (int i = 0, j = 0; i < ciphertext.length(); i++) {
            char letter = ciphertext.charAt(i);
            
            if (letter < 'A' || letter > 'Z') {
                // Non-alphabetic characters are not changed
                plaintext.append(letter);
                continue;
            }
            
            // Shift the ciphertext letter back by the keyword letter
            char shift = keyword.charAt(j % keyword.length());
            char decryptedLetter = (char)((letter - shift + 26) % 26 + 'A');
            plaintext.append(decryptedLetter);
            
            j++;
        }
        
        return plaintext.toString();
    }
    
    public static void main(String[] args) {
        String plaintext = "ATTACK AT DAWN";
        String keyword = "SECURE";
        String ciphertext = encrypt(plaintext, keyword);
        String decryptedText = decrypt(ciphertext, keyword);
        
        System.out.println("Plaintext: " + plaintext);
        System.out.println("Keyword: " + keyword);
        System.out.println("Ciphertext: " + ciphertext);
        System.out.println("Decrypted Text: " + decryptedText);
    }
}
