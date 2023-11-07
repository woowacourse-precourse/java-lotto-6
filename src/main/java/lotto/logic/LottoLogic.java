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
    private List<Integer> winningNumber;
    private int bonusNumber;

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

        winningNumber = inputController.getWinningNumbers();
        bonusNumber = inputController.getBonusNumber(winningNumber);

        List ranks = controller.getTotalRanking(winningNumber, bonusNumber);
        
        view.printScoreDetails(ranks);
        view.printTotalReturn(((float) getTotalRewards(ranks) / (float) payment) * 100);

    }

    private int getTotalRewards(List<Ranking> rankings) {
        return rankings.stream()
                .mapToInt(rank -> rank.getReward())
                .sum();
    }
}
