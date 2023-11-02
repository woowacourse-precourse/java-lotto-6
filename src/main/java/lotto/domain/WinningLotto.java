package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class WinningLotto {

    private final List<Integer> winningNumbers;

    private WinningLotto(final List<Integer> winningNumbers) {
        this.winningNumbers = winningNumbers;
    }

    public static WinningLotto of(final List<String> numbersText) {
        List<Integer> numbers = new ArrayList<>();
        for (String text : numbersText) {
            int winningNumber = Integer.parseInt(text);
            numbers.add(winningNumber);
        }
        return new WinningLotto(numbers);
    }
}
