package lotto.domain;

import camp.nextstep.edu.missionutils.Console;

public class UserInput {
    public UserInput() {
    }

    public String input() {
        String input = Console.readLine();

        return input;
    }

    public int getUserPurchaseAmount(UserInputChecker checker, String inputPurchaseAmount) { // 구입금액
        int purchaseAmount = checker.checkPurchaseAmount(inputPurchaseAmount);
        return purchaseAmount;
    }

    public int getUserWinningNumbers(String inputWinningNumbers) { // 당첨번호

        return 0;
    }

    public int getUserBonusNumber() { // 보너스번호
        return 0;
    }

}
