package lotto.Model;

public class InputValidation {
    public void check_money(String money) {

        if (Integer.parseInt(money) % 1000 != 0) {
            System.out.println("[ERROR] 입력 금액은 1000의 배수로 입력해주세요.");
            throw new IllegalArgumentException();
        }

    }

    public int inputToInt(String input) {

        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            System.out.println("\n[ERROR] 숫자를 입력해주세요.");
            throw new IllegalArgumentException();
        }

    }

    public void checkNumber(int number) {

        if (number < 1 || number > 45) {
            System.out.println("\n[ERROR] 1부터 45까지의 숫자를 입력해주세요.");
            throw new IllegalArgumentException();
        }

    }
}
