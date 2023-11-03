package lotto;

import java.util.List;

public class Customer {
    private List<Lotto> lottoPapers;

    public void getLotto(List<Lotto> lottoPapers) {
        this.lottoPapers = lottoPapers;
    }

    public void insertMoney(final LottoStore lottoStore, final String money) {
        lottoStore.getMoney(money);
    }

    public void checkWinningNumber(LottoChecker lottoChecker) {
        lottoChecker.insertLottos(this.lottoPapers);
    }

}
