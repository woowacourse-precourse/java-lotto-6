package lotto.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import lotto.exception.LottoException.LottoNumberDuplicateException;
import lotto.exception.LottoException.LottoSizeException;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        ArrayList<Integer> sortedNumbers = new ArrayList<>(numbers);
        Collections.sort(sortedNumbers);
        this.numbers = sortedNumbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new LottoSizeException();
        }
        if (numbers.stream().distinct().count() != 6) {
            throw new LottoNumberDuplicateException();
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        numbers.forEach(number -> {
            if (Objects.equals(number, numbers.get(numbers.size() - 1))) {
                sb.append(number).append("]");
                return;
            }
            sb.append(number).append(", ");
        });
        return sb.toString();
    }

    public boolean isContain(int bonusNumber) {
        return numbers.contains(bonusNumber);
    }

    public LottoResult calculateResult(WinningLotto winningLotto) {
        int count = (int) numbers.stream().filter(winningLotto::isContain).count();
        return LottoResult.calculate(count, winningLotto.isContainBonusNumber(numbers));
    }
}
