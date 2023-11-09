package lotto.model.domain.vo;

public class BonusNumber {

    private int bonusNumber;

    private BonusNumber(int bonusNumber) {
        validateNumberScope(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    public static BonusNumber of(String input) {
        BonusNumber bonusNumber;
        try {
            bonusNumber = new BonusNumber(Integer.parseInt(input));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자 형식이 아닙니다.");
        }
        return bonusNumber;
    }

    private void validateNumberScope(int bonusNumber) {
        if (isBetween1And45(bonusNumber)) {
            throw new IllegalArgumentException("1부터 45 사이의 수를 입력해야 합니다.");
        }
    }

    private boolean isBetween1And45(int bonusNumber) {
        return !(bonusNumber >= 1 && bonusNumber <= 45);
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
