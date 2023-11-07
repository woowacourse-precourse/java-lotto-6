package lotto.data;

import static lotto.message.ErrorMessage.LOTTO_IS_NOT_SIX_DIGITS;
import static lotto.message.ErrorMessage.LOTTO_NUMBER_IS_DUPLICATED;
import static lotto.message.ErrorMessage.LOTTO_NUMBER_IS_NOT_IN_RANGE;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

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
        if (num < 1) {
            throw new IllegalArgumentException(LOTTO_NUMBER_IS_NOT_IN_RANGE.getMessage());
        }
        if (num > 45) {
            throw new IllegalArgumentException(LOTTO_NUMBER_IS_NOT_IN_RANGE.getMessage());
        }
    }

    private static void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(LOTTO_IS_NOT_SIX_DIGITS.getMessage());
        }
        numbers.forEach(Lotto::validateLottoNum);
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

    @Override
    public String toString() {
        List<Integer> sortedNumbers = new ArrayList<>(numbers);
        Collections.sort(sortedNumbers);
        return sortedNumbers.toString();
    }
}
