import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PasswordChecker checker = new PasswordChecker();

        try {
            System.out.print("Введите ми-ю длину пароля: ");
            int minLength = Integer.parseInt(sc.nextLine());
            checker.setMinLength(minLength);

            System.out.print("Введите мак-ую доп-ое кол-во повторений: ");
            int maxRepeats = Integer.parseInt(sc.nextLine());
            checker.setMaxRepeats(maxRepeats);

            while (true) {
                System.out.print("Введите пароль или end: ");
                String password = sc.nextLine();

                if ("end".equals(password)) {
                    System.out.println();
                    System.out.println("Программа завершена");
                    break;
                }
                if (checker.verefy(password)) {
                    System.out.println("Подходит!");
                    System.out.println();
                } else {
                    System.out.println("Не подходит!");
                    System.out.println();
                }
            }

        } catch (IllegalArgumentException | IllegalStateException e) {
            System.out.println("Ошибка: " + e.getMessage());
        } finally {
            sc.close();
        }
    }
}
