package lotto.model;

public class BonusNumber {
    private int bonusNumber;
    private static final String NOT_NUMBER = "보너스 숫자는 숫자로 입력해주세요.";
    private static final String OUT_OF_BOUND = "1~45 사이 숫자를 입력해주세요.";
    public BonusNumber(String numberCommand) {
        validate(numberCommand);
        int shiftedNumber = Integer.parseInt(numberCommand);
        validate(shiftedNumber);
        bonusNumber = shiftedNumber;
    }

    private void validate(String number) {
        for (char digit: number.toCharArray()) {
            if (!Character.isDigit(digit))
                throw new IllegalArgumentException(NOT_NUMBER);
        }
    }

    private void validate(int number) {
        if (number < 1 || number >= 45)
            throw new IllegalArgumentException(OUT_OF_BOUND);
    }

    public boolean isEqual(int number) { return bonusNumber == number; }
}
