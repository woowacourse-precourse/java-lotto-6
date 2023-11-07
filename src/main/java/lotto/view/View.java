package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.lotto.Lotto;
import lotto.util.InputUtil;
import lotto.view.validator.InputValidator;

import java.util.List;

public class View {

    private View() {

    }

    public static Integer readPurchaseAmount() {
        OutputView.printReadPurchaseAmountMessage();
        return InputView.readPurchaseAmount();
    }

    public static void printWinningLottos(List<Lotto> winningLottos, int purchasedLottoCount) {
        OutputView.printLineBreak();
        OutputView.printPurchasedLottoCountMessage(purchasedLottoCount);
        OutputView.printWinningLottos(winningLottos);
        OutputView.printLineBreak();
    }

    public static List<Integer> readLottoNumbers() {
        OutputView.printReadLottoNumberMessage();
        return InputView.readLottoNumbers();
    }
}
