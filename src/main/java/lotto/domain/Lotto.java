package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;

import lotto.views.Exceptions;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateRange(numbers);
        validateDuplicate(numbers);

        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            Exceptions.exceptionNotNum6();
            throw new IllegalArgumentException();
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        if (!Objects.equals(numbers.size(), new HashSet<>(numbers).size())) {
            Exceptions.exceptionNotSameSet();
            throw new IllegalArgumentException();
        }
    }

    private void validateRange(List<Integer> numbers) {
        for (var i = 0; i < numbers.size(); i++) {
            if (numbers.get(i) < 1 || numbers.get(i) > 45) {
                Exceptions.exceptionNotRange();
                throw new IllegalArgumentException();
            }
        }
    }

    public boolean bonusValidateBool(int bonusNum) {
        try {
            bonusValidate(bonusNum);
            return false;
        } catch (IllegalArgumentException e) {
            return true;
        }
    }

    public void bonusValidate(int bonusNum) {
        if (numbers.contains(bonusNum)) {
            Exceptions.exceptionBonusNumInWinnerNum();
            throw new IllegalArgumentException();
        }
    }

    public void lottoResultSearch(List<List<Integer>> allLotto, int bonusNum) {
        LottoResult.countResult(allLotto, numbers, bonusNum);
    }
}
