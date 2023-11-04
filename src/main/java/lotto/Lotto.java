package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Collections;
import java.util.List;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        sortNumbers(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현
    private void sortNumbers(List<Integer> numbers) {
        Collections.sort(numbers);
    }

    @Override
    public String toString() {
        return "[" + String.join(",", numbers
            .stream().map(Object::toString).toArray(String[]::new)) + "]";
    }

    public List<Integer> getNumbers(){
        return numbers;
    }
}
