package lotto;

import java.util.List;
import lotto.fixeddata.ErrorText;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        Duplicate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ErrorText.ERROR + ErrorText.LOTTO_NUMBERS_IS_NOT_SIX);
        }
    }

    // TODO: 추가 기능 구현
    private static void Duplicate(List<Integer> numbers) {
        if (numbers.size() != numbers.stream().distinct().count()) {
            throw new IllegalArgumentException(ErrorText.ERROR + ErrorText.LOTTO_NUMBER_DUPLICATION_ERROR);
        }
    }

    public List<Integer> GetLotto() {
        return numbers;
    }

    public boolean containNumber(int number) {
        return numbers.contains(number);
    }

    public int countMatch(Lotto winningLotto) {
        return (int) numbers.stream().
                filter(winningLotto::containNumber).
                count();
    }
}
