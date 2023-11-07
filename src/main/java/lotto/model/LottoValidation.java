package lotto.model;

import java.util.HashSet;
import java.util.List;
import java.util.HashSet;
import java.util.Set;

public class LottoValidation {
    static final String duplicationError = "[ERROR] 로또 번호는 중복될 수 없습니다.";
    static final String lengthError = "[ERROR] 로또 번호의 크기는 6개여야 합니다.";
    static final String numberError = "로또 번호는 1부터 45 사이의 숫자여야 합니다.";
    static final int lottoLength = 6;

    private static void lottoLengthError(List<Integer> numbers) throws IllegalArgumentException {
        if (numbers.size() != lottoLength) {
            throw new IllegalArgumentException(lengthError);
        }
    }

    private static void lottoDuplictionError(List<Integer> numbers) throws IllegalArgumentException {
        Set<Integer> uniqeNumber = new HashSet<>(numbers);
        if (numbers.size() != uniqeNumber.size()) {
            throw new IllegalArgumentException(duplicationError);
        }
    }

    private static void lottoNumberError(List<Integer> numbers) throws IllegalArgumentException {
        numbers.stream()
                .filter((x) -> { return x < 0 || x > 45; })
                .findAny()
                .ifPresent( (x) -> { throw new IllegalArgumentException(numberError); }
                );
    }

    public static void lottoValidation(List<Integer> numbers) throws IllegalArgumentException {
        lottoDuplictionError(numbers);
        lottoNumberError(numbers);
        lottoLengthError(numbers);
    }









}
