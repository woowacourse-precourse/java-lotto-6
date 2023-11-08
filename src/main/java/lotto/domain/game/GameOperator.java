package lotto.domain.game;


import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoDraw;
import lotto.domain.money.Wallet;
import lotto.domain.prize.LottoPrizeSummary;
import lotto.domain.prize.Prizes;

import java.util.List;

public interface GameOperator {
    Wallet inputBuyPrice();

    void buyMessage(List<Lotto> lottos);

    LottoDraw inputAccordNumbers();

    void printResult(LottoPrizeSummary lottoPrizeSummary);

    void printProfitRatio(Wallet wallet, Prizes prizes);

    void print(String msg);
}
