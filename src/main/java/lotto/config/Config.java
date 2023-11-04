package lotto.config;

import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoEnvelop;
import lotto.domain.num.BonusLottoNum;
import lotto.domain.num.LottoNumResults;
import lotto.domain.num.RanNumbers;
import lotto.domain.num.WinLottoNums;

public class Config {
    public static Lotto lotto() {
        return new Lotto(RanNumbers.createLottoNumbers());
    }

    public static WinLottoNums winLottoNums(String strOfPickWinNum) {
        return new WinLottoNums(strOfPickWinNum);
    }

    public static BonusLottoNum bonusLottoNum(String strOfPickBonusNum) {
        return new BonusLottoNum(strOfPickBonusNum);
    }

    public static LottoNumResults lottoNumResults(String strOfPickWinNum, String strOfPickBonusNum) {
        return new LottoNumResults(strOfPickWinNum, strOfPickBonusNum);
    }

    public static LottoEnvelop lottoEnvelop() {
        return new LottoEnvelop();
    }
}
