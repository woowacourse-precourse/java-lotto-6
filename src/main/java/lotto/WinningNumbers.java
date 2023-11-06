package lotto;

import java.util.List;

import static exception.ExceptionMessage.BONUS_DUPLICATE_WINNING_NUMBERS;
import static lotto.Lotto.LOTTO_SIZE;

public class WinningNumbers {

    private List<Integer> win;

    public WinningNumbers(List<Integer> win){
        this.win = win;
    }

}
