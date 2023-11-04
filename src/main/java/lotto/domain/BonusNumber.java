package lotto.domain;

public class BonusNumber {
    Integer bonusNumber;

    public BonusNumber(String input) {
        validateIsNumber(input);
        validateRange(input);
        bonusNumber = Integer.parseInt(input);
    }

    private void validateIsNumber(String input) {
        if (input.matches("\\d*")) return;
        throw new IllegalArgumentException("보너스 번호는 숫자로 입력해주세요.");
    }

    private void validateRange(String input) {
        int number = Integer.parseInt(input);
        if (number > 0 && number <= 45) return;
        throw new IllegalArgumentException("보너스 번호는 1-45 숫자로 입력해주세요");
    }

    @Override
    public boolean equals(Object obj) {
        return bonusNumber.equals(obj);
    }
}
