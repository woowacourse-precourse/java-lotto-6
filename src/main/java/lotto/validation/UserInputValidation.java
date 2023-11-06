package lotto.validation;

public class UserInputValidation {


    public void validatePayment(String input) {
        validateNumber(input);
        validateMultipleOf1000(input);
    }

    private void validateNumber(String input) {
        if(!input.matches("\\d+"))
            throw new IllegalArgumentException("[ERROR] 숫자만 입력할 수 있습니다.");
    }

    private void validateMultipleOf1000(String input) {
        int number = Integer.parseInt(input);
        if (!((number % 1000) == 0))
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 1,000 단위로 입력해야 합니다.");
    }

    private void validateRange(String input) {

    }


}
