package lotto.controller;

import java.util.List;
import lotto.domain.Lotto;
import lotto.view.InputWinningNumberView;
import lotto.view.OutputView;

public class WinningLottoService {

    public Lotto craeteWinningLotto() {
        do {
            try {
                List<Integer> numbers = InputWinningNumberView.inputWinningNumber();
                return new Lotto(numbers);
            } catch (IllegalArgumentException e) {
                OutputView.printNewLine();
                OutputView.printMessage(e.getMessage());
            }
        } while (true);
    }


}
