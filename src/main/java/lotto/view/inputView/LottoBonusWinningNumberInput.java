package lotto.view.inputView;

import camp.nextstep.edu.missionutils.Console;

import static lotto.constant.ViewMessages.Bonus_Number_Request;

public class LottoBonusWinningNumberInput {
    public String requestBonusNumber() {
        System.out.println(Bonus_Number_Request );
        return Console.readLine();
    }
}