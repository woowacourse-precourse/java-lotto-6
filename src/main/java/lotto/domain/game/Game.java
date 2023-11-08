package lotto.domain.game;


import lotto.application.RandomLottoPicker;
import lotto.controller.ConsoleInputOutput;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoPicker;
import lotto.domain.lotto.LottoDraw;
import lotto.domain.money.Wallet;
import lotto.domain.prize.Prize;
import lotto.domain.prize.LottoPrizeSummary;
import lotto.domain.prize.Prizes;

import java.util.List;
import java.util.Map;

public class Game {
    private final GameOperator operator = new ConsoleInputOutput();
    private final LottoPicker picker = new RandomLottoPicker();

    public void run() {
        Wallet wallet = depositWallet();

        Prizes prizes = buying(wallet);

        LottoPrizeSummary lottoPrizeSummary = new LottoPrizeSummary(calculateProfit(prizes));

        printResults(lottoPrizeSummary, wallet, prizes);
    }

    private Wallet depositWallet() {
        return operator.inputBuyPrice();
    }

    private Prizes buying(Wallet wallet) {
        List<Lotto> lottos = buyLotto(wallet);

        LottoDraw lottoDraw = generateResult();

        return compareLottos(lottos, lottoDraw);
    }

    private List<Lotto> buyLotto(Wallet wallet) {
        int currencyUnits = wallet.calculateCurrencyUnits();

        List<Lotto> lottos = picker.picker(currencyUnits);

        printBuyLotto(lottos);

        return lottos;
    }

    private void printBuyLotto(List<Lotto> lottos) {
        operator.buyMessage(lottos);
    }

    private LottoDraw generateResult() {
        return operator.inputAccordNumbers();
    }

    private Prizes compareLottos(List<Lotto> lottos, LottoDraw lottoDraw) {
        return lottoDraw.compare(lottos);
    }

    private Map<Prize, Long> calculateProfit(Prizes prizes) {
        return prizes.countPrizes();
    }

    private void printResults(LottoPrizeSummary lottoPrizeSummary, Wallet wallet, Prizes prizes) {
        operator.printResult(lottoPrizeSummary);
        operator.printProfitRatio(wallet, prizes);
    }
}
