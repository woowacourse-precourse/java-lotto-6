package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import lotto.util.LottoVO;
import lotto.util.UiVO;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateDistinctNumbers(numbers);
        this.numbers = new ArrayList<>(numbers);
        Collections.sort(this.numbers);
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

    public void printMyLottoNumbers() {

        List<String> lottoNumberText = this.numbers.stream().map(String::valueOf).collect(Collectors.toList());
        String lottoNumbers = String.join(", ", lottoNumberText);
        System.out.println("[" + lottoNumbers + "]");
    }

    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(this.numbers);
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
