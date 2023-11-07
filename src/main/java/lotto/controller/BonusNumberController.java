package lotto.controller;

import lotto.view.BonusNumberInput;
import lotto.view.Input;

public class BonusNumberController {

    private static final String ENTER_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";
    private static final Input bonusNumberInput = new BonusNumberInput();
    private static final WinningStatisticsController winningStatisticsController = new WinningStatisticsController();
    public static int bonusNumber = 0;

    public void start() {
        System.out.println(ENTER_BONUS_NUMBER);
        bonusNumber = Integer.parseInt(bonusNumberInput.readLine());
        winningStatisticsController.start();
    }

}
