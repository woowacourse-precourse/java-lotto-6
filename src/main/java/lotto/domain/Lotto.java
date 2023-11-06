package lotto.domain;

import java.util.HashSet;
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
    // TODO: 추가 기능 구현


    public int checkSameNum(List<Integer> userNum, int bonusNum) {
        HashSet<Integer> set = new HashSet<>(userNum);
        int cnt =0;
        for (Integer number : numbers) {
            if (set.contains(number)) {
                cnt ++;
            }
        }
        if (cnt == 5) {
            if(set.contains(bonusNum)) cnt+=2;
        }
        return cnt;
    }
}
