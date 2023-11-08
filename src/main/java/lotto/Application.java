package lotto;

import static lotto.utils.PrintingMessages.GET_BONUS_NUMBER_MESSAGE;
import static lotto.utils.PrintingMessages.GET_PURCHASE_AMOUNT_MESSAGE;
import static lotto.utils.PrintingMessages.GET_WINNING_NUMBERS_MESSAGE;

import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.PrizeReception;
import lotto.domain.PrizeChecker;
import lotto.domain.wrapper.PurchaseAmount;
import lotto.domain.Prize;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {
    public static void main(String[] args) {
        // 로또 게임에 필요한 값들을 콘솔로부터 입력받는다.
        PurchaseAmount purchaseAmount = getValidPurchaseAmount();
        Lottos lottos = new Lottos(purchaseAmount);
        OutputView.printLottos(lottos.getLottoCount(), lottos.toString());
        Lotto winningLotto = getValidWinningLotto();
        int bonusNumber = getValidBonusNumber(winningLotto);
        // 로또 게임을 진행한다.
        PrizeChecker prizeChecker = new PrizeChecker(winningLotto, bonusNumber);
        Map<Prize, Integer> lottosResult = lottos.getLottosResult(prizeChecker);
        PrizeReception prizeReception = new PrizeReception(lottosResult);
        double profitRate = prizeReception.getProfitRate(purchaseAmount);
        // 로또 게임 결과를 출력한다.
        OutputView.printPrizeResults(lottosResult);
        OutputView.printPrizeProfit(profitRate);
    }

    private static PurchaseAmount getValidPurchaseAmount() {
        boolean isCorrectInput = false;
        PurchaseAmount purchaseAmount = null;
        while (!isCorrectInput) {
            try {
                OutputView.printMessage(GET_PURCHASE_AMOUNT_MESSAGE);
                purchaseAmount = new PurchaseAmount(InputView.getNumber());
                isCorrectInput = true;
            } catch (IllegalArgumentException illegalArgumentException) {
                OutputView.printMessage(illegalArgumentException.getMessage());
            }
        }
        return purchaseAmount;
    }

    private static Lotto getValidWinningLotto() {
        boolean isCorrectInput = false;
        Lotto winningLotto = null;
        while (!isCorrectInput) {
            try {
                OutputView.printMessage(GET_WINNING_NUMBERS_MESSAGE);
                winningLotto = new Lotto(InputView.getNumbers());
                isCorrectInput = true;
            } catch (IllegalArgumentException illegalArgumentException) {
                OutputView.printMessage(illegalArgumentException.getMessage());
            }
        }
        return winningLotto;
    }

    private static int getValidBonusNumber(Lotto winningLotto) {
        boolean isCorrectInput = false;
        int bonusNumber = 0;
        while (!isCorrectInput) {
            try {
                OutputView.printMessage(GET_BONUS_NUMBER_MESSAGE);
                bonusNumber = InputView.getNumber();
                new PrizeChecker(winningLotto, bonusNumber);
                isCorrectInput = true;
            } catch (IllegalArgumentException illegalArgumentException) {
                OutputView.printMessage(illegalArgumentException.getMessage());
            }
        }
        return bonusNumber;
    }
}
