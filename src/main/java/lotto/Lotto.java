package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static lotto.LottoValidator.validateLotteryLength;
import static lotto.LottoValidator.validateUniqueNumber;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        List<Integer> sortedNumbers = new ArrayList<>(numbers);
        Collections.sort(sortedNumbers);
        this.numbers = sortedNumbers;
    }

    private void validate(List<Integer> numbers) {
        validateLotteryLength(numbers);
        validateUniqueNumber(numbers);
    }

    public Prize check(WinningNumbers winningNumbers) {
        int count = 0;

        for (int number : winningNumbers.getNumbers()) {
            if (numbers.contains(number)) {
                count++;
            }
        }

        return getPrize(count, winningNumbers.getBonus());
    }

    private Prize getPrize(int count, int bonusNumber) {
        if (count == Prize.First.getCount())
            return Prize.First;
        if (count == Prize.Second.getCount() && numbers.contains(bonusNumber))
            return Prize.Second;
        if (count == Prize.Third.getCount())
            return Prize.Third;
        if (count == Prize.Forth.getCount())
            return Prize.Forth;
        if (count == Prize.Fifth.getCount())
            return Prize.Fifth;
        return Prize.None;
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
