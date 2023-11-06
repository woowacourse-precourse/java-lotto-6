package lotto.app;

import static lotto.global.util.InputManager.inputBonusNumber;
import static lotto.global.util.InputManager.inputWinningNumber;

import lotto.domain.Lotto;
import lotto.domain.Round;

public class Game {

    public void start() {
        Round round = new Round();
        round.extractor(round.getTotalCnt());
        Lotto lotto = new Lotto(inputWinningNumber());
        round.judge(lotto, inputBonusNumber(lotto.getNumbers()));
        round.showResult();
    }
}
