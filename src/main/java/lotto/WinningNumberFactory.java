package lotto;

import lotto.util.Validator;
import lotto.view.InputView;

import java.util.List;

public class WinningNumberFactory {
    public static WinningNumber getWinningNumber(){
        List<Integer> numbers = InputView.readCommaSeperatedInt();
        int bonusNumber = InputView.readNatural();
        return new WinningNumber(numbers, bonusNumber);
    }
}
