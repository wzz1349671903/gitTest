import java.util.Scanner;

public class Password {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);// 创建用于接收用户输入的Scanner对象

        while (true) {// 进入无限循环，直到用户选择退出
            System.out.println("请选择操作:");// 打印菜单选项
            System.out.println("1. 加密密码");
            System.out.println("2. 解密密码");
            System.out.println("3. 判断密码强度");
            System.out.println("4. 生成密码");
            System.out.println("5. 退出");
            int choice = scanner.nextInt();// 读取用户的选择
            scanner.nextLine(); // 读取并丢弃换行符

            switch (choice) {      // 根据用户的选择执行不同的操作
                case 1:            // 如果用户选择1，执行以下代码块
                    System.out.println("请输入要加密的密码:");   // 提示用户输入密码
                    String plainPassword = scanner.nextLine();   // 读取用户输入的密码
                    String encryptedPassword = encryptPassword(plainPassword);   // 调用加密函数加密密码
                    System.out.println("加密后的密码: " + encryptedPassword);   // 打印加密后的密码
                    break;    // 跳出switch语句
                case 2:         // 如果用户选择2，执行以下代码块
                    System.out.println("请输入要解密的密码:");  
                    String encryptedPasswordToDecrypt = scanner.nextLine();    // 读取用户输入的密码
                    String decryptedPassword = decryptPassword(encryptedPasswordToDecrypt);  // 调用解密函数解密密码
                    System.out.println("解密后的密码: " + decryptedPassword); // 调用解密函数解密密码
                    break;    // 跳出switch语句
                case 3:      // 如果用户选择3，执行以下代码块
                    System.out.println("请输入要判断强度的密码:");
                    String passwordToCheck = scanner.nextLine();
                    int strength = getPasswordStrength(passwordToCheck);   // 调用密码强度判断函数
                    System.out.println("密码强度: " + strength);       // 打印密码强度
                    break;
                case 4:     // 如果用户选择4，执行以下代码块
                    String generatedPassword = generatePassword();  // 调用生成密码函数
                    System.out.println("生成的密码: " + generatedPassword);// 打印生成的密码
                    break;
                case 5:     // 如果用户选择5，执行以下代码块
                    System.out.println("退出程序。");   // 打印退出信息
                    System.exit(0);  // 退出程序
                default:   // 如果用户输入的选择无效，执行以下代码块
                    System.out.println("无效的选项，请重新输入。");   // 提示用户输入无效
            }
        }
    }

    // 加密密码
    private static String encryptPassword(String password) {
        StringBuilder encrypted = new StringBuilder();// 创建一个用于存储加密结果的StringBuilder对象
        for (int i = 0; i < password.length(); i++) {// 循环遍历密码中的每个字符
            char c = password.charAt(i);// 获取密码中的当前字符
            int asciiValue = (int) c + i + 3;// 计算字符的ASCII码加上位置和偏移值3
            encrypted.append((char) asciiValue);// 将加密后的字符追加到加密结果中
        }
        String result = encrypted.toString();// 将加密结果转换为字符串
        result = result.charAt(result.length() - 1) + result.substring(1, result.length() - 1) + result.charAt(0);// 调整加密结果的顺序
        return new StringBuilder(result).reverse().toString();// 反转加密结果并返回
    }

    // 解密密码
    private static String decryptPassword(String encryptedPassword) {
        String reversed = new StringBuilder(encryptedPassword).reverse().toString();// 反转加密密码
        reversed = reversed.charAt(reversed.length() - 1) + reversed.substring(1, reversed.length() - 1) + reversed.charAt(0); // 调整密码顺序

        StringBuilder decrypted = new StringBuilder();// 创建一个用于存储解密结果的StringBuilder对象
        for (int i = 0; i < reversed.length(); i++) {// 循环遍历反转后的密码中的每个字符

            char c = reversed.charAt(i);// 获取当前字符
            int asciiValue = (int) c - i - 3;// 计算字符的ASCII码减去位置和偏移值3
            decrypted.append((char) asciiValue);// 将解密后的字符追加到解密结果中
        }
        return decrypted.toString(); // 返回解密结果
    }

    // 判断密码强度
    private static int getPasswordStrength(String password) {
        int length = password.length();// 获取密码的长度
        if (length < 6) {// 如果密码长度小于6
            return 1; // 返回强度弱
        } else if (length < 10) {// 如果密码长度小于10
            return 2; // 返回强度中
        } else {
            return 3; // 返回强度强
        }
    }

    // 生成密码
    private static String generatePassword() {
        StringBuilder password = new StringBuilder();// 创建一个用于存储生成密码的StringBuilder对象
        for (int i = 0; i < 8; i++) {// 循环生成8个字符的密码
            char randomChar = (char) (Math.random() * 26 + 'a');// 生成随机小写字母
            password.append(randomChar);// 将随机字符追加到生成密码中
        }
        return password.toString();// 返回生成的密码
    }
}
