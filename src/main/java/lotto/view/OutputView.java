package lotto.view;

import java.util.List;
import lotto.constant.LottoMessage;
import lotto.model.LottoRank;
import lotto.model.ProfitRate;

public class OutputView {

    public static void printLottoNumbers(List<Integer> numbers) {
        LottoMessage message = LottoMessage.LOTTO_NUMBERS_OUTPUT_MESSAGE;
        System.out.println(message.getMessage(numbers.toArray()));
    }

    public static void printPurchasedLottoQuantity(int count) {
        LottoMessage message = LottoMessage.PURCHASED_LOTTO_QUANTITY_MESSAGE;
        System.out.println(message.getMessage(count));
    }

    public static void printLottoRank(LottoRank lottoRank, int count) {
        LottoMessage message = getLottoRankMessage(lottoRank.isMatchBonus());

        System.out.println(message.getMessage(
                lottoRank.getMatchCount(),
                lottoRank.getWinningMoney(),
                count)
        );
    }

    public static void printProfitRate(ProfitRate profitRate) {
        LottoMessage message = LottoMessage.TOTAL_PROFIT_RATE_MESSAGE;
        System.out.println(message.getMessage(profitRate.getProfitRate()));
    }

    private static LottoMessage getLottoRankMessage(boolean matchBonus) {
        if (matchBonus) {
            return LottoMessage.WINNING_STATISTICS_BONUS_MESSAGE;
        }

        return LottoMessage.WINNING_STATISTICS_MESSAGE;
    }

    public static void printWinningResultTitle() {
        System.out.println(LottoMessage.WINNING_STATISTICS_TITLE_MESSAGE.getMessage());
    }

    public static void printNewLine() {
        System.out.println();
    }

    public static void printExceptionMessage(String message) {
        System.out.println(message);
    }
}
