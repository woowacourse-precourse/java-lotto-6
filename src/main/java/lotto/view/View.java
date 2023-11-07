package lotto.view;

import lotto.domain.lotto.Lotto;
import lotto.dto.response.PrizeResponse;

import java.util.List;

public class View {

    private View() {

    }

    public static Integer readPurchaseAmount() {
        OutputView.printReadPurchaseAmountMessage();
        return InputView.readPurchaseAmount();
    }

    public static void printWinningLottosMessage(List<Lotto> winningLottos, int purchasedLottoCount) {
        OutputView.printLineBreak();
        OutputView.printPurchasedLottoCountMessage(purchasedLottoCount);
        OutputView.printWinningLottos(winningLottos);
    }

    public static List<Integer> readLottoNumbers() {
        OutputView.printLineBreak();
        OutputView.printReadLottoNumberMessage();
        return InputView.readLottoNumbers();
    }

    public static Integer readBonusNumber() {
        OutputView.printLineBreak();
        OutputView.printReadBonusNumberMessage();
        return InputView.readBonusNumber();
    }

    public static void printWinningStatusMessage(List<PrizeResponse> prizeResponses, double profitRate) {
        OutputView.printLineBreak();
        OutputView.printWinningStatusMessage(prizeResponses, profitRate);
    }
}
