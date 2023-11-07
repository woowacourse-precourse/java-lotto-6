package lotto.validator;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

public class LottoValidator extends Validator {

    public static int LottoWinNumber(String winNumbers) {
        validateWinNumbers(winNumbers);
        int WinNumber = parseValidInt(winNumbers);
        return WinNumber;
    }

    private static void validateWinNumbers(String winNumbers) {
        if (winNumbers == null || winNumbers.isEmpty()) {
            throwException("당첨번호를 입력해야 합니다.", null);
        }

        String[] numbers = winNumbers.split(",");
        if (numbers.length != 6) {
            throwException("당첨번호는 6개 입력해야 합니다.", null);
        }

        Set<Integer> uniqueNumbers = new HashSet<>();
        for (String numberStr : numbers) {
            int number = parseValidInt(numberStr);

            if (number < 1 || number > 45) {
                throwException("당첨번호는 1부터 45 사이의 숫자여야 합니다.", null);
            }

            if (!uniqueNumbers.add(number)) {
                throwException("당첨번호에 중복된 숫자가 있습니다.", null);
            }
        }
    }

    public static int parseValidInt(String inputWinNumber) {
        if (!Pattern.matches("^[0-9]+$", inputWinNumber)) {
            throwException("당첨번호는 숫자로만 입력해야 합니다.", null);
        }

        int inputedNumber = Integer.parseInt(inputWinNumber);

        return inputedNumber;
    }
}
