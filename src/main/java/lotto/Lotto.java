package lotto;

import lotto.code.PrizeCode;
import lotto.utils.PrintUtils;
import lotto.utils.ValidationUtils;

import java.util.List;

import static lotto.code.PrizeCode.*;

public class Lotto {
    private final List<Integer> numbers;
    private PrizeCode prizeCode;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
        print();
    }

    private void validate(List<Integer> numbers) {
        ValidationUtils.validate(numbers);
    }

    public void print() {
        PrintUtils.print(this.numbers.toString());
    }

    public void checkWinning(List<Integer> winningNumbers, int bonusNumber) {
        int count = (int) this.numbers.stream().filter(winningNumbers::contains).count();
        switch (count) {
            case 6:
                this.prizeCode = FIRST;
                break;
            case 5:
                if (numbers.contains(bonusNumber)) {
                    this.prizeCode = SECOND;
                } else {
                    this.prizeCode = THIRD;
                }
                break;
            case 4:
                this.prizeCode = FOURTH;
                break;
            case 3:
                this.prizeCode = FIFTH;
                break;
            default:
        }
    }

    public PrizeCode getPrizeCode() {
        return prizeCode;
    }
}
