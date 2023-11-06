package lotto.domain;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class UserInput {
    public UserInput() {
    }

    public String input() {
        String input = Console.readLine();

        return input;
    }

    public int getUserPurchaseAmount(UserInputChecker checker, String inputPurchaseAmount) { // 구입금액
        int purchaseAmount = checker.checkPurchaseAmount(inputPurchaseAmount);
        if (purchaseAmount == 0)
            return 0;
        return purchaseAmount;
    }

    public List<Integer> getUserWinningNumbers(UserInputChecker checker, String inputWinningNumbers) { // 당첨번호
        String[] winnigNumbers = inputWinningNumbers.split(",");
        List<Integer> checkedNumbers = new ArrayList<>();
        checkedNumbers =  checker.checkWinningNumbers(winnigNumbers);
        if (checkedNumbers == null)
            return null;

        return checkedNumbers;
    }

    public int getUserBonusNumber() { // 보너스번호
        return 0;
    }

}
