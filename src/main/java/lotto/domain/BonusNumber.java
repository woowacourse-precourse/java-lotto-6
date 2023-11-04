package lotto.domain;

public class BonusNumber {

    private int number;

    public BonusNumber(int number, Lotto lotto) {
        validateDuplicateNumber(number, lotto);
        this.number = number;
    }

    private void validateDuplicateNumber(int number, Lotto lotto) {
        if (lotto.getNumbers().contains(number)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다. 다시 입력해주세요.");
        }
    }
}
