package lotto;

import lotto.domain.Lotto;
import lotto.view.InputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        InputView.payForLottery();
        Lotto lotto = InputView.inputWinningNum();
        InputView.inputBonusNum(lotto);
    }
}
