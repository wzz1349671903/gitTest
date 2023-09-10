import java.util.Scanner;

public class Password {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("请选择操作:");
            System.out.println("1. 加密密码");
            System.out.println("2. 解密密码");
            System.out.println("3. 判断密码强度");
            System.out.println("4. 生成密码");
            System.out.println("5. 退出");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.println("请输入要加密的密码:");
                    String plainPassword = scanner.nextLine();
                    String encryptedPassword = encryptPassword(plainPassword);
                    System.out.println("加密后的密码: " + encryptedPassword);
                    break;
                case 2:
                    System.out.println("请输入要解密的密码:");
                    String encryptedPasswordToDecrypt = scanner.nextLine();
                    String decryptedPassword = decryptPassword(encryptedPasswordToDecrypt);
                    System.out.println("解密后的密码: " + decryptedPassword);
                    break;
                case 3:
                    System.out.println("请输入要判断强度的密码:");
                    String passwordToCheck = scanner.nextLine();
                    int strength = getPasswordStrength(passwordToCheck);
                    System.out.println("密码强度: " + strength);
                    break;
                case 4:
                    String generatedPassword = generatePassword();
                    System.out.println("生成的密码: " + generatedPassword);
                    break;
                case 5:
                    System.out.println("退出程序。");
                    System.exit(0);
                default:
                    System.out.println("无效的选项，请重新输入。");
            }
        }
    }

    // 加密密码
    private static String encryptPassword(String password) {
        StringBuilder encrypted = new StringBuilder();
        for (int i = 0; i < password.length(); i++) {
            char c = password.charAt(i);
            int asciiValue = (int) c + i + 3;
            encrypted.append((char) asciiValue);
        }
        String result = encrypted.toString();
        result = result.charAt(result.length() - 1) + result.substring(1, result.length() - 1) + result.charAt(0);
        return new StringBuilder(result).reverse().toString();
    }

    // 解密密码
    private static String decryptPassword(String encryptedPassword) {
        String reversed = new StringBuilder(encryptedPassword).reverse().toString();
        reversed = reversed.charAt(reversed.length() - 1) + reversed.substring(1, reversed.length() - 1) + reversed.charAt(0);

        StringBuilder decrypted = new StringBuilder();
        for (int i = 0; i < reversed.length(); i++) {
            char c = reversed.charAt(i);
            int asciiValue = (int) c - i - 3;
            decrypted.append((char) asciiValue);
        }
        return decrypted.toString();
    }

    // 判断密码强度
    private static int getPasswordStrength(String password) {
        int length = password.length();
        if (length < 6) {
            return 1;
        } else if (length < 10) {
            return 2;
        } else {
            return 3;
        }
    }

    // 生成密码
    private static String generatePassword() {
        StringBuilder password = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            char randomChar = (char) (Math.random() * 26 + 'a');
            password.append(randomChar);
        }
        return password.toString();
    }
}
