package lotto.view;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static lotto.view.Exceptions.validateDivisibleAmount;
import static lotto.view.Exceptions.validateDuplicateNum;
import static lotto.view.Exceptions.validateExceedMinimum;
import static lotto.view.Exceptions.validateLottoLength;
import static lotto.view.Exceptions.validateLottoNum;
import static lotto.view.Exceptions.validateNumber;

import java.util.ArrayList;
import java.util.List;

public class InputView {
    public static int inputPurchaseAmount() {
        int purchaseAmount = 0;
        try {
            purchaseAmount = changeToInt(readLine());
            validateExceedMinimum(purchaseAmount);
            validateDivisibleAmount(purchaseAmount);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputPurchaseAmount();
        }
        return purchaseAmount;
    }

    public static int changeToInt(String input) {
        int changedInt = 0;
        try {
            changedInt = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            validateNumber();
        }
        return changedInt;
    }

    public static List<Integer> inputWinningNum() {
        List<Integer> nums = new ArrayList<>();
        try {
            String[] winningNum = readLine().split(",");
            validateLottoLength(winningNum.length);

            for (String num : winningNum) {
                int number = changeToInt(num);
                validateLottoNum(number);
                validateDuplicateNum(number, nums);
                nums.add(number);
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputWinningNum();
        }
        return nums;
    }

    public static int inputBonusNum(List<Integer> winningNum) {
        int bonusNum = 0;
        try {
            bonusNum = changeToInt(readLine());
            validateLottoNum(bonusNum);
            validateDuplicateNum(bonusNum, winningNum);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputBonusNum(winningNum);
        }
        return bonusNum;
    }
}

