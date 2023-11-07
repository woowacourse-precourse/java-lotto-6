package lotto.controller;

import lotto.domain.Buyer;
import lotto.domain.Lotto;
import lotto.domain.Statistics;
import lotto.domain.WinningLotto;
import lotto.view.View;

import java.util.ArrayList;
import java.util.List;

import static lotto.view.constant.Message.*;

public class Controller {

    private final static View view = new View();
    public void start() {
        view.output(INPUT_COST);
        Buyer buyer = getCost();

        int count = buyer.getBuyCount();
        view.output(String.format(OUTPUT_BUY, count));

        List<Lotto> lottos = generateLottos(count);
        for (Lotto lotto : lottos) {
            view.output(lotto.toString());
        }

        view.output(INPUT_MATCH);
        WinningLotto winningLotto = getMatchLotto();

        view.output(INPUT_BONUS);
        int bonus = getBonus(winningLotto);

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

    private List<Lotto> generateLottos(int count) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            Lotto lotto = new Lotto(Lotto.generateLotto());
            lottos.add(lotto);
        }
        return lottos;
    }

    private WinningLotto getMatchLotto() {
        try {
            List<Integer> matches = view.inputMatch();
            return new WinningLotto(matches);
        } catch (IllegalArgumentException e) {
            view.output(e.getMessage());
            return getMatchLotto();
        }
    }

    private int getBonus(WinningLotto winningLotto) {
        try {
            int bonus = view.inputBonus();
            winningLotto.validateBonus(bonus);
            return bonus;
        } catch (IllegalArgumentException e) {
            view.output(e.getMessage());
            return getBonus(winningLotto);
        }
    }
}
