package validator;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WinningNumbersValidator {
    public static List<Integer> winningNumbersValidate(String winningNumbers) {
        winningNumbersNotNull(winningNumbers);
        winningNumbersComma(winningNumbers);
        winningNumbersEndComma(winningNumbers);
        List<String> winningSixNumbers = List.of(winningNumbers.split(","));
        winningNumbersSix(winningSixNumbers);
        winningNumberNotNull(winningSixNumbers);
        winningNumberRange(winningSixNumbers);
        winningNumberUnique(winningSixNumbers);
        List<Integer> lottoWinningNumbers = makeLottoWinningNumbers(winningSixNumbers);
        return lottoWinningNumbers;
    }

    public static List<Integer> makeLottoWinningNumbers(List<String> winningSixNumbers) {
        List<Integer> lottoWinningNumbers = new ArrayList<>();
        for (String winningNumber : winningSixNumbers) {
            try {
                int Num = Integer.parseInt(winningNumber);
                lottoWinningNumbers.add(Num);
            } catch (Exception e) {
                throw new IllegalArgumentException("[ERROR] 숫자를 입력해주세요");
            }
        }
        return lottoWinningNumbers;
    }

    private static void winningNumbersNotNull(String winningNumbers) {
        if (winningNumbers.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 값을 입력해주세요.");
        }
    }

    private static void winningNumbersComma(String winningNumbers) {
        if (!winningNumbers.matches("^[0-9,]*$")) {
            throw new IllegalArgumentException("[ERROR] 양의 정수를 쉼표로 구분해주세요.");
        }
    }

    private static void winningNumbersEndComma(String winningNumbers) {
        if (winningNumbers.endsWith(",")) {
            throw new IllegalArgumentException("[ERROR] 쉼표를 올바르게 사용해주세요");
        }
    }

    private static void winningNumbersSix(List<String> winningSixNumbers) {
        if (winningSixNumbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 양의 정수 6개를 입력해주세요.");
        }
    }

    private static void winningNumberNotNull(List<String> winningSixNumbers) {
        for (String winningNumber : winningSixNumbers) {
            if (winningNumber.isEmpty()) {
                throw new IllegalArgumentException("[ERROR] 쉼표를 올바르게 사용해주세요.");
            }
        }
    }

    public static void winningNumberRange(List<String> winningSixNumbers) {
        for (String winningNumber : winningSixNumbers) {
            if (!winningNumber.matches("([1-9]|[1-3][0-9]|4[0-5])")) {
                throw new IllegalArgumentException("[ERROR] 1부터 45까지의 수를 입력해주세요.");
            }
        }
    }

    public static void winningNumberUnique(List<String> winningSixNumbers) {
        Set<String> uniqueWinningNumbers = new HashSet<>();
        for (String number : winningSixNumbers) {
            if (!uniqueWinningNumbers.add(number)) {
                throw new IllegalArgumentException("[ERROR] 중복된 숫자를 사용하면 안됩니다.");
            }
        }

    }
}
