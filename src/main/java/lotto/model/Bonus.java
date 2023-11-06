package lotto.model;

public class Bonus {
    private final Integer bonusNumber;

    public Bonus (Integer bonusNumber) {
        validateRange(bonusNumber);

        this.bonusNumber = bonusNumber;
    }

    private void validateRange(Integer number) {
        if (number < START_RANGE_OF_NUMBER || END_RANGE_OF_NUMBER < number) { // 상수 enum 추가
            throw new IllegalArgumentException(); // 에러문 추가
        }
    }

    public Integer countMatchesBonus(Lotto targetLotto) {
        Integer count = 0;

        if (targetLotto.isMatch(bonusNumber)) {
            ++count;
        }

        return count;
    }
}
