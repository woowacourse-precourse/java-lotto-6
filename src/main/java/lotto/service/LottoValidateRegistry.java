package lotto.service;

import java.util.HashSet;
import java.util.List;

public class LottoValidateRegistry {
    public static void lottoTicketValidate (final List<Integer> userInput) {
        checkDuplicateNumbers(userInput);
        checkRangeOfNumbers(userInput);
        checkSizeOfNumbers(userInput);
    }

    private static void checkDuplicateNumbers (final List<Integer> userInput) {
        HashSet<Integer> set = new HashSet<>(userInput);
        if (set.size() != userInput.size()) {
            throw new IllegalArgumentException("[ERROR] 중복된 숫자가 있습니다.");
        }
    }
    private static void checkRangeOfNumbers (final List<Integer> userInput) {
        for (int number : userInput) {
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException("[ERROR] 1~45 사이의 숫자를 입력해주세요.");
            }
        }
    }
    private static void checkSizeOfNumbers (final List<Integer> userInput) {
        if (userInput.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }
}
