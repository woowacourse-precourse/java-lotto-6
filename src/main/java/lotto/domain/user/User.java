package lotto.domain.user;

import Validate.ValidateException;
import lotto.config.Config;
import lotto.domain.lotto.LottoEnvelop;
import lotto.domain.number.LottoTargetNumResults;
import lotto.utill.Input;

public class User {
    private LottoEnvelop lottoEnvelop;
    private Statistic statistic;
    private Integer useMoney;
    private Integer totalWinMoney;
    private RateResult rateResult;
    private LottoTargetNumResults lottoTargetNumResults;

    public User() {
        this.lottoEnvelop = null;
        this.statistic = null;
        this.useMoney = 0;
        this.totalWinMoney = 0;
        this.rateResult = Config.rateResult();
    }

    public void takeTargetNumResults(LottoTargetNumResults lottoTargetNumResults) {
        this.lottoTargetNumResults = lottoTargetNumResults;
    }

    public Integer payMoney() {
        useMoney = inputMoney();

        ValidateException.isMultipleOf1000(useMoney);

        return useMoney;
    }

    public void takeLottoEnvelop(LottoEnvelop lottoEnvelop) {
        this.lottoEnvelop = lottoEnvelop;
    }


    public StringBuilder showLottoEnvelop() {
        return lottoEnvelop.giveInformation();
    }

    public StringBuilder showLottoStatisticResult(LottoTargetNumResults lottoTargetNumResults) {
        takeTargetNumResults(lottoTargetNumResults);
        statistic = Config.statistic(lottoEnvelop, lottoTargetNumResults);

        return statistic.show();
    }

    public StringBuilder showRateResult() {
        totalWinMoney = statistic.getTotalWinMoney();

        return rateResult.giveRateResult(useMoney, totalWinMoney);
    }

    private Integer inputMoney() {
        return Input.InputNumber();
    }
}
