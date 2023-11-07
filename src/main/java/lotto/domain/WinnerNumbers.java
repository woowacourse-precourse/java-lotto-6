package lotto.domain;

import lotto.constant.ErrorMessage;

import java.util.List;

public class WinnerNumbers {

    private final Lotto numbers;

    public WinnerNumbers(List<Integer> numbers) {
        this.numbers = new Lotto(numbers);
    }

    public Boolean isMatched(Integer findNumber) {
        for(Integer number : numbers.getNumbers()) {
            if(findNumber.equals(number)) return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }
}
