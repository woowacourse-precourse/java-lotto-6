package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.util.LottoVO;
import lotto.util.UiVO;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateDistinctNumbers(numbers);
        Collections.sort(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    private void validateDistinctNumbers(List<Integer> numbers) {

        Set<Integer> distinctNumbers = new HashSet<>(numbers);

        if (distinctNumbers.size() != LottoVO.getLottoNumberCount()) {
            throw new IllegalArgumentException(UiVO.getWinningNumberCountException());
        }
    }

    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }

    public int countSameNumbers(List<Integer> winningNumbers) {
        List<Integer> tmp = new ArrayList<>(this.numbers);
        tmp.retainAll(winningNumbers);
        return tmp.size();
    }

    public boolean containsBonusNumber(int bonusNumber) {
        return this.numbers.contains(bonusNumber);
    }
}
