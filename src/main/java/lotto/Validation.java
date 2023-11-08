package lotto;

public class Validation {
    public static boolean validNumber(String data) {
        return data.matches("^[0-9]+$");
    }

    public static boolean validUnit(int data) {
        if (data < 1000)
            return false;
        return data % 1000 == 0;
    }

    public static boolean validNumbers(String data) {
        return data.matches("^[0-9,]+$");
    }

    public static boolean validBlank(String data) {
        String[] winningNumbers = data.split(",");
        for (String number : winningNumbers) {
            if (number.isBlank()) {
                return false;
            }
        }
        return true;
    }

    public static boolean validSize(String data, int size) {
        String[] winningNumbers = data.split(",");
        return winningNumbers.length == 6;
    }
}
