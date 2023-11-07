package lotto.model;

import lotto.view.ExceptionMessage;

import java.util.HashSet;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        isDuplicated(numbers);
        this.numbers = numbers;
    }

    public void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    public void isDuplicated(List<Integer> numbers){
        HashSet<Integer> set = new HashSet<>();
        set.addAll(numbers);
        if(set.size() != 6){
            String msg = ExceptionMessage.duplicatedNumberException();
            throw new IllegalArgumentException(msg);
        }
    }

    public List<Integer> getLottoNumbers(){
        return numbers;
    }

    // TODO: 추가 기능 구현
}
