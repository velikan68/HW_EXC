public class PasswordChecker {
    private int minLength; // Минимальная длина
    private int maxRepeats; // Максимальное кол-во повторений символов подряд

    public void setMinLength(int minLength) {
        if (minLength < 0) {
            throw new IllegalArgumentException("Мин-ая длина пароля не может быть отрицательным.");
        }
        this.minLength = minLength;
    }

    public void setMaxRepeats(int maxRepeats) {
        if (maxRepeats <= 0) {
            throw new IllegalArgumentException("Повторений символа должно быть положительным.");
        }
        this.maxRepeats = maxRepeats;
    }

    public boolean verefy(String password) {
        if (minLength == 0 || maxRepeats == 0) {
            throw new IllegalStateException("Настройки чекера не выставлены перед проверкой.");
        }

        if (password.length() < minLength) {
            return false;
        }

        int repeatCount = 1;
        for (int i = 1; i < password.length(); i++) {
            if (password.charAt(i) == password.charAt(i - 1)) {
                repeatCount++;
                if (repeatCount > maxRepeats) {
                    return false;
                }
            } else {
                repeatCount = 1; //Сбросить счетчик при смене символа
            }
        }
        return true;
    }


}