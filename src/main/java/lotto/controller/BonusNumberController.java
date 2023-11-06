package lotto.controller;

import lotto.view.BonusNumberInput;
import lotto.view.Input;

public class BonusNumberController {

    private static final String ENTER_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";
    Input bonusNumberInput = new BonusNumberInput();
    WinningStatisticsController winningStatisticsController = new WinningStatisticsController();

    public void start() {
        System.out.println(ENTER_BONUS_NUMBER);
        bonusNumberInput.readLine();
        winningStatisticsController.start();
    }
}
