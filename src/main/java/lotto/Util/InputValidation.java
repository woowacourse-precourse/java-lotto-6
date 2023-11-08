package lotto.Util;

import camp.nextstep.edu.missionutils.Console;
import lotto.Domain.EntireMessage;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class InputValidation {
    public static List<Integer> getWinningNumbers() {
        List<Integer> winningNumbers = new ArrayList<>();
        Set<Integer> uniqueNumbers = new HashSet<>(); // 중복 검사를 위한 Set

        while (winningNumbers.size() < 6) {
            System.out.println(EntireMessage.WINNING_NUMBERS_MSG);
            String input = Console.readLine();
            if (processNumberInput(input, winningNumbers, uniqueNumbers)) {
                break;
            }
        }

        return winningNumbers;
    }

    private static boolean processNumberInput(String input, List<Integer> winningNumbers, Set<Integer> uniqueNumbers) {
        String[] numberStrings = input.split(",");
        if (isInvalidInputFormat(numberStrings, winningNumbers)) {
            return false;
        }
        for (String numberString : numberStrings) {
            int number = Integer.parseInt(numberString);
            if (isInvalidLottoNumber(number, uniqueNumbers)) {
                continue;
            }
            winningNumbers.add(number);
            uniqueNumbers.add(number);
        }
        return winningNumbers.size() >= 6;
    }

    private static boolean isInvalidInputFormat(String[] numberStrings, List<Integer> winningNumbers) {
        if (numberStrings.length != 6) {
            EntireMessage.displayError(EntireMessage.ERROR_MSG_LENGTH);
            winningNumbers.clear();
            return true;
        }
        return false;
    }

    private static boolean isInvalidLottoNumber(int number, Set<Integer> uniqueNumbers) {
        if (!isValidLottoNumber(number) || isDuplicateNumber(uniqueNumbers, number)) {
            return true;
        }
        return false;
    }

    private static boolean isValidLottoNumber(int number) {
        return number >= 1 && number <= 45;
    }

    private static boolean isDuplicateNumber(Set<Integer> uniqueNumbers, int number) {
        if (uniqueNumbers.contains(number)) {
            EntireMessage.displayError(EntireMessage.ERROR_MSG_DUPLICATED);
            return true;
        }
        return false;
    }
}