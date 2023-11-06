package lotto.model;

import java.util.List;
import java.util.Objects;
import lotto.constant.LottoGrade;

public class WinningLotto extends Lotto {
    private Integer bonusNumber;

    public WinningLotto(List<Integer> numbers) {
        super(numbers);
    }

    public void setBonusNumber(Integer bonusNumber) {
        validBonusNumber(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private void validBonusNumber(Integer bonusNumber) {
        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException("보너스 번호는 1~45이어야 합니다.");
        }
        if (super.isContain(bonusNumber)) {
            throw new IllegalArgumentException("보너스 번호는 당첨 번호랑 중복될 수 없습니다.");
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