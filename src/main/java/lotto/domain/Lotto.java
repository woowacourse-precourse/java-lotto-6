package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;
import lotto.exception.LottoSizeException;
import lotto.exception.SameNumberInLottoException;

public class Lotto {
    private final int YES = 1;
    private final int NO = 0;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateSameNumbers(numbers);
        if (numbers.size() != 6) {
            throw new LottoSizeException();
        }
    }

    public void validateSameNumbers(List<Integer> win) {
        if(win.size() != win.stream().distinct().count()){
            throw new SameNumberInLottoException();
        }
    }

    private List<Integer> sort() {
        return numbers.stream()
                .sorted()
                .collect(Collectors.toList());
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
