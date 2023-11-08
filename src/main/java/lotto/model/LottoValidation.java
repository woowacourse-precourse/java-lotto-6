package lotto.model;

import java.util.HashSet;
import java.util.List;
import java.util.HashSet;
import java.util.Set;

public class LottoValidation implements LottoVaildationInterface{
    final String DUPLICATIONERROR = "[ERROR] 로또 번호는 중복될 수 없습니다.";
    final String LENGTHERROR = "[ERROR] 로또 번호의 크기는 6개여야 합니다.";
    final String NUMBERERROR = "[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.";
    final int LOTTOLENGHT = 6;
    final int MAXRANGE = 45;
    final int MINRANGE = 0;

    @Override
   public void lottoLengthError(List<Integer> numbers) throws IllegalArgumentException {
        if (numbers.size() != LOTTOLENGHT) {
            throw new IllegalArgumentException(LENGTHERROR);
        }
    }
    @Override
    public void lottoDuplictionError(List<Integer> numbers) throws IllegalArgumentException {
        Set<Integer> uniqeNumber = new HashSet<>(numbers);
        if (numbers.size() != uniqeNumber.size()) {
            throw new IllegalArgumentException(DUPLICATIONERROR);
        }
    }
    @Override
    public void lottoNumberError(List<Integer> numbers) throws IllegalArgumentException {
        numbers.stream()
                .filter((number) -> { return number < MINRANGE || number > MAXRANGE; })
                .findAny()
                .ifPresent( (number) -> { throw new IllegalArgumentException(NUMBERERROR); }
                );
    }





}
