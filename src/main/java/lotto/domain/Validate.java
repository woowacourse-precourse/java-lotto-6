package lotto.domain;

import java.util.List;
import lotto.ErrorMessage;

public class Validate {
    public static void validateBonusNum(int input, List<Integer> WinningNum) {
        boolean containInput = WinningNum.stream()
                .anyMatch(num -> num == input);
        if (containInput) {
            ErrorMessage.redundantExcept();
            throw new IllegalArgumentException();
        }
    }
}
