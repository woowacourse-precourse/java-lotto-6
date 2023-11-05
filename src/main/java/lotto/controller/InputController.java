package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import lotto.view.ErrorMessage;
import java.util.ArrayList;
import java.util.List;
import java.util.HashSet;
import java.util.Set;

public class InputController {
    static int setAmount() {
        int amount = validateAmount(Console.readLine());
        return amount;
    }

    static List<Integer> setWinningNum() {
        List<Integer> winningNum = validateWinningNum(Console.readLine());
        Set<Integer> numSet = new HashSet<>(winningNum);
        if (winningNum.size() != numSet.size()) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATION.getMessage());
        }
        return winningNum;
    }
    
    static int setBonusNum() {
        int bonusNum = validateBonusNum(Console.readLine());
        return bonusNum;
    }

    private static int validateAmount(String input) {
        int amount = validateType(input);
        
        if ((amount % 1000) != 0 || amount < 1000) {
            throw new IllegalArgumentException(ErrorMessage.WRONG_AMOUNT.getMessage());
        }
        return amount;
    }

    private static List<Integer> validateWinningNum(String input) {
        String[] numbers = input.split(",");
        List<Integer> winningNum = validateType(numbers);
        if (numbers.length != 6) {
            throw new IllegalArgumentException(ErrorMessage.WRONG_LENGTH.getMessage());
        }

        winningNum.forEach((number) -> {
            validateRange(number);
        });

        return winningNum;
    }

    private static int validateBonusNum(String input) {
        int bonusNum = validateType(input);
        validateRange(bonusNum);
        return bonusNum;
    }

    private static void validateRange(int number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException(ErrorMessage.WRONG_RANGE.getMessage());
        }
    }

    private static int validateType(String input) {
        int result;
        try {
            result = Integer.parseInt(input);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(ErrorMessage.WRONG_TYPE.getMessage());
        }
        return result;
    }

    private static List<Integer> validateType(String[] numbers) {  //오버로드
        List<Integer> result = new ArrayList<Integer>();
        try {
            for (String number : numbers) {
                result.add(Integer.parseInt(number));
            }
        } catch (Exception e) {
            throw new IllegalArgumentException(ErrorMessage.WRONG_TYPE.getMessage());
        }
        return result;
    }
}
