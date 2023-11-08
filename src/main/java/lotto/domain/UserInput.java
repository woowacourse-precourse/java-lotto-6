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
        return purchaseAmount; // 잘못된 값이면 0
    }

    public List<Integer> getUserWinningNumbers(UserInputChecker checker, String inputWinningNumbers) { // 당첨번호
        List<Integer> checkedNumbers = new ArrayList<>();
        String[] winnigNumbers = inputWinningNumbers.split(",");
        checkedNumbers = checker.checkWinningNumbers(winnigNumbers);
        return checkedNumbers; // 잘못된 값이면 null
    }

    public int getUserBonusNumber(UserInputChecker checker, String inputBonusNumber) { // 보너스번호
        int bonusNumber = checker.checkBonusNumber(inputBonusNumber);
        return bonusNumber; // 잘못된 값이면 0
    }

}
