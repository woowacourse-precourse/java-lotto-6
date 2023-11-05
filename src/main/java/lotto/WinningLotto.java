package lotto;

import java.util.List;
import java.util.Objects;

public class WinningLotto extends Lotto {
    private Integer bonusNumber;

    public WinningLotto(List<Integer> numbers, Integer bonusNumber) {
        super(numbers);
        validBonusNumber(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private void validBonusNumber(Integer bonusNumber) {
        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException();
        }
        if (super.isContain(bonusNumber)) {
            throw new IllegalArgumentException();
        }
    }

    public LottoGrade determineLottoGrade(Lotto lotto) {
        int matchCount = 0;
        boolean matchBonus = false;
        List<Integer> numbers = lotto.getNumbers();

        for (int i = 0; i < numbers.size(); i++) {
            if (super.isContain(numbers.get(i))) {
                matchCount += 1;
            }
            if (Objects.equals(bonusNumber, numbers.get(i))) {
                matchBonus = true;
            }
        }

        return LottoGrade.findLottoGrade(matchCount, matchBonus);
    }
}