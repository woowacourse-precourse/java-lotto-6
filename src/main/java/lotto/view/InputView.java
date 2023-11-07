package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import lotto.enums.Constants;
import lotto.utils.Split;
import lotto.utils.ValidateCheck;

import java.util.List;

public class InputView {
    public static int intputAmount(String input) {
        try {
            ValidateCheck.pureIntegerCheck(input);
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            return intputAmount(Console.readLine());
        }
        int amount = Integer.parseInt(input);
        try {
            ValidateCheck.pureIntegerCheck(input);
            ValidateCheck.inputAmountValidate(amount);
            return amount / Constants.LOTTO_PRICE.getNumber();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return intputAmount(Console.readLine());
        }
    }

    public static List<Integer> choiceNumbers() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return numbers;
    }

    public static List<Integer> inputWinNumbers(String input) {
        try {
            List<Integer> winNumbers = Split.splitStringToInteger(input);
            ValidateCheck.numberCountValidate(winNumbers);
            ValidateCheck.numberDupulicationValidate(winNumbers);
            ValidateCheck.numbersRangeValidate(winNumbers);
            return winNumbers;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputWinNumbers(Console.readLine());
        }
    }

    public static int inputBonusNumber(String input, List<Integer> winNumbers) {
        try {
            ValidateCheck.pureIntegerCheck(input);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputBonusNumber(Console.readLine(), winNumbers);
        }
        int bonusNumber = Integer.parseInt(input);
        try {
            ValidateCheck.numberRangeValidate(bonusNumber);
            ValidateCheck.isNumberExist(bonusNumber, winNumbers);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputBonusNumber(Console.readLine(), winNumbers);
        }
        return bonusNumber;
    }
}
