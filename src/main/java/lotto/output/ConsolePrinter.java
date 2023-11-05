package lotto.output;

import lotto.constant.Message;
import lotto.data.Lotto;
import lotto.data.LottoRepository;
import lotto.data.PurchaseAmount;

import java.util.ArrayList;
import java.util.List;

public class ConsolePrinter {

    public static void printPurchaseAmount() {
        System.out.println(Message.INPUT_PURCHASE_AMOUNT);
    }

    public static void printPurchasedLottoCount(PurchaseAmount purchaseAmount) {
        System.out.println();
        System.out.println(String.format(Message.PURCHASED_LOTTO_COUNT,purchaseAmount.getPurchasedLottoCount()));
    }

    public static void printLottoNumbers(LottoRepository lottoRepository) {
        for (Lotto lotto : lottoRepository.getLottos()) {
            List<Integer> numbers = new ArrayList<>(lotto.getNumbers());
            numbers.sort(null);
            System.out.println(numbers.toString());
        }

    }

    public static void printRequestWinningNumbers() {
        System.out.println();
        System.out.println(Message.INPUT_WINNING_NUMBERS);
    }
}
