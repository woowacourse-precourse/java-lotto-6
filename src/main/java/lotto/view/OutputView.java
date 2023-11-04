package lotto.view;

import java.util.List;
import lotto.DTO.LottoDTO;
import lotto.constants.Messages;
import lotto.constants.Values;

public class OutputView {

    public static void printPurchaseAmountPrompt() {
        System.out.println(Messages.PROMPT_PURCHASE_AMOUNT);
    }

    public static void printWinningNumbersPrompt() {
        System.out.println(Messages.PROMPT_WINNING_NUMBERS);
    }

    public static void printBonusNumberPrompt() {
        System.out.println(Messages.PROMPT_BONUS_NUMBER);
    }

    public static void printPurchaseLottos(List<LottoDTO> purchasedLottosDTO) {
        System.out.println(purchasedLottosDTO.size() + Messages.PURCHASE_MESSAGE);
        purchasedLottosDTO.forEach(lottoDTO -> {
            String numbers = String.join(Values.LOTTO_NUMBER_SEPARATOR, lottoDTO.numbers());
            System.out.println(String.format(Messages.LOTTO_NUMBERS_MESSAGE, numbers));
        });
    }

    public static void printResult(String winningResult, String profitPercentage) {
        System.out.println(winningResult);
        System.out.println(String.format(Messages.TOTAL_PROFIT_MESSAGE, profitPercentage));
    }

    public static void printErrorMessage(String errorMessage) {
        System.out.println(errorMessage);
    }
}
