package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {

    private static final int LOTTO_SIZE = 6;
    private static final int MAX_NUMBER = 45;
    private static final int MIN_NUMBER = 1;

    private static final String LOTTO_SIZE_ERROR_MESSAGE = "로또 번호는 6개의 숫자로 이루어져야 합니다.";
    private static final String LOTTO_RANGE_ERROR_MESSAGE = "로또 번호의 숫자 범위는 1~45까지 입니다.";
    private static final String LOTTO_NUMBER_DUPLICATE_ERROR_MESSAGE = "로또 번호는 중복되지 않아야 합니다.";


    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = ascendingSort(numbers);
    }

    public int compareWinningLottoNumbers(List<Integer> winningNumbers) {
        int matchNumber = 0;

        for (Integer playerNumber : numbers) {
            if (winningNumbers.contains(playerNumber))
                matchNumber++;
        }
        return matchNumber;
    }

    public boolean isCorrectBonusNumber(int bonusNumber) {
        return numbers.contains(bonusNumber);
    }

    private void validate(List<Integer> numbers) {
        validateNumbersSize(numbers);
        validateNumberInRange(numbers);
        validateDuplicate(numbers);
    }

    private void validateNumbersSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException(LOTTO_SIZE_ERROR_MESSAGE);
        }
    }

    private void validateNumberInRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number > MAX_NUMBER || number < MIN_NUMBER)
                throw new IllegalArgumentException(LOTTO_RANGE_ERROR_MESSAGE);
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        List<Integer> distinctNumbers = numbers.stream().distinct().toList();
        if (distinctNumbers.size() != LOTTO_SIZE)
            throw new IllegalArgumentException(LOTTO_NUMBER_DUPLICATE_ERROR_MESSAGE);
    }

    private List<Integer> ascendingSort(List<Integer> numbers) {
        List<Integer> sortedNumbers = new ArrayList<>(numbers);
        Collections.sort(sortedNumbers);
        return sortedNumbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
