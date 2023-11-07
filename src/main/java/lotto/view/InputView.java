package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.WinningNumbers;

import java.util.ArrayList;
import java.util.List;

import static lotto.common.Validation.*;
import static lotto.domain.LottoConst.*;

public class InputView {


    public int inputPurchaseMoney() {
        try {
            System.out.println(INPUT_PURCHASE_MONEY);
            String input = Console.readLine();
            return validatePurchaseMoney(input);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputPurchaseMoney();
        }
    }

    public WinningNumbers createWinningNums() {
        try {
            System.out.println(INPUT_WINNING_NUMS);
            List<Integer> winningNums = inputWinningNums();
            int bonusNum = inputBonusNum(winningNums);
            return new WinningNumbers(winningNums, bonusNum);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return createWinningNums();
        }
    }

    private static List<Integer> inputWinningNums() {
        List<Integer> winningNums = parseInputWinningNums(Console.readLine());
        validateWinningNumbers(winningNums);
        return winningNums;
    }

    private static List<Integer> parseInputWinningNums(String input) {
        String[] split = input.split(",");
        List<Integer> winningNums = new ArrayList<>();
        for (String number : split) {
            winningNums.add(parseNumber(number));
        }
        return winningNums;
    }

    private static int parseNumber(String number) {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_INPUT_WINNING_NUMS_NUMBER);
        }
    }

    private int inputBonusNum(List<Integer> winningNums) {
        while (true) {
            try {
                System.out.println(INPUT_BONUS_NUM);
                int bonusNum = parseBonusNum(Console.readLine());
                validateBonusNum(winningNums, bonusNum);
                return bonusNum;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static int parseBonusNum(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_INPUT_NUM_IN_RANGE);
        }
    }

}
