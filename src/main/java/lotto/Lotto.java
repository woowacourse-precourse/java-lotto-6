package lotto;

import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        Collections.sort(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6){
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현
    void printNumbers() {
        System.out.println(this.numbers);
    }

    int[] countWin(List<Integer> list, int bonus) {
        int[] count = {0, 0};

        for (int item : list){
            if (this.numbers.contains(item)) count[0]++;
        }
        if (this.numbers.contains(bonus))
            count[1]++;
        return count;
    }
}
