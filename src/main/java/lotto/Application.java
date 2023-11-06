package lotto;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Lotto;
import lotto.view.InputMaker;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        LottoController lo = new LottoController();
        lo.insertCoin();
        lo.buyLotto();
        lo.setWinner();
        lo.setBonus();
        lo.resultLotto();
    }
}
