package lotto;

import java.util.List;

public class LottoController {
    private Player player;
    private WinningNumber winningNumber;

    public void execute() {
        settingPlayer();
        player.buyLotto();
        player.outputLottoInfo();
        selectWinningNumber();
        outputWinningStatistics();
    }

    private void settingPlayer() {
        this.player = initPlayer();
    }

    private Player initPlayer() {
        while (true) {
            try {
                int purchaseAmount = PromptHandler.inputPurchaseAmount();
                return Player.initialize(purchaseAmount);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void selectWinningNumber() {
        winningNumber = initWinningNumber();
        addBonusNumber();
    }

    private WinningNumber initWinningNumber() {
        while (true) {
            try {
                List<Integer> numbers = PromptHandler.inputWinningNumbers();
                return new WinningNumber(numbers);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void addBonusNumber() {
        while (true) {
            try {
                Integer bonusNumber = PromptHandler.inputBonusNumber();
                winningNumber.addBonusNumber(bonusNumber);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void outputWinningStatistics() {
        WinningStatistics winningStatistics = calculateStatistic();
        winningStatistics.outputAllStatisticsInfo();

        player.outputYieldResult(winningStatistics.calculatePrizeMoney());
    }

    private WinningStatistics calculateStatistic() {
        ResultDTO resultDTO = player.calculateResult(winningNumber);
        int quantity = player.getPurchaseQuantity();

        return new WinningStatistics(resultDTO, quantity);
    }
}
