package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import lotto.view.ErrorMessage;
import java.util.ArrayList;
import java.util.List;

public class InputController {
    void setAmount() {
        int amount = validateAmount(Console.readLine());
    }

    void setWinningNum() {
        List<Integer> winningNum = validateWinningNum(Console.readLine());
    }
    
    void setBonusNum() {
        int bonusNum = validateBonusNum(Console.readLine());
    }

    private int validateAmount(String input) {
        int amount = validateType(input);
        
        if ((amount % 1000) != 0 || amount < 1000) {
            throw new IllegalArgumentException(ErrorMessage.WRONG_AMOUNT.getMessage());
        }
        return amount;
    }

    private List<Integer> validateWinningNum(String input) {
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

    private int validateBonusNum(String input) {
        int bonusNum = validateType(input);
        validateRange(bonusNum);
        return bonusNum;
    }

    private void validateRange(int number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException(ErrorMessage.WRONG_RANGE.getMessage());
        }
    }

    private int validateType(String input) {
        int result;
        try {
            result = Integer.parseInt(input);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(ErrorMessage.WRONG_TYPE.getMessage());
        }
        return result;
    }

    private List<Integer> validateType(String[] numbers) {  //오버로드
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
