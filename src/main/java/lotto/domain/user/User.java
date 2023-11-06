package lotto.domain.user;

import Validate.ValidateException;
import lotto.config.Config;
import lotto.domain.lotto.LottoEnvelop;
import lotto.domain.num.LottoTargetNumResults;
import lotto.utill.Input;

/**
 * 사용자 클래스
 */
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

    /**
     * 돈을 지불한다.
     *
     * @return
     */
    public Integer payMoney() {
        // TODO: 11/6/23 예외 처리.
        useMoney = inputMoney();

        ValidateException.isMultipleOf1000(useMoney);

        return useMoney;
    }

    /**
     * 로또를 받는다.
     *
     * @param lottoEnvelop 로또들의 모임
     */
    public void takeLottoEnvelop(LottoEnvelop lottoEnvelop) {
        this.lottoEnvelop = lottoEnvelop;
    }


    /**
     * 로또를 보여준다.
     *
     * @return
     */
    public StringBuilder showLottoEnvelop() {
        return lottoEnvelop.giveInformation();
    }

    /**
     * 로또결과의 당첨에 대한 통계를 한다.
     *
     * @return
     */
    public StringBuilder showStatisticLottoResult(LottoTargetNumResults lottoTargetNumResults) {
        takeTargetNumResults(lottoTargetNumResults);
        statistic = Config.statistic(lottoEnvelop, lottoTargetNumResults);

        return statistic.show();
    }

    /**
     * 로또결과의 당첨에 대한 총 수익률을 계산한다.
     *
     * @return
     */
    public StringBuilder calculateTotalRate() {
        totalWinMoney = statistic.getTotalWinMoney();

        return rateResult.showRate(useMoney, totalWinMoney);
    }

    private Integer inputMoney() {
        return Input.InputNumber();
    }


}
