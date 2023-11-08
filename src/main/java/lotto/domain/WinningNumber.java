package lotto.domain;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class WinningNumber {
    private static List<Integer> winningNumbers;
    private static final int THE_NUMBER_OF_WINNING_NUMBER = 6;


    public List<Integer> createWinningNumber() {
        System.out.println("\n당첨 번호를 입력해 주세요.");
        List<Integer> winningNumberInput;

        while (true) {
            try {
                winningNumberInput = validateFormat(readLine());
                validate(winningNumberInput);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return winningNumbers = winningNumberInput;
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }

    private void validate(List<Integer> winningNumberInput) {
        validateCount(winningNumberInput);
        validateDuplicate(winningNumberInput);
    }

    private List<Integer> validateFormat(String winningNumberInput) {
        List<Integer> result = new ArrayList<>();

        for (String s : winningNumberInput.split(",")) {
            try {
                result.add(Integer.parseInt(s));
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("[ERROR] 숫자를 입력해주세요.");
            }
        }
        return result;
    }

    private void validateCount(List<Integer> winningNumberInput) {
        if (winningNumberInput.size() != THE_NUMBER_OF_WINNING_NUMBER) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호 6개를 입력해주세요.");
        }
    }

    private void validateDuplicate(List<Integer> winningNumberInput) {
        if (winningNumberInput.stream().distinct().count() != THE_NUMBER_OF_WINNING_NUMBER) {
            throw new IllegalArgumentException("[ERROR] 중복되지 않는 숫자 6개를 입력해주세요.");
        }
    }
}
