package lotto.generator;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import camp.nextstep.edu.missionutils.Console;
import lotto.Lotto;
import lotto.handler.ExceptionHandler;

public class WinningNumber {

    public static List<Integer> getWinningNumber() {
        System.out.println("\n당첨 번호를 입력해 주세요.");
        String rawWinningNumber = Console.readLine();

        List<Integer> winningNumber = parse(rawWinningNumber);
        winningNumber = updateWinningNumberWithValidation(rawWinningNumber, winningNumber);

        return winningNumber;
    }

    private static List<Integer> updateWinningNumberWithValidation(String rawWinningNumber, List<Integer> winningNumber) {
        while (true) {
            try {
                ExceptionHandler.checkNull(rawWinningNumber);
                ExceptionHandler.checkNumberFormat(rawWinningNumber);
                checkWinningNumber(winningNumber);

                return winningNumber;
            } catch (IllegalArgumentException | NullPointerException e) {
                ExceptionHandler.handle(e);
                rawWinningNumber = Console.readLine();
                winningNumber = parse(rawWinningNumber);
            }
        }
    }

    private static void checkWinningNumber(List<Integer> winningNumber) {
        try {
            if (winningNumber.size() != 6) {
                throw new IllegalArgumentException("Input 6 numbers. \n └─ errorVar : " + winningNumber);
            }
            Set<Integer> uniqueNumbers = new HashSet<>(winningNumber);
            if (uniqueNumbers.size() != winningNumber.size()) {
                throw new IllegalArgumentException("There are duplicate numbers on lottery list. \n └─ errorVar : " + winningNumber);
            }
            for (int number : winningNumber) {
                if (number < 1 || number > 45) {
                    throw new IllegalArgumentException("Input number between 1 and 45. \n └─ errorVar : " + number);
                }
            }
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    private static List<Integer> parse(String rawWinningNumber) {
        String[] winningNumbers = rawWinningNumber.split(",");
        List<Integer> winningNumber = new ArrayList<>();
        for (String winningNum : winningNumbers) {
            winningNumber.add(Integer.parseInt(winningNum));
        }
        return winningNumber;
    }
}
