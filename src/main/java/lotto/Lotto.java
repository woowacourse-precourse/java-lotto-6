package lotto;

import static lotto.message.ErrorMessage.LOTTO_IS_NOT_SIX_DIGITS;
import static lotto.message.ErrorMessage.LOTTO_NUMBER_IS_DUPLICATED;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.utils.LottoUtil;

public class Lotto {
    private final List<Integer> numbers;
    public final static BigDecimal PRICE = BigDecimal.valueOf(1000);

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    @Override
    public String toString() {
        List<Integer> sortedNumbers = new ArrayList<>(numbers);
        Collections.sort(sortedNumbers);
        return sortedNumbers.toString();
    }

    public int getMatchCountWith(List<Integer> targetNumbers) {
        int matchCount = 0;
        for (Integer number : targetNumbers) {
            if (numbers.contains(number)) {
                matchCount += 1;
            }
        }
        return matchCount;
    }

    public boolean contains(int number) {
        return numbers.contains(number);
    }

    public static void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(LOTTO_IS_NOT_SIX_DIGITS.getMessage());
        }
        numbers.forEach(LottoUtil::validateLottoNum);
        validateDuplication(numbers);
    }

    private static void validateDuplication(List<Integer> numbers) {
        boolean[] visited = new boolean[46];
        numbers.forEach((num) -> {
            if (visited[num]) {
                throw new IllegalArgumentException(LOTTO_NUMBER_IS_DUPLICATED.getMessage());
            }
            visited[num] = true;
        });
    }
}
