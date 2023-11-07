package lotto;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static lotto.LottoParser.numberToText;
import static lotto.LottoPrizeConstants.THREE_MATCH_PRIZE_MONEY;
import static lotto.LottoPrizeConstants.FOUR_MATCH_PRIZE_MONEY;
import static lotto.LottoPrizeConstants.FIVE_MATCH_PRIZE_MONEY;
import static lotto.LottoPrizeConstants.BONUS_PRIZE_MONEY;
import static lotto.LottoPrizeConstants.SIX_MATCH_PRIZE_MONEY;
import static lotto.LottoViewConstantMessages.BONUS_MATCH_MESSAGE;
import static lotto.LottoViewConstantMessages.BONUS_NUMBER_REQUEST_MESSAGE;
import static lotto.LottoViewConstantMessages.FIVE_MATCH_MESSAGE;
import static lotto.LottoViewConstantMessages.FOUR_MATCH_MESSAGE;
import static lotto.LottoViewConstantMessages.INCOME_RATE_MESSAGE;
import static lotto.LottoViewConstantMessages.LOTTO_RESULT_TITLE;
import static lotto.LottoViewConstantMessages.PURCHASED_QUANTITY_MESSAGE;
import static lotto.LottoViewConstantMessages.PURCHASE_PRICE_REQUEST_MESSAGE;
import static lotto.LottoViewConstantMessages.SIX_MATCH_MESSAGE;
import static lotto.LottoViewConstantMessages.SPLIT_BAR;
import static lotto.LottoViewConstantMessages.THREE_MATCH_MESSAGE;
import static lotto.LottoViewConstantMessages.WINNING_NUMBERS_REQUEST_MESSAGE;

import java.util.List;

public class LottoView {
    public static String requestPurchasePrice() {
        printConstantMessage(PURCHASE_PRICE_REQUEST_MESSAGE);
        String readLine = readLine();
        System.out.println();
        return readLine;
    }

    public static void printPurchasedLottos(Lottos lottos) {
        System.out.print(lottos.getLottos().size());
        printConstantMessage(PURCHASED_QUANTITY_MESSAGE);
        for (Lotto lotto : lottos.getLottos()) {
            System.out.println(lotto.getNumbers());
        }
        System.out.println();
    }

    public static String requestWinningNumbers() {
        printConstantMessage(WINNING_NUMBERS_REQUEST_MESSAGE);
        String readLine = readLine();
        System.out.println();
        return readLine;
    }

    public static String requestBonusNumber() {
        printConstantMessage(BONUS_NUMBER_REQUEST_MESSAGE);
        String readLine = readLine();
        System.out.println();
        return readLine;
    }

    public static void printLottoResult(List<Integer> matchedCount, double incomeRate) {
        printConstantMessage(LOTTO_RESULT_TITLE);
        printConstantMessage(SPLIT_BAR);
        printMatchMessage(matchedCount);
        printConstantMessageWithArguments(INCOME_RATE_MESSAGE, new String[]{Double.toString(incomeRate)});
    }

    private static void printMatchMessage(List<Integer> matchedCount) {
        final int THREE_MATCH_INDEX = 0;
        final int FOUR_MATCH_INDEX = 1;
        final int FIVE_MATCH_INDEX = 2;
        final int BONUS_MATCH_INDEX = 3;
        final int SIX_MATCH_INDEX = 4;
        printConstantMessageWithArguments(THREE_MATCH_MESSAGE,
                new String[]{THREE_MATCH_PRIZE_MONEY.getPrizeByDecimal(),
                        numberToText(matchedCount.get(THREE_MATCH_INDEX))});
        printConstantMessageWithArguments(FOUR_MATCH_MESSAGE,
                new String[]{FOUR_MATCH_PRIZE_MONEY.getPrizeByDecimal(),
                        numberToText(matchedCount.get(FOUR_MATCH_INDEX))});
        printConstantMessageWithArguments(FIVE_MATCH_MESSAGE,
                new String[]{FIVE_MATCH_PRIZE_MONEY.getPrizeByDecimal(),
                        numberToText(matchedCount.get(FIVE_MATCH_INDEX))});
        printConstantMessageWithArguments(BONUS_MATCH_MESSAGE,
                new String[]{BONUS_PRIZE_MONEY.getPrizeByDecimal(),
                        numberToText(matchedCount.get(BONUS_MATCH_INDEX))});
        printConstantMessageWithArguments(SIX_MATCH_MESSAGE,
                new String[]{SIX_MATCH_PRIZE_MONEY.getPrizeByDecimal(),
                        numberToText(matchedCount.get(SIX_MATCH_INDEX))});
    }

    private static void printConstantMessage(LottoViewConstantMessages lottoViewConstantsMessage) {
        System.out.println(lottoViewConstantsMessage.getMessage());
    }

    private static void printConstantMessageWithArguments(
            LottoViewConstantMessages lottoViewConstantMessages,
            String[] arguments
    ) {
        System.out.println(lottoViewConstantMessages.getMessageByMessageFormat().format(arguments));
    }


}
