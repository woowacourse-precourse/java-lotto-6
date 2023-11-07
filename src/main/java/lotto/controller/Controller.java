package lotto.controller;

import lotto.domain.Buyer;
import lotto.domain.Lotto;
import lotto.domain.Statistics;
import lotto.domain.WinningLotto;
import lotto.view.View;

import java.util.List;

import static lotto.view.constant.Message.*;

public class Controller {

    private final static View view = new View();
    public void start() {
        view.output(INPUT_COST);
        Buyer buyer = view.inputAndValidateCost();

        int count = buyer.getBuyCount();
        view.output(String.format(OUTPUT_BUY, count));

        List<Lotto> lottos = generateLottos(count);
        for (Lotto lotto : lottos) {
            view.output(lotto.toString());
        }

        view.output(INPUT_MATCH);
        WinningLotto winningLotto = view.inputAndValidateWinningLotto();

        view.output(INPUT_BONUS);
        int bonus = view.inputAndValidateBonus(winningLotto);

        view.output(WINNING_STATISTICS);
        Statistics statistics = Statistics.calculate(lottos, winningLotto, bonus);
        view.output(statistics.toString());

        view.output(String.format(REVENUE_RATE, statistics.calculateRevenueRate(buyer)));
    }

    private Buyer getCost() {
        try {
            int cost = view.inputCost();
            return new Buyer(cost);
        } catch (IllegalArgumentException e) {
            view.output(e.getMessage());
            return getCost();
        }
    }
}
