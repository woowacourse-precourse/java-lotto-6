package lotto;

import java.util.Arrays;
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
    public List<Integer> compare(List<Integer> winningNumbers, int bonusNumber) {
        int winCnt = 0, bonusCnt = 0;
        for(int n:numbers) {
            if(winningNumbers.contains(n)) {
                winCnt++;
            }
            if(bonusNumber == n) {
                bonusCnt++;
            }
        }
        return Arrays.asList(winCnt, bonusCnt);
    }
}
