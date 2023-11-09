package lotto.logic;

import lotto.controller.InputController;
import lotto.controller.LottoController;
import lotto.model.Ranking;
import lotto.view.View;

import java.util.List;

public class LottoLogic implements Logic {
    private final InputController inputController;
    private final View view;
    private final LottoController controller;
    private boolean running = true;

    public LottoLogic(InputController inputController, LottoController lottoController) {
        this.inputController = inputController;
        this.view = inputController.getView();
        this.controller = lottoController;
    }

    @Override
    public void start() {
        while (running) {
            run();
        }
    }

    @Override
    public void run() {
        int payment = inputController.getPurchaseAmount();

        controller.generateLotto(payment);
        view.printAllLottery(controller.getLotteries());

        List winningNumbers = inputController.getWinningNumbers();
        int bonusNumber = inputController.getBonusNumber(winningNumbers);

        List ranks = controller.getTotalRanking(winningNumbers, bonusNumber);
        view.printScoreDetails(ranks);
        view.printTotalReturn(getTotalReturn(payment, ranks));
    }

    private int getTotalRewards(List<Ranking> rankings) {
        return rankings.stream()
                .mapToInt(rank -> rank.getReward())
                .sum();
    }

    private float getTotalReturn(int payment, List ranks) {
        return ((float) getTotalRewards(ranks) / (float) payment) * 100;
    }
}
