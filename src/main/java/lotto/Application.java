package lotto;

import lotto.domain.Buyer;
import lotto.domain.Lotto;
import lotto.domain.Winning;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Buyer buyer = InputView.payForLottery();
        Lotto lotto = InputView.inputWinningNum();
        Winning winning = InputView.inputBonusNum(lotto);
        OutputView outputView = new OutputView();
        outputView.getStatistic(buyer, winning);
        outputView.earningRatio(buyer);
    }
}
