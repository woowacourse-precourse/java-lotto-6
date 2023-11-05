package lotto.domain.user;

import camp.nextstep.edu.missionutils.Console;
import lotto.config.Config;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoEnvelop;
import lotto.domain.num.LottoTargetNumResults;

import java.util.List;

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
    public String payMoney() {
        // TODO: 11/5/23 Utill로 빼기
        String money = Console.readLine();
        useMoney = Integer.valueOf(money);

        return money;
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
    public StringBuilder showStatisticLottoResult() {
        statistic = Config.statistic(lottoEnvelop, lottoTargetNumResults);
        return statistic.show();
    }

    /**
     * 로또결과의 당첨에 대한 총 수익률을 계산한다.
     *
     * @return
     */
    public Double calculateTotalRate() {
        totalWinMoney = statistic.getTotalWinMoney();

        return rateResult.calculate(useMoney, totalWinMoney);
    }
}
