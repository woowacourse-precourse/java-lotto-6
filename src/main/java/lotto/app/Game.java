package lotto.app;

import static lotto.global.util.InputManager.inputBonusNumber;
import static lotto.global.util.InputManager.inputWinningNumber;

import lotto.domain.Lotto;
import lotto.domain.Round;

public class Game {

    /**
     * 로또 게임을 실행하는 메서드
     */
    public void run() {
        Round round = new Round();
        round.extractor(round.getTotalCnt());
        Lotto lotto = inputWinningNumber();
        round.judge(lotto, inputBonusNumber(lotto.getNumbers()));
        round.showResult();
    }
}
