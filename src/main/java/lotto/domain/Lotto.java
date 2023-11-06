package lotto.domain;

import java.util.stream.Collectors;
import lotto.exception.LottoNumbersException;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {

    private static final int MIN = 1;
    private static final int MAX = 45;
    private static final int SIZE = 6;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        numbers = sorted(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateNum(numbers);
        validateSize(numbers);
        validateDup(numbers);
        validateZero(numbers);
    }

    // TODO: 추가 기능 구현
    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != SIZE) {
            LottoNumbersException.lottoSizeException();
        }
    }

    private void validateNum(List<Integer> numbers) {
        for (int num : numbers) {
            compareNum(num);
        }
    }

    private void compareNum(int num) {
        if (num < MIN || num > MAX) {
            LottoNumbersException.lottoNumException();
        }
    }

    private void validateDup(List<Integer> numbers) {
        Set<Integer> forDup = new HashSet<>();
        for (int num : numbers) {
            forDup.add(num);
        }
        isDup(forDup);
    }

    private void isDup(Set<Integer> forDup) {
        if (forDup.size() != SIZE) {
            LottoNumbersException.lottoDupException();
        }
    }

    private void validateZero(List<Integer> numbers) {
        for (int num : numbers) {
            isZero(num);
        }
    }

    private void isZero(int num) {
        if (num == 0) {
            LottoNumbersException.lottoZeroException();
        }
    }

    public List<Integer> sorted(List<Integer> numbers) {
        return numbers.stream()
            .sorted()
            .collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return numbers.toString();
    }


}
