package lotto.Model;

public class InputValidation {
    private static final String ERROR_INPUT_MONEY = "\n[ERROR] 입력 금액은 1000의 배수로 입력해주세요.";
    private static final String ERROR_NOT_INTEGER = "\n[ERROR] 숫자를 입력해주세요.";
    private static final String ERROR_NUMBER_RANGE = "\n[ERROR] 1부터 45까지의 숫자를 입력해주세요.";
    public void check_money(String money) {

        if (Integer.parseInt(money) % 1000 != 0) {
            System.out.println(ERROR_INPUT_MONEY);
            throw new IllegalArgumentException();
        }

    }

    public int inputToInt(String input) {

        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            System.out.println(ERROR_NOT_INTEGER);
            throw new IllegalArgumentException();
        }

    }

    public void checkNumber(int number) {

        if (number < 1 || number > 45) {
            System.out.println(ERROR_NUMBER_RANGE);
            throw new IllegalArgumentException();
        }

    }
}
