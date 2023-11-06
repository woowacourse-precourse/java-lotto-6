package lotto.domain;

public class BonusNumber {
    private final int number;

    public BonusNumber(int number, Lotto userLotto) {
        this.number = number;
        validateDuplicate(userLotto);
    }

    private void validateDuplicate(Lotto userLotto) {
        if (userLotto.isContain(number)){
            throw new IllegalStateException("중복된 번호입니다.");
        }
    }


}
