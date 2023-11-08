package lotto.model;

import lotto.constant.ConsoleMessage;
import lotto.constant.LottoNumberRange;
import lotto.utils.LottoGenerator;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto() {
        this(LottoGenerator.generateLottoNumbers());
    }

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ConsoleMessage.SIZE_MISMATCH_ERROR_MESSAGE);
        }

        for (Integer number : numbers) {
            if (number < LottoNumberRange.MIN.getValue() || number > LottoNumberRange.MAX.getValue()) {
                throw new IllegalArgumentException(ConsoleMessage.LOTTO_OUT_OF_RANGE_ERROR_MESSAGE);
            }
        }
    }

    // TODO: 추가 기능 구현

    public List<Integer> getNumbers() {
        return numbers;
    }

    private List<Integer> getAscendingNumbers() {
        return numbers.stream().sorted().toList();
    }

    public int matchingNumbersCount(Lotto otherLotto) {
        Set<Integer> copy = new HashSet<>(this.numbers);

        copy.retainAll(new HashSet<>(otherLotto.getNumbers()));

        return copy.size();
    }

    public boolean containsNumber(int bonusNumber) {
        return numbers.contains(bonusNumber);
    }

    @Override
    public String toString() {
        return String.join(", ", getAscendingNumbers().toString());
    }
}
