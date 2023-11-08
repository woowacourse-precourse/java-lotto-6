package lotto.domain;

import lotto.util.LottoGameUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateDuplicatedNumber(numbers);
        Collections.sort(new ArrayList<>(numbers));
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(LottoGameMessage.LOTTO_NUMBER_SIZE_ERROR);
        }
    }

    private void validateDuplicatedNumber(List<Integer> numbers) {
        if (numbers.stream()
                .distinct()
                .count() != numbers.size()) {
            throw new IllegalArgumentException(LottoGameMessage.DUPLICATED_NUMBER_ERROR);
        }
    }

    public void viewNumberStatus() {
        LottoGameUtil.viewNumberStatus(numbers);
    }

    public LottoScore compare(Lotto winningNumber, int bonusNumber) {
        int count = (int) numbers.stream()
                .filter(number -> winningNumber.numbers.contains(number))
                .count();
        return getLottoScore(bonusNumber, count);
    }

    private LottoScore getLottoScore(int bonusNumber, int count) {
        return LottoGameUtil.getResult(count, isContainsBonusNumber(bonusNumber));
    }

    private boolean isContainsBonusNumber(int bonusNumber) {
        boolean isContainsBonusNumber = numbers.contains(bonusNumber);
        return isContainsBonusNumber;
    }

}
