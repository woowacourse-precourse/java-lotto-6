package lotto.view.output;

import static lotto.constant.PrintOutMessage.COUNT;
import static lotto.constant.PrintOutMessage.DIVISION_LINE;
import static lotto.constant.PrintOutMessage.EMPTY_LINE;
import static lotto.constant.PrintOutMessage.PLZ_INPUT_BONUS_NUMBER;
import static lotto.constant.PrintOutMessage.PLZ_INPUT_PURCHASE_PRICE;
import static lotto.constant.PrintOutMessage.PLZ_INPUT_WINNER_NUMBER;
import static lotto.constant.PrintOutMessage.STATISTIC;
import static lotto.constant.PrintOutMessage.calculateEarningRate;

import java.util.Map;
import lotto.constant.PrintOutMessage;
import lotto.constant.Rank;
import lotto.model.Lotto;
import lotto.model.LottoNumbers;
import lotto.model.PurchasePrice;

public class OutputView {
    public void printPurchasePriceMessage() {
        System.out.println(PLZ_INPUT_PURCHASE_PRICE.message);
    }

    public void printLottoCount(int lottoCount, LottoNumbers lottoNumbers) {
        System.out.println(PrintOutMessage.printLottoCount(lottoCount));
        for (Lotto number : lottoNumbers.getNumbers()) {
            System.out.println(number.getNumbers());
        }
        System.out.println(EMPTY_LINE.message);
    }

    public void printWinnerNumberMessage() {
        System.out.println(PLZ_INPUT_WINNER_NUMBER.message);
    }

    public void printBonusNumberMessage() {
        System.out.println(PLZ_INPUT_BONUS_NUMBER.message);
    }

    public void printStatistic(Map<Rank, Integer> matchingResult) {
        System.out.println(STATISTIC.message);
        System.out.println(DIVISION_LINE.message);

        for (Map.Entry<Rank, Integer> entry : matchingResult.entrySet()) {
            Rank rank = entry.getKey();
            int lottoCount = entry.getValue();

            if (!rank.equals(Rank.NO_MATCH)) {
                System.out.println(rank.message + lottoCount + COUNT.message);
            }
        }
    }


    public void printEarningRate(long totalPrize, PurchasePrice purchasePrice) {
        System.out.println(calculateEarningRate(totalPrize, purchasePrice));
    }

    public void printErrorMessage(final String message) {
        System.out.print(message + EMPTY_LINE.message);
    }
}
