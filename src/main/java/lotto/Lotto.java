package lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static constant.LottoValue.*;
import static exception.ExceptionMessage.*;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateSize(numbers);
        validateRange(numbers);
        validateDuplicate(numbers);
    }

    // TODO: 추가 기능 구현
    public void printLotto(){
        System.out.print("[");
        for (int i = 0; i < LOTTO_SIZE.value(); i++) {
            System.out.print(numbers.get(i));
            if(i!=LOTTO_SIZE.value()-1) System.out.print(", ");
        }
        System.out.println("]");
    }
    public boolean containSame(Integer i){
        if(numbers.contains(i)) {
            return true;
        }
        return false;
    }


    public int match(Lotto winningLotto){
        List<Integer> winningNumbers = new ArrayList<>(winningLotto.getList());
        return numbers.stream()
                .filter(o -> winningNumbers.stream().anyMatch(Predicate.isEqual(o)))
                .toList().size();
    }

    public List<Integer> getList(){
        return numbers;
    }

    private static void validateSize(List<Integer> numbers) {
        if(numbers.size() != LOTTO_SIZE.value()){
            throw new IllegalArgumentException(LOTTO_NUMBERS_SIZE.message());
        }
    }

    private static void validateRange(List<Integer> numbers) {
        for (int i = 0; i < LOTTO_SIZE.value(); i++) {
            Integer num = numbers.get(i);
            if (num < LOTTO_MINIMUM_NUMBER.value() || num > LOTTO_MAXIMUM_NUMBER.value()){
                throw new IllegalArgumentException(LOTTO_NUMBERS_RANGE.message());
            }
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        if(numbers.size() != numbers.stream().distinct().count()){
            throw new IllegalArgumentException(LOTTO_NUMBERS_DUPLICATE.message());
        }
    }

}
