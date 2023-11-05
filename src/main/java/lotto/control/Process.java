package lotto.control;

import lotto.config.Config;
import lotto.domain.lotto.LottoEnvelop;
import lotto.domain.seller.LottoSeller;
import lotto.domain.user.User;

public class Process {
    private User user;
    private LottoSeller lottoSeller;

    public Process() {
        this.user = Config.user();
        this.lottoSeller = Config.lottoSeller();
    }

    /**
     * 로또를 산다.
     */
    public void buyLotto() {
        LottoEnvelop lottoEnvelop = null;

        // 유저가 로또를 산다.
        Integer moneyOfUser = user.payMoney();

        // 로또 판매자가 로또를 판다.
        lottoEnvelop = lottoSeller.sell(moneyOfUser);

        // 유저가 봉투를 받는다.
        user.takeLottoEnvelop(lottoEnvelop);
    }

    /**
     * 로또를 보여준다.
     */
    public StringBuilder showLotto() {
        return user.showLottoEnvelop();
    }

    /**
     * 당첨 번호를 뽑는다.
     *
     * @param strLine
     */
    public void pickNum(String strLine) {
        // 로또진행자가 당첨 번호를 뽑는다.
        // 로또 진행자가 보너스 번호를 입력한다.
    }

    /**
     * 당첨의 결과를 보여준다.
     *
     * @return
     */
    public StringBuilder showResult() {
        // 유저가 결과를 통계한다.
        // 유저가 수익률을 계산한다.
        return null;
    }
}
