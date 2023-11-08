package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.PrizeMoney;
import lotto.message.Message;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {
    private static void print(String message) {
        System.out.println(message);
    }

    public static void askPurchasingPrice() {
        print(Message.ASK_PURCHASING_PRICE.getMessage());
    }

    public static void printPurchaseLottoQuantity(int purchasedLottoQuantity) {
        print("");
        print(purchasedLottoQuantity + Message.QUANTITY_OF_LOTTO.getMessage());
    }

    public static void printPurchasedLottos(List<Lotto> purchasedLottosResult) {
        for (Lotto lotto: purchasedLottosResult) {
            List<Integer> lottoNumbers = lotto.getNumbers();
            List<String> modifiedLottoNumbers = lottoNumbers.stream()
                    .sorted()
                    .map(number -> number.toString())
                    .toList();
            String.join(", ",modifiedLottoNumbers);
            print(modifiedLottoNumbers+"");
        }
    }

    public static void askWinningLottoNumbers() {
        print("");
        print(Message.ASK_WINNING_LOTTO_NUMBERS.getMessage());
    }

    public static void askBonusNumber() {
        print("");
        print(Message.ASK_BONUS_NUMBER.getMessage());
    }

    public static void printResultTitle() {
        print("");
        print(Message.RESULT_TITLE.getMessage());
        print(Message.RESULT_TITLE_DECORATION.getMessage());
    }

    public static void printMathCount(List<Integer> matchCount) {
        PrizeMoney[] prizeMonies = PrizeMoney.values();
        for (int i = 0; i < 5; i++) {
            print(prizeMonies[i].getMessage() + " - " + matchCount.get(i) + "개");
        }
    }

    public static void printProfitMargin(Double profit) {
        print(Message.PROFIT_MARGIN_MESSAGE_FRONT.getMessage() + profit + Message.PROFIT_MARGIN_MESSAGE_BACK.getMessage());
    }
}
