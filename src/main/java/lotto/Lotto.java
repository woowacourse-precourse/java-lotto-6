package lotto;

import lotto.exception.DuplicateException;
import lotto.exception.NumberException;
import lotto.exception.RangeException;
import lotto.exception.SizeException;
import lotto.view.InputBuyLotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Lotto {
    private static final int MIN=1;
    private static final int MAX=45;
    private static final int SIZE = 6;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateDupliacte(numbers);
        validateSize(numbers);
        validateLottoNumber(numbers);
        numbers = sorted(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != SIZE) {
            throw new IllegalArgumentException();
        }
    }
    private void validateDupliacte(List<Integer> lottoNumbs) {
        Set<Integer> lottoNumb = new HashSet<>(lottoNumbs);
        if (lottoNumb.size() != SIZE) {
            throw new DuplicateException();
        }
    }
    private void validateSize(List<Integer> lottoNumbs) {
        if (lottoNumbs.size() != SIZE) {
            throw new SizeException();
        }
    }
    private void validateLottoNumber(List<Integer> lottoNumbs) {
        for (int number:lottoNumbs) {
            if (!checkNumberRange(number)) {
                throw new RangeException();
            }
        }
    }

    private void validateNumber(String money) {
        if (!Pattern.compile("\\d+").matcher(money).matches()) {
            throw new NumberException();
        }
    }
    private boolean checkNumberRange(int number) {
        if (number >= MIN && number <= MAX) {
            return true;
        }
        return false;
    }

    // TODO: 추가 기능 구현
    private List<Integer> sorted(List<Integer> numbers) {
        return numbers.stream().sorted().collect(Collectors.toList());
    }

    public List<Integer> returnNumbers() {
        return numbers;
    }
    public String toString() {
        return numbers.toString();
    }

}
