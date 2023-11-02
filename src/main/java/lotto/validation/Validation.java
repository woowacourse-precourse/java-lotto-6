package lotto.validation;

public class Validation {
    public void validateNumber(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("입력값이 정수가 아닙니다.");
        }
    }

    public void validateUnit(String input) {
        int payment = Integer.parseInt(input);

        if(payment % 1000 != 0) {
            throw new IllegalArgumentException("입력값이 1,000원 단위가 아닙니다.");
        }
    }

    public void validateLength(String[] input) {
        if (input.length != 6) {
            throw new IllegalArgumentException("입력값이 6개가 아닙니다.");
        }
    }

    public void validateRange(String input) {
        int number = Integer.parseInt(input);

        if(number <= 0 || number > 45) {
            throw new IllegalArgumentException("입력값이 1이상 45이하가 아닙니다.");
        }
    }
}