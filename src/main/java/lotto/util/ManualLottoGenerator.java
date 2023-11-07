package lotto.util;

import lotto.model.Lotto;
import lotto.view.Input;
import lotto.view.Output;

public class ManualLottoGenerator implements LottoGenerator {
    @Override
    public Lotto lottoGenerator() {
        try {
            return new Lotto(Input.inputWinningNumbersGuide());
        } catch (IllegalArgumentException e) {
            Output.print(e.getMessage());
            return lottoGenerator();
        }
    }
}