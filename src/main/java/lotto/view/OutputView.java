package lotto.view;

import lotto.domain.Lotto;
import lotto.message.Message;

import java.util.List;

public class OutputView {
    private static void print(String message) {
        System.out.println(message);
    }

    public static void askPurchasingPrice() {
        print(Message.ASK_PURCHASING_PRICE.getMessage());
    }

    public static void printPurchaseLottoQuantity(int purchasedLottoQuantity) {
        print(purchasedLottoQuantity + Message.QUANTITY_OF_LOTTO.getMessage());
    }

    public static void printPurchasedLottos(List<Lotto> purchasedLottosResult) {
        for (Lotto lotto: purchasedLottosResult) {
            List<Integer> lottoNumbers = lotto.getNumbers();
            List<String> modifiedLottoNumbers = lottoNumbers.stream().map(number -> number.toString()).toList();
            String.join(", ",modifiedLottoNumbers);
            print("["+modifiedLottoNumbers+"]");
        }
    }
}
