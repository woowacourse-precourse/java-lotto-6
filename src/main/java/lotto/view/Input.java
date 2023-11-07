package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import static lotto.utils.GameMessage.*;

public class Input {
    public String inputPurchaseAmount() {
        System.out.println(PURCHASE_AMOUNT.getMessage());
        return Console.readLine();
    }

    public String inputWinningNumber() {
        // 당첨 번호 입력
        System.out.println(WINNING_NUMBERS.getMessage());
        return Console.readLine();
    }

    public String inputBonusNumber() {
        // 보너스 번호 입력
        System.out.println(BONUS_NUMBER.getMessage());
        return Console.readLine();
    }
}
