package lotto.domain;

import java.util.Collections;
import java.util.List;
import lotto.exception.LottoSizeException;

public class Lotto {
    private final int YES = 1;
    private final int NO = 0;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new LottoSizeException();
        }
    }

    private List<Integer> sort() {
        Collections.sort(numbers);

        return numbers;
    }

    public List<Integer> getNumbers(){
        return sort();
    }

    public int sameNumberCount (WinningLotto win) {
        int sameNumberCount = 0;
        for (Integer number : win.getWin().getNumbers()) {
            sameNumberCount += isContain(number);
        }
        return sameNumberCount;
    }

    public int isContain(Integer number) {
        if(numbers.contains(number)) {
            return YES;
        }
        return NO;
    }
}
