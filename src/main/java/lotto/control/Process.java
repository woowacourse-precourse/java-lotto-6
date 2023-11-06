package lotto.control;

import lotto.config.Config;
import lotto.domain.host.LottoHost;
import lotto.domain.lotto.LottoEnvelop;
import lotto.domain.num.LottoTargetNumResults;
import lotto.domain.seller.LottoSeller;
import lotto.domain.user.User;

public class Process {
    private User user;
    private LottoSeller lottoSeller;
    private LottoHost lottoHost;
    private LottoTargetNumResults lottoTargetNumResults;

    public Process() {
        this.user = Config.user();
        this.lottoSeller = Config.lottoSeller();
        this.lottoHost = Config.lottoHost();
        lottoTargetNumResults = null;
    }

    /**
     * 로또를 산다.
     */
    public void buyLotto() {
        LottoEnvelop lottoEnvelop = null;
        Integer moneyOfUser = 0;

        moneyOfUser = user.payMoney();
        lottoEnvelop = lottoSeller.sell(moneyOfUser);
        user.takeLottoEnvelop(lottoEnvelop);
    }

    public String tellNumberLotto() {
        return lottoSeller.tellNumberLotto();
    }

    /**
     * 로또를 보여준다.
     */
    public StringBuilder showLottosInformation() {
        return user.showLottoEnvelop();
    }

    /**
     * 게임 진행자가 당첨 번호를 뽑는다.
     */
    public void pickWinNumber() {
        // 로또진행자가 당첨 번호를 뽑는다.
        lottoHost.pickWinNumbers();
    }

    public void pickBonusNumber() {
        lottoHost.pickBonusNumber();
    }

    /**
     * 당첨의 결과를 보여준다.
     *
     * @return
     */
    public StringBuilder showStatisticResult() {
        lottoTargetNumResults = lottoHost.giveLottoTargetNumResults();
        return user.showStatisticLottoResult(lottoTargetNumResults);
    }

    public StringBuilder showRateResult() {
        return user.calculateTotalRate();
    }
}
