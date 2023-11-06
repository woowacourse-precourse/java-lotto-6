package lotto.domain;

import static lotto.constant.LottoNumber.LOTTO_NUMBER_LENGTH;

import java.util.List;
import lotto.util.Util;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = Util.sortListAscending(numbers);
    }

    private void validate(List<Integer> numbers) {
        checkLottoLength(numbers);
        checkDuplicateNumber(numbers);
    }

    private void checkLottoLength(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBER_LENGTH.getNumber()) {
            throw new IllegalArgumentException();
        }
    }

    private void checkDuplicateNumber(List<Integer> numbers) {
        if (numbers.stream().distinct().count() != LOTTO_NUMBER_LENGTH.getNumber()) {
            throw new IllegalArgumentException();
        }
    }

    public int countMatchingNumbers(Lotto winningLotto) {
        return (int) numbers.stream()
                .filter(winningLotto::isContainWinningNumbers)
                .count();
    }

    private boolean isContainWinningNumbers(int lottoNumber) {
        return numbers.contains(lottoNumber);
    }

    public boolean isContainBonusNumber(int bonusNumber) {
        return numbers.contains(bonusNumber);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
