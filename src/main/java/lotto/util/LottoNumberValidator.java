package lotto.util;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoNumberValidator {

    private static final int MIN_LOTTO_NUM = 1;
    private static final int MAX_LOTTO_NUM = 45;

    public static void validateWinningNumber(List<Integer> winningNumber) {
        validateIsBetween(winningNumber);
        validateIsNotOverlap(winningNumber);
    }

    private static void validateIsNotOverlap(List<Integer> winningNumber) {
        Set<Integer> isOverlap = new HashSet<>();
        for (int i = 0; i < winningNumber.size(); i++) {
            isOverlap.add(winningNumber.get(i));
        }

        if (isOverlap.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복되면 안됩니다.");
        }

    }

    private static void validateIsBetween(List<Integer> winningNumber) {
        for (int i = 0; i < winningNumber.size(); i++) {
            if (winningNumber.get(i) < MIN_LOTTO_NUM || winningNumber.get(i) > MAX_LOTTO_NUM) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1과 45 사이의 숫자여야 합니다.");
            }
        }
    }
}
