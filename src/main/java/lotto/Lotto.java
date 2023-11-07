package lotto;

import lotto.constant.Constant;

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
        validLength(numbers);
        validNumber(numbers);
        checkDuplication(numbers);
    }

    private void validLength(List<Integer> numbers) {
        if (numbers.size() != 6){
            throw new IllegalArgumentException(
                    Constant.error + Constant.invaildLength);
        }
    }

    private void validNumber(List<Integer> numbers) {
        for (int n : numbers) {
            if (n < 1 || n > 45) throw new IllegalArgumentException(
                    Constant.error + Constant.invaildNumber);
        }
    }

    private void checkDuplication(List<Integer> numbers) {
        List<Integer> l = new ArrayList<>();

        for (int n : numbers) {
            if (l.contains(n)) throw new IllegalArgumentException(
                    Constant.error + Constant.Deduplication);
            l.add(n);
        }
    }

    // TODO: 추가 기능 구현
    void printNumbers() {
        List<Integer> temp = new ArrayList<>(this.numbers);

        Collections.sort(temp);
        System.out.println(temp);
    }

    int[] countWin(List<Integer> list, int bonus) {
        int[] count = {0, 0};

        for (int item : list){
            if (this.numbers.contains(item)) count[0]++;
        }
        if (this.numbers.contains(bonus)) count[1]++;
        return count;
    }
}
