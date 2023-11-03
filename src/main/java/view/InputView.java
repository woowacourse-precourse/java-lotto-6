package view;

import camp.nextstep.edu.missionutils.Console;

import config.OutputMessage;

import controller.GameController;

public class InputView {

    private final GameController gameController;

    public InputView(GameController gameController) {
        this.gameController = gameController;
    }

    public void inputPayment() {
        System.out.println(OutputMessage.DEPOSIT.getMessage());
        gameController.lottoAdd(Console.readLine());
    }

    public void inputWinNumber() {
        System.out.println(OutputMessage.WIN_NUMBER.getMessage());
        gameController.winningLottoAdd(Console.readLine());
    }

    public void inputBonusNumber() {
        System.out.println(OutputMessage.BONUS_NUMBER.getMessage());
        gameController.BonusLottoAdd(Console.readLine());
    }

}
