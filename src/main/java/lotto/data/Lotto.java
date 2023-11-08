package lotto.data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    public void print(){
        List<String> printNumbers = new ArrayList<>();
        Collections.sort(numbers);

        for (Integer number : numbers) {
            printNumbers.add(number.toString());
        }

        System.out.println("[" + String.join(", ", printNumbers) + "]");
    }

    // TODO: 추가 기능 구현
}
