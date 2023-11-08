package lotto.controller;

import lotto.domain.Buyer;
import lotto.domain.Lotto;
import lotto.domain.Statistics;
import lotto.domain.WinningLotto;
import lotto.view.View;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static lotto.view.constant.Message.*;

public class Controller {
    private static final View view = new View();
    public void start() {
        view.output(INPUT_COST);
        Buyer buyer = view.inputAndValidateCost();

        List<Lotto> lottos = buyLottos(buyer);

        view.output(INPUT_WINNING_LOTTO);
        WinningLotto winningLotto = view.inputAndValidateWinningLotto();

        view.output(INPUT_BONUS);
        int bonus = view.inputAndValidateBonus(winningLotto);

        Statistics statistics = new Statistics(lottos, winningLotto, bonus);
        displayStatistics(statistics);
        displayRevenueRate(buyer, statistics);
    }

    private List<Lotto> buyLottos(Buyer buyer) {
        int count = buyer.getBuyCount();
        List<Lotto> lottos = Stream.generate(() -> new Lotto(Lotto.generateLotto()))
                .limit(count)
                .collect(Collectors.toList());
        displayLottos(lottos, count);
        return lottos;
    }

    private void displayLottos(List<Lotto> lottos, int count) {
        view.output(String.format(OUTPUT_BUY, count));
        for (Lotto lotto : lottos) {
            view.output(lotto.toString());
        }
    }

    private void displayStatistics(Statistics statistics) {
        view.output(WINNING_STATISTICS);
        view.output(statistics.toString());
    }

    private void displayRevenueRate(Buyer buyer, Statistics statistics) {
        String revenueRate = statistics.calculateRevenueRate(buyer);
        view.output(String.format(REVENUE_RATE, revenueRate));
    }
}
