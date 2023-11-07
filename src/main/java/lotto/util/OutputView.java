package lotto.util;

import lotto.domain.Lotto;

import java.util.List;

public class OutputView {
    public void viewBuyLotteries(List<Lotto> lotteries) {
        for (Lotto lotto : lotteries) {
            System.out.println(lotto);
        }
    }

}
