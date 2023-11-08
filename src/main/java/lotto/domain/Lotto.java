package lotto.domain;

import java.util.Collections;
import java.util.List;
import lotto.view.ExceptionMessage;

public class Lotto {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateDuplicate(numbers);
        validateRange(numbers);
        Collections.sort(numbers);

        this.numbers = numbers;
    }

    public List<Integer> getLottoNumbers() {
        return numbers;
    }

    public int countMatch(Lotto winningLotto) {
        return (int) numbers.stream()
                .filter(winningLotto::containNumber)
                .count();
    }

    public boolean containNumber(int number) {
        return numbers.contains(number);
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            ExceptionMessage.sizeException();
            throw new IllegalArgumentException();
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        long duplicateSize = numbers.stream()
                .distinct()
                .count();
        if (numbers.size() != duplicateSize) {
            ExceptionMessage.duplicateException();
            throw new IllegalArgumentException();
        }
    }

    private void validateRange(List<Integer> numbers) {
        for (int i = 0; i < numbers.size(); i++) {
            if (numbers.get(i) < MIN_NUMBER || numbers.get(i) > MAX_NUMBER) {
                ExceptionMessage.rangeException();
                throw new IllegalArgumentException();
            }
        }
    }
    public static void validateBonusNumber(List<Integer> numbers, int bonusNumber){
        if(numbers.contains(bonusNumber)){
            ExceptionMessage.duplicateException();
            throw new IllegalArgumentException();
        }
    }
}
