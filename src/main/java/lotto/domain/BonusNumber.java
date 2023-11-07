package lotto.domain;

import java.util.List;
import lotto.util.Util;
import lotto.util.enumerator.LottoRank;

public class BonusNumber {
    private final int number;

    public BonusNumber(int number) {
        this.number = number;
    }

    public LottoRank compareWithLottoNumber(List<Integer> lottoNumbers) {
        if (isMatchWithLottoNumbers(lottoNumbers)) {
            return LottoRank.SECOND;
        }
        return LottoRank.THIRD;
    }

    private boolean isMatchWithLottoNumbers(List<Integer> numbers) {
        int bonus = this.number;
        for (int number : numbers) {
            if (Util.isEqual(number, bonus)) {
                return true;
            }
        }
        return false;
    }
}
