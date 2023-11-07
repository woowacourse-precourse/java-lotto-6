package lotto;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;
    private int winCount;

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
    public int compareWinNumbers(List<Integer> winNumbers) {
        for (Integer winNumber: winNumbers) {
            if(this.numbers.contains(winNumber)) this.winCount++;
        }
        return this.winCount;
    }

    public int compareWinBonusNumber(int winBonusNumber){
        if(this.numbers.contains(winBonusNumber)) {
            this.winCount++;
        }
        return this.winCount;
    }

    @Override
    public String toString() {
        return numbers.toString() ;
    }
}
