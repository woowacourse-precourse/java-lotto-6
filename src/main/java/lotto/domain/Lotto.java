package lotto.domain;

import static lotto.Exception.ExceptionMessage.*;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateLottoLength(numbers);
        validateDuplicationNumber(numbers);
        this.numbers = numbers;
    }

    public List<Integer> sortLottoNumber(){
        return numbers.stream().sorted().toList();
    }

    private void validateLottoLength(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    private void validateDuplicationNumber(List<Integer> numbers){
        if(new HashSet<>(numbers).size() != numbers.size()){
            throw new IllegalArgumentException(DUPLICATION_LOTTO_NUMBER.getExceptionMessage());
        }
    }
}
