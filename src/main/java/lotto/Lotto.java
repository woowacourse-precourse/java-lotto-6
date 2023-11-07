package lotto;

import lotto.code.PrizeType;
import lotto.dto.WinningLottoNumberDto;
import lotto.utils.PrintUtils;
import lotto.utils.ValidationUtils;

import java.util.List;

import static lotto.code.PrizeType.*;

public class Lotto {
    private final List<Integer> numbers;

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

    public PrizeType checkWinning(WinningLottoNumberDto winningLottoNumber) {
        List<Integer> winningNumbers = winningLottoNumber.getWinnerNumbers();
        PrizeType prize = null;
        int count = (int) this.numbers.stream().filter(winningNumbers::contains).count();
        switch (count) {
            case 6:
                prize = FIRST;
                break;
            case 5:
                if (numbers.contains(winningLottoNumber.getBonusNumber())) {
                    prize = SECOND;
                } else {
                    prize = THIRD;
                }
                break;
            case 4:
                prize = FOURTH;
                break;
            case 3:
                prize = FIFTH;
                break;
            default:
        }
        return prize;
    }
}
