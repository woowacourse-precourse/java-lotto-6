package lotto.output;

import lotto.constant.Message;
import lotto.constant.Rank;
import lotto.data.Lotto;
import lotto.data.LottoRepository;
import lotto.data.LottoResult;
import lotto.data.PurchaseAmount;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ConsolePrinter {

    public static void printPurchaseAmount() {
        System.out.println(Message.INPUT_PURCHASE_AMOUNT);
    }

    public static void printPurchasedLottoCount(PurchaseAmount purchaseAmount) {
        System.out.println();
        System.out.println(String.format(Message.PURCHASED_LOTTO_COUNT, purchaseAmount.getPurchasedLottoCount()));
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

    public static void printRequestBonusNumber() {
        System.out.println();
        System.out.println(Message.INPUT_BONUS_NUMBER);
    }

    public static void printLottoResult(LottoResult lottoResult) {
        Map<Rank, Integer> result = lottoResult.get();
        System.out.println();
        System.out.println(Message.WINNING_STATISTICS);
        System.out.println(String.format(Rank.FIFTH.getMessage(), result.get(Rank.FIFTH)));
        System.out.println(String.format(Rank.FOURTH.getMessage(), result.get(Rank.FOURTH)));
        System.out.println(String.format(Rank.THIRD.getMessage(), result.get(Rank.THIRD)));
        System.out.println(String.format(Rank.SECOND.getMessage(), result.get(Rank.SECOND)));
        System.out.println(String.format(Rank.FIRST.getMessage(), result.get(Rank.FIRST)));

    }

    public static void printRateOfReturn(double rateOfReturn) {
        System.out.println(String.format(Message.RATE_OF_RETURN, rateOfReturn));
    }
}
