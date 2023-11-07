package lotto.view;

import lotto.domain.lotto.Lotto;

import java.util.List;

public class View {

    private View() {

    }

    public Integer readPurchaseAmount() {
        OutputView.printReadPurchaseAmountMessage();
        return InputView.readPurchaseAmount();
    }

    public void printWinningLottos(List<Lotto> winningLottos, int purchasedLottoCount) {
        OutputView.printLineBreak();
        OutputView.printPurchasedLottoCountMessage(purchasedLottoCount);
        OutputView.printWinningLottos(winningLottos);
        OutputView.printLineBreak();
    }
}
