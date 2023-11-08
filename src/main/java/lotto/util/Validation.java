package lotto.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Validation {
    private static final int LOTTO_SIZE = 6;
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;
    public static int validateAndParsePaidAmount(String input) {
        try {
            int paidAmount = Integer.parseInt(input);
            if (paidAmount <= 0 || paidAmount % 1000 != 0) {
                throw new IllegalArgumentException("구입 금액은 1,000원 단위의 양의 정수여야 합니다.");
            }
            return paidAmount;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("구입 금액이 숫자가 아닙니다.");
        }
    }

    public void validateWinningNumbers(List<Integer> numbers) {
        // 당첨 번호의 유효성을 검증하는 로직을 구현합니다.

        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException("당첨 번호는 정확히 " + LOTTO_SIZE + "개 이어야 합니다.");
        }
        if (numbers.stream().distinct().count() != LOTTO_SIZE) {
            throw new IllegalArgumentException("중복된 당첨 번호가 있습니다.");
        }
        if (numbers.stream().anyMatch(n -> n < MIN_LOTTO_NUMBER || n > MAX_LOTTO_NUMBER)) {
            throw new IllegalArgumentException("당첨 번호는 " + MIN_LOTTO_NUMBER + "에서 "
                    + MAX_LOTTO_NUMBER + " 사이의 숫자여야 합니다.");
        }
    }

}
