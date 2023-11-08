package lotto.controller.inputCreator;

import java.util.List;
import lotto.domain.Lotto;
import lotto.view.InputWinningNumberView;

public class WinningLottoController implements ObjectCreator<Lotto, String> {
    @Override
    public Lotto createObjectByInput(String x) {
        List<Integer> numbers = InputWinningNumberView.inputWinningNumber();
        return new Lotto(numbers);
    }
}
