package lotto.domain;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateDuplication(numbers);
        Collections.sort(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    private void validateDuplication(List<Integer> numbers){
        if(numbers.size()!=numbers.stream().distinct().count()){
            throw new IllegalArgumentException("[ERROR] 중복되는 숫자는 불가능합니다.");
        }
    }

    public List<Integer> getNumbers(){
        return Collections.unmodifiableList(numbers);
    }

    // TODO: 추가 기능 구현
}
