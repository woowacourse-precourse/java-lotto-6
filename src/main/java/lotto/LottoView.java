package lotto;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static lotto.LottoParser.numberToText;
import static lotto.enums.LottoPrizeConstants.THREE_MATCH_PRIZE;
import static lotto.enums.LottoPrizeConstants.FOUR_MATCH_PRIZE;
import static lotto.enums.LottoPrizeConstants.FIVE_MATCH_PRIZE;
import static lotto.enums.LottoPrizeConstants.BONUS_PRIZE;
import static lotto.enums.LottoPrizeConstants.SIX_MATCH_PRIZE;
import static lotto.enums.LottoViewConstantMessages.BONUS_MATCH_MESSAGE;
import static lotto.enums.LottoViewConstantMessages.BONUS_NUMBER_REQUEST_MESSAGE;
import static lotto.enums.LottoViewConstantMessages.FIVE_MATCH_MESSAGE;
import static lotto.enums.LottoViewConstantMessages.FOUR_MATCH_MESSAGE;
import static lotto.enums.LottoViewConstantMessages.INCOME_RATE_MESSAGE;
import static lotto.enums.LottoViewConstantMessages.LOTTO_RESULT_TITLE;
import static lotto.enums.LottoViewConstantMessages.PURCHASED_QUANTITY_MESSAGE;
import static lotto.enums.LottoViewConstantMessages.PURCHASE_PRICE_REQUEST_MESSAGE;
import static lotto.enums.LottoViewConstantMessages.SIX_MATCH_MESSAGE;
import static lotto.enums.LottoViewConstantMessages.SPLIT_BAR;
import static lotto.enums.LottoViewConstantMessages.THREE_MATCH_MESSAGE;
import static lotto.enums.LottoViewConstantMessages.WINNING_NUMBERS_REQUEST_MESSAGE;

import java.util.Map;
import lotto.enums.LottoPrizeConstants;
import lotto.enums.LottoViewConstantMessages;

public class LottoView {
    public static String requestPurchasePrice() {
        printConstantMessage(PURCHASE_PRICE_REQUEST_MESSAGE);
        String readLine = readLine();
        System.out.println();
        return readLine;
    }

    public static void printPurchasedLottos(Lottos lottos) {
        printConstantMessageWithArguments(PURCHASED_QUANTITY_MESSAGE, new String[]{
                numberToText(lottos.getQuantity())
        });
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

    public static void printLottoResult(Map<LottoPrizeConstants, Integer> matchedCount, double incomeRate) {
        printConstantMessage(LOTTO_RESULT_TITLE);
        printConstantMessage(SPLIT_BAR);
        printMatchMessage(matchedCount);
        printConstantMessageWithArguments(INCOME_RATE_MESSAGE, new String[]{Double.toString(incomeRate)});
    }

    private static void printMatchMessage(Map<LottoPrizeConstants, Integer> matchedCount) {
        printConstantMessageWithArguments(THREE_MATCH_MESSAGE,
                new String[]{THREE_MATCH_PRIZE.getPrizeByDecimal(),
                        numberToText(matchedCount.get(THREE_MATCH_PRIZE))});
        printConstantMessageWithArguments(FOUR_MATCH_MESSAGE,
                new String[]{FOUR_MATCH_PRIZE.getPrizeByDecimal(),
                        numberToText(matchedCount.get(FOUR_MATCH_PRIZE))});
        printConstantMessageWithArguments(FIVE_MATCH_MESSAGE,
                new String[]{FIVE_MATCH_PRIZE.getPrizeByDecimal(),
                        numberToText(matchedCount.get(FIVE_MATCH_PRIZE))});
        printConstantMessageWithArguments(BONUS_MATCH_MESSAGE,
                new String[]{BONUS_PRIZE.getPrizeByDecimal(),
                        numberToText(matchedCount.get(BONUS_PRIZE))});
        printConstantMessageWithArguments(SIX_MATCH_MESSAGE,
                new String[]{SIX_MATCH_PRIZE.getPrizeByDecimal(),
                        numberToText(matchedCount.get(SIX_MATCH_PRIZE))});
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
