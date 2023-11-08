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
        try {
            int purchaseAmount = changeToInt(readLine());
            validateExceedMinimum(purchaseAmount);
            validateDivisibleAmount(purchaseAmount);
            return purchaseAmount;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputPurchaseAmount();
        }
    }

    public static int changeToInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            validateNumber();
            return -1;
        }
    }

    public static List<Integer> inputWinningNum() {
        try {
            List<Integer> winningNums = new ArrayList<>();
            String[] inputNums = readLine().split(",");
            validateLottoLength(inputNums.length);

            for (String num : inputNums) {
                int eachWinningNum = getEachWinningNum(num, winningNums);
                winningNums.add(eachWinningNum);
            }
            return winningNums;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputWinningNum();
        }
    }

    public static int getEachWinningNum(String num, List<Integer> winningNums) throws IllegalArgumentException {
        int number = changeToInt(num);
        validateLottoNum(number);
        validateDuplicateNum(number, winningNums);
        return number;
    }


    public static int inputBonusNum(List<Integer> winningNum) {
        try {
            int bonusNum = changeToInt(readLine());
            validateLottoNum(bonusNum);
            validateDuplicateNum(bonusNum, winningNum);
            return bonusNum;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputBonusNum(winningNum);
        }
    }
}

