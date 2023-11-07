package lotto.domain;

import java.util.List;

public class LottoOwner {
    private List<Lotto> lottos;
    private int spendMoney;
    private long gainMoney;

    public LottoTicket purchaseLotto(int money) {
        spendMoney = money;
        LottoTicket lottoTicket = new LottoTicket(money);
        lottos = lottoTicket.generateLottos();
        return lottoTicket;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public void calculateResult(WinningNumber winningNumber) {
        for (Lotto lotto : lottos) {
            Rank rank = winningNumber.calculateRank(lotto);
            gainMoney += rank.getPrize();
        }
    }

    public YieldRate calculateYieldRate() {
        return new YieldRate(spendMoney, gainMoney);
    }
}
