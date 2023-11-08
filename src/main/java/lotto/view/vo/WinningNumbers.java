package lotto.view.vo;

import java.util.List;

public record WinningNumbers (List<Integer> numbers) {

    public static WinningNumbers of(List<Integer> winningNumbers) {
        return new WinningNumbers(winningNumbers);
    }

    public boolean hasDuplicate(int number) {
        return this.numbers.contains(number);
    }

}
