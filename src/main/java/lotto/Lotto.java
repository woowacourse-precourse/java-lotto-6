package lotto;

import java.util.ArrayList;
import java.util.Comparator;
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
        List<Integer> copyNums = new ArrayList<>();

        // 중복 예외 처리
        if(!numbers.stream().allMatch(num-> !copyNums.contains(num) && copyNums.add(num))){
            throw new IllegalArgumentException();
        }
    }

    @Override
    public String toString(){
        this.numbers.sort(Comparator.naturalOrder());

        StringBuilder result = new StringBuilder("[");
        for (int i = 0; i < this.numbers.size(); i++) {
            result.append(this.numbers.get(i));
            if (i < this.numbers.size() - 1) {
                result.append(", ");
            }
        }
        result.append("]");

        return result.toString();
    }
    // TODO: 추가 기능 구현
}
