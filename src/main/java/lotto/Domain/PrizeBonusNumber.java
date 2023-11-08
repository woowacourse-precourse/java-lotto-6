package lotto.Domain;

import lotto.Lotto;

import java.util.List;

public class PrizeBonusNumber {
    private final Lotto prizeBonusNumber;
    private final Integer bonusNumber;

    //당첨 로또 번호와 2등 보너스 번호 함수 화
    public PrizeBonusNumber(List<Integer> prizeBonusNumber, Integer bonusNumber) {
        this.prizeBonusNumber = new Lotto(prizeBonusNumber);
        this.bonusNumber = bonusNumber;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    public boolean isContain(int number) {
        return prizeBonusNumber.isContain(number);
    }
}
