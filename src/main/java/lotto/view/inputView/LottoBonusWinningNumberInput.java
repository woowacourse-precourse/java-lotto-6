package lotto.view.inputView;

import camp.nextstep.edu.missionutils.Console;

import static lotto.constant.ViewMessages.BONUS_NUMBER_REQUEST;

public class LottoBonusWinningNumberInput {
    public String requestBonusNumber() {
        System.out.println(BONUS_NUMBER_REQUEST );
        return Console.readLine();
    }
}