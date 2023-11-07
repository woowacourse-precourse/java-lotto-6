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

    public StringBuilder showLottosInformation() {
        return user.showLottoEnvelop();
    }

    public void pickWinNumber() {
        lottoHost.pickWinNumbers();
    }

    public void pickBonusNumber() {
        lottoHost.pickBonusNumber();
    }

    public StringBuilder showStatisticResult() {
        lottoTargetNumResults = lottoHost.giveLottoTargetNumResults();

        return user.showLottoStatisticResult(lottoTargetNumResults);
    }

    public StringBuilder showRateResult() {
        return user.showRateResult();
    }
}
