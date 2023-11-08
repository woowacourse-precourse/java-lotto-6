package lotto.domain.lotto;

import static lotto.domain.constant.LottoConstant.LOTTO_MAXIMUM_NUMBER;
import static lotto.domain.constant.LottoConstant.LOTTO_MINIMUM_NUMBER;

public class BonusNumber {

    private final int number;

    private BonusNumber(int number) {
        this.number = number;
    }

    public static BonusNumber of(int number, Lotto lotto) {
        validateRange(number);
        validateContainsInLotto(number, lotto);
        return new BonusNumber(number);
    }

    private static void validateRange(int number) {
        if (number < LOTTO_MINIMUM_NUMBER || number > LOTTO_MAXIMUM_NUMBER) {
            throw new IllegalArgumentException(
                String.format("보너스 번호는 %d 이상 %d 이하여야 합니다.",
                    LOTTO_MINIMUM_NUMBER, LOTTO_MAXIMUM_NUMBER)
            );
        }
    }

    private static void validateContainsInLotto(int number, Lotto lotto) {
        if (lotto.contains(number)) {
            throw new IllegalArgumentException("보너스 번호는 로또 번호와 중복될 수 없습니다.");
        }
    }

    public int getNumber() {
        return number;
    }

    public boolean containsInLotto(Lotto lotto) {
        return lotto.contains(number);
    }
}
