package lotto.domain;

import java.util.List;

public class WinningLotto {
    final Lotto lotto;
    final int bonusNumber;

    public WinningLotto(Lotto lotto, int bonusNumber) {
        validateBonusNumber(lotto, bonusNumber);
        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
    }

    private void validateBonusNumber(Lotto lotto, int bonusNumber) {
        if (lotto.hasNumber(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 로또 당첨 번호와 중복될 수 없습니다.");
        }
        validateRangeOfBonusNumber(bonusNumber);
    }

    private void validateRangeOfBonusNumber(int number) {
        final int INCLUSIVE_START = LottoSetting.NUMBER_RANGE_START.getValue();
        final int INCLUSIVE_END = LottoSetting.NUMBER_RANGE_END.getValue();

        if (number < INCLUSIVE_START || INCLUSIVE_END < number) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 "
                    + INCLUSIVE_START + "부터 "
                    + INCLUSIVE_END + " 사이의 숫자여야 합니다.");
        }
    }

    public List<Integer> getLottoNumbers() {
        return lotto.getNumbers();
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
