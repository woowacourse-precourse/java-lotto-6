package lotto.model;

import java.util.HashSet;
import java.util.List;
import java.util.HashSet;
import java.util.Set;

public class LottoValidation implements LottoVaildationInterface{
    final String duplicationError = "[ERROR] 로또 번호는 중복될 수 없습니다.";
    final String lengthError = "[ERROR] 로또 번호의 크기는 6개여야 합니다.";
    final String numberError = "로또 번호는 1부터 45 사이의 숫자여야 합니다.";
    final int lottoLength = 6;

    @Override
   public void lottoLengthError(List<Integer> numbers) throws IllegalArgumentException {
        if (numbers.size() != lottoLength) {
            throw new IllegalArgumentException(lengthError);
        }
    }
    @Override
    public void lottoDuplictionError(List<Integer> numbers) throws IllegalArgumentException {
        Set<Integer> uniqeNumber = new HashSet<>(numbers);
        if (numbers.size() != uniqeNumber.size()) {
            throw new IllegalArgumentException(duplicationError);
        }
    }
    @Override
    public void lottoNumberError(List<Integer> numbers) throws IllegalArgumentException {
        numbers.stream()
                .filter((x) -> { return x < 0 || x > 45; })
                .findAny()
                .ifPresent( (x) -> { throw new IllegalArgumentException(numberError); }
                );
    }





}
