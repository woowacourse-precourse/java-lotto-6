package lotto.config;

import lotto.control.Process;
import lotto.domain.host.LottoHost;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoEnvelop;
import lotto.domain.number.BonusLottoNum;
import lotto.domain.number.LottoTargetNumResults;
import lotto.domain.number.RanNumbers;
import lotto.domain.number.WinLottoNumbers;
import lotto.domain.seller.LottoSeller;
import lotto.domain.user.Judgment;
import lotto.domain.user.RateResult;
import lotto.domain.user.Statistic;
import lotto.domain.user.User;
import lotto.view.ShowLottoProcess;

import java.util.List;

public class Config {
    public static Process process() {
        return new Process();
    }

    public static LottoHost lottoHost() {
        return new LottoHost();
    }

    public static Lotto lotto() {
        return new Lotto(RanNumbers.createLottoNumbers());
    }

    public static LottoEnvelop lottoEnvelop() {
        return new LottoEnvelop();
    }

    public static BonusLottoNum bonusLottoNum(Integer bonusNumber) {
        return new BonusLottoNum(bonusNumber);
    }

    public static LottoTargetNumResults lottoTargetNumResults(List<Integer> winNumbers, Integer bonusNumber) {
        return new LottoTargetNumResults(winNumbers, bonusNumber);
    }

    public static WinLottoNumbers winLottoNums(List<Integer> strOfPickWinNum) {
        return new WinLottoNumbers(strOfPickWinNum);
    }

    public static LottoSeller lottoSeller() {
        return new LottoSeller();
    }

    public static Judgment judgment(LottoTargetNumResults lottoTargetNumResults) {
        return new Judgment(lottoTargetNumResults);
    }

    public static RateResult rateResult() {
        return new RateResult();
    }

    public static Statistic statistic(LottoEnvelop lottoEnvelop, LottoTargetNumResults lottoTargetNumResults) {
        return new Statistic(lottoEnvelop, lottoTargetNumResults);
    }

    public static User user() {
        return new User();
    }

    public static ShowLottoProcess showLottoProcess() {
        return new ShowLottoProcess();
    }
}
