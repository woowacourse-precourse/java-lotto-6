package lotto.Domain;

import lotto.Exception.DuplicateLottoNumberException;
import lotto.Exception.InvaildSizeLottoNumberException;
import lotto.Exception.InvalidRangeLottoNumberException;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

public class Lotto {

    private  static  final int MIN_RANGE =1;
    private  static final int MAX_RANGE =1;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        numbers = sorted(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateSize(numbers);
        validateDuplicate(numbers);
        validaterange(numbers);
    }
    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new InvaildSizeLottoNumberException();
        }
    }


    private void validaterange(List<Integer> numbers){
        for(int number :numbers){
            if(number<MIN_RANGE || number>MAX_RANGE){
                throw new InvalidRangeLottoNumberException();
            }

        }
    }

    private void validateDuplicate(List<Integer> numbers){
        Set<Integer> noDuplicateNumbers = new HashSet<>(numbers);
        if(noDuplicateNumbers.size() != 6){
            throw new DuplicateLottoNumberException();
        }
    }
    public List<Integer> sorted (List<Integer> numbers) {
         return numbers.stream().sorted().collect(Collectors.toList());
    }
}
