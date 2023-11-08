package lotto.data;

import static lotto.message.ErrorMessage.LOTTO_IS_NOT_SIX_DIGITS;
import static lotto.message.ErrorMessage.LOTTO_NUMBER_IS_DUPLICATED;
import static lotto.message.ErrorMessage.LOTTO_NUMBER_IS_NOT_IN_RANGE;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;
    public static final int START_NUMBER = 1;
    public static final int END_NUMBER = 45;
    public static final int DIGITS = 6;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return new ArrayList<>(numbers);
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

    protected static void validateLottoNum(int num) {
        if (num < START_NUMBER) {
            throw new IllegalArgumentException(LOTTO_NUMBER_IS_NOT_IN_RANGE.getMessage());
        }
        if (num > END_NUMBER) {
            throw new IllegalArgumentException(LOTTO_NUMBER_IS_NOT_IN_RANGE.getMessage());
        }
    }

    public static void validate(List<Integer> numbers) {
        if (numbers.size() != DIGITS) {
            throw new IllegalArgumentException(LOTTO_IS_NOT_SIX_DIGITS.getMessage());
        }
        numbers.forEach(Lotto::validateLottoNum);
        validateDuplication(numbers);
    }

    private static void validateDuplication(List<Integer> numbers) {
        boolean[] visited = new boolean[END_NUMBER + 1];
        numbers.forEach((num) -> {
            if (visited[num]) {
                throw new IllegalArgumentException(LOTTO_NUMBER_IS_DUPLICATED.getMessage());
            }
            visited[num] = true;
        });
    }

    @Override
    public String toString() {
        List<Integer> sortedNumbers = new ArrayList<>(numbers);
        Collections.sort(sortedNumbers);
        return sortedNumbers.toString();
    }
}
