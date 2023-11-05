package lotto.config;

import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoEnvelop;
import lotto.domain.num.BonusLottoNum;
import lotto.domain.num.LottoNumResults;
import lotto.domain.num.RanNumbers;
import lotto.domain.num.WinLottoNums;
import lotto.domain.user.Statistic;
import lotto.domain.user.User;

public class Config {
    public static Lotto lotto() {
        return new Lotto(RanNumbers.createLottoNumbers());
    }

    public static LottoEnvelop lottoEnvelop() {
        return new LottoEnvelop();
    }

    public static BonusLottoNum bonusLottoNum(String strOfPickBonusNum) {
        return new BonusLottoNum(strOfPickBonusNum);
    }

    public static LottoNumResults lottoNumResults(String strOfPickWinNum, String strOfPickBonusNum) {
        return new LottoNumResults(strOfPickWinNum, strOfPickBonusNum);
    }

    public static WinLottoNums winLottoNums(String strOfPickWinNum) {
        return new WinLottoNums(strOfPickWinNum);
    }

    public static Statistic statistic(LottoEnvelop lottoEnvelop, LottoNumResults lottoNumResults) {
        return new Statistic(lottoEnvelop, lottoNumResults);
    }

    public static User user() {
        return new User();
    }
}
