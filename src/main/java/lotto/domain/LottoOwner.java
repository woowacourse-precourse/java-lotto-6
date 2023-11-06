package lotto.domain;

import lotto.Lotto;

import java.util.List;

public class LottoOwner {
    private List<Lotto> lottos;
    private int spendMoney;
    private long gainMoney;

    public int purchaseLotto(int money) {
        spendMoney = money;
        LottoTicket lottoTicket = new LottoTicket(money);
        lottos = lottoTicket.generateLottos();
        return lottoTicket.getTicketNumber();
    }

    public List<String> getLottoNumbers() {
        return lottos.stream()
                .map(Lotto::toString)
                .toList();
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
