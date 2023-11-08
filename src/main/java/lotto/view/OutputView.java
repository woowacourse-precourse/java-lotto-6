package lotto.view;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.constants.SystemMessage;
import lotto.domain.Lotto;
import lotto.domain.LottoPrize;
import lotto.domain.Lottos;

public class OutputView {
    public static final int NO_PRIZE_NUMBER = 2;

    public void printInputPurchaseAmount() {
        System.out.println(SystemMessage.INPUT_PURCHASE_AMOUNT.getMessage());
    }

    public void printLottos(Lottos lottos) {
        System.out.println();
        printNumberOfLotto(lottos.getLottos().size());
        printLottoNumber(lottos.getLottos());
    }

    private void printNumberOfLotto(int numberOfLotto) {
        System.out.println(numberOfLotto + SystemMessage.PRINT_NUMBER_OF_PURCHASED_LOTTO.getMessage());
    }

    private void printLottoNumber(List<Lotto> lottos) {
        StringBuilder sb = new StringBuilder();
        for (Lotto lotto : lottos) {
            Collections.sort(lotto.getNumbers());
            sb.append(lotto).append("\n");
        }
        System.out.println(sb);
    }

    public void printInputWinningNumbers() {
        System.out.println(SystemMessage.INPUT_WINNING_NUMBERS.getMessage());
    }

    public void printInputBonusNumber() {
        System.out.println(SystemMessage.INPUT_BONUS_NUMBER.getMessage());
    }

    public void printErrorMessage(String errorMessage) {
        System.out.println(errorMessage);
    }

    public void printPrizeResult(HashMap<LottoPrize, Integer> prizeResult) {
        printPrizeResultMessage();
        printPrizeResultDetail(prizeResult);
    }

    private static void printPrizeResultDetail(HashMap<LottoPrize, Integer> prizeResult) {
        StringBuilder sb = new StringBuilder();
        for (LottoPrize lottoPrize : prizeResult.keySet()) {
            if (lottoPrize.getMatchNumbers() <= NO_PRIZE_NUMBER) {
                continue;
            }
            String result = lottoPrize.getResultMessage(prizeResult.get(lottoPrize));
            sb.append(result).append("\n");
        }
        System.out.print(sb);
    }

    private static void printPrizeResultMessage() {
        System.out.println(SystemMessage.PRINT_WINNING_RESULT.getMessage());
    }

    public void printRateOfReturn(String rateOfReturn) {
        System.out.printf(SystemMessage.PRINT_RATE_OF_RETURN.getMessage(), rateOfReturn);
    }
}
