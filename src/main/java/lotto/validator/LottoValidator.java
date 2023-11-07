package lotto.validator;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoValidator extends Validator {
    public static List<Integer> LottoWinNumbers(String winNumbers) {
        List<Integer> parsedNumbers = parseWinNumbers(winNumbers);
        validateWinNumbers(parsedNumbers);
        return parsedNumbers;
    }

    private static void validateWinNumbers(List<Integer> parsedNumbers) {
        if (parsedNumbers.size() != 6) {
            throwException("당첨번호는 6개 입력해야 합니다.", null);
        }
        Set<Integer> uniqueNumbers = new HashSet<>();
        for (int number : parsedNumbers) {
            if (number < 1 || number > 45) {
                throwException("당첨번호는 1부터 45 사이의 숫자여야 합니다.", null);
            }
            if (!uniqueNumbers.add(number)) {
                throwException("당첨번호에 중복된 숫자가 있습니다.", null);
            }
        }
    }

    private static List<Integer> parseWinNumbers(String winNumbers) {
        String[] numberStrings = winNumbers.split(",");
        List<Integer> parsedNumbers = new ArrayList<>();
        for (String numberWin : numberStrings) {
            int number = parseNumber(numberWin);
            parsedNumbers.add(number);
        }
        return parsedNumbers;
    }

    private static int parseNumber(String numberWin) {
        try {
            return Integer.parseInt(numberWin.trim());
        } catch (NumberFormatException e) {
            throwException("당첨번호는 숫자로만 입력해야 합니다.", e);
            return -1;
        }
    }
}
