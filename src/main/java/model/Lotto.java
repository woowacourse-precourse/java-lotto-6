package model;

import java.util.Comparator;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        sortLotto(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }
    @Override
    public String toString(){
        return String.format(numbers.toString());
    }
    void sortLotto(List<Integer> numbers){
        numbers.sort(Comparator.naturalOrder());
    }
    // TODO: 추가 기능 구현
}
