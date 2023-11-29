package domain;

import util.exception.DuplicateException;
import util.exception.SizeOverException;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static util.message.ExceptionMessage.DUPLICATE_MESSAGE;
import static util.message.ExceptionMessage.SIZE_OVER_MESSAGE;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        sort(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers(){
        return numbers;
    }

    private void validate(List<Integer> numbers) {
        validateSize(numbers);
        validateDuplicate(numbers);
    }

    private void validateSize(List<Integer> numbers){
        if (numbers.size() != 6) {
            throw new SizeOverException(String.format(SIZE_OVER_MESSAGE.getValue(), "로또"));
        }
    }

    private void validateDuplicate(List<Integer> numbers){
        Set<Integer> lottos = new HashSet<>(numbers);
        if(numbers.size() != lottos.size()){
            throw new DuplicateException(String.format(DUPLICATE_MESSAGE.getValue()));
        }
    }

    private void sort(List<Integer> numbers){
        Collections.sort(numbers);
    }
}
