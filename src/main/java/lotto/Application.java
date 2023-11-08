package lotto;


import lotto.controller.*;
import lotto.domain.LottoGame;
import lotto.domain.WinningChecker;
import lotto.vo.BonusNumber;
import lotto.vo.Lotto;
import lotto.vo.WinningNumber;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        LottoGame game = new LottoGame();
        game.start();
    }
}
