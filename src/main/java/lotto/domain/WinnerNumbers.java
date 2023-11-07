package lotto.domain;

import java.util.List;

public class WinnerNumbers {

    private final Lotto numbers;

    public WinnerNumbers(List<Integer> numbers) {
        this.numbers = new Lotto(numbers);
    }

}
