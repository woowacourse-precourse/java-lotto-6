package lotto.Model;

import lotto.View.ExceptionMessages;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {

    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateIsNumberInRange(numbers);
        validateIsNumberDuplicate(numbers);
        validateEachLottoNumber(numbers);

        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            ExceptionMessages.lottoNumberCountError();
            throw new IllegalArgumentException();
        }
    }

    public boolean contains(int number) {
        return numbers.contains(number);
    }

    public List<Integer> getLottoNumbers() {
        return numbers;
    }

    public int countMatchNumber(Lotto winningLotto) {
        return (int) numbers.stream().
                filter(winningLotto::contains).
                count();
    }

    public static void validateIsNumberInRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number < MIN_LOTTO_NUMBER || number > MAX_LOTTO_NUMBER) {
                ExceptionMessages.lottoNumberRangeError();
                throw new IllegalArgumentException();
            }
        }
    }

    public static void validateIsNumberDuplicate(List<Integer> numbers) {
        Set<Integer> existingNumbers = new HashSet<>();

        for (Integer number : numbers) {
            if (existingNumbers.contains(number)) {
                ExceptionMessages.lottoNumberDuplicateError();
                throw new IllegalArgumentException();
            }
            existingNumbers.add(number);
        }
    }

    public static void validateEachLottoNumber(List<Integer> numbers) {
        for (Integer number : numbers) {
            try {
                Integer.parseInt(number.toString());
            } catch (NumberFormatException e) {
                ExceptionMessages.lottoNumberTypeError();
                throw new IllegalArgumentException();
            }
        }
    }

    public static void validateBonusNumberDuplicate(List<Integer> numbers, int bonusNumber) {
        if (numbers.contains(bonusNumber)) {
            ExceptionMessages.bonusNumberDuplicateError();
            throw new IllegalArgumentException();
        }
    }
}
