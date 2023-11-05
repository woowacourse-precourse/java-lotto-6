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
        int bonusNum = Integer.parseInt(Console.readLine());
    }

    int validateAmount(String input) {
        int amount;
        try {
            amount = Integer.parseInt(input);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(ErrorMessage.WRONG_TYPE.getMessage());
        }
        if ((amount % 1000) != 0 || amount < 1000) {
            throw new IllegalArgumentException(ErrorMessage.WRONG_AMOUNT.getMessage());
        }
        return amount;
    }

    List<Integer> validateWinningNum(String input) {
        List<Integer> winningNum = new ArrayList<Integer>();
        String[] numbers = input.split(",");

        if (numbers.length != 6) {
            throw new IllegalArgumentException(ErrorMessage.WRONG_LENGTH.getMessage());
        }

        try {
            for (String number : numbers) {
                winningNum.add(Integer.parseInt(number));
            }
        } catch (Exception e) {
            throw new IllegalArgumentException(ErrorMessage.WRONG_TYPE.getMessage());
        }

        winningNum.forEach((number) -> {
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException(ErrorMessage.WRONG_RANGE.getMessage());
            }
        });

        return winningNum;
    }

    int validateonusNum(String input) {
        int bonusNum;
        try {
            bonusNum = Integer.parseInt(input);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(ErrorMessage.WRONG_TYPE.getMessage());
        }
        if (bonusNum < 1 || bonusNum > 45) {
                throw new IllegalArgumentException(ErrorMessage.WRONG_RANGE.getMessage());
            }
        return bonusNum;
    }
}
