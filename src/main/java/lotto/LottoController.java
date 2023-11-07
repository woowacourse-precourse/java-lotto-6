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
        //TODO: 당첨 통계 출력
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
}
