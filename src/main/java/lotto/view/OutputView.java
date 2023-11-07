package lotto.view;

import lotto.constant.RankCategory;
import lotto.model.Lotto;
import lotto.model.LottoResult;
import lotto.model.ProfitRate;
import lotto.model.LottoBundle;

import static lotto.view.OutputFormatter.*;
import static lotto.view.message.GameMessage.*;

public class OutputView {
    public static void printPurchaseAmountMessage() {
        printMessage(PURCHASE_AMOUNT_MESSAGE.getMessage());
    }

    public static void printTicketCountMessage(int ticketCount) {
        printMessage();
        printMessage(TICKET_COUNT_MESSAGE.formatMessage(ticketCount));
    }

    public static void printLottoBundle(LottoBundle lottoBundle) {
        for (Lotto lotto : lottoBundle.getLottoBundle()) {
            printMessage(formatLottoNumbers(lotto.getNumbers()));
        }
    }

    public static void printWinningNumbersMessage() {
        printMessage();
        printMessage(WINNING_NUMBERS_MESSAGE.getMessage());
    }

    public static void printBonusNumberMessage() {
        printMessage();
        printMessage(BONUS_NUMBER_MESSAGE.getMessage());
    }

    public static void printResultMessage() {
        printMessage();
        printMessage(RESULT_MESSAGE.getMessage());
        printMessage(DIVISION_LINE.getMessage());
    }

    public static void printErrorMessage(String message) {
        printMessage(message);
    }

    public static void printLottoResult(LottoResult lottoResult) {
        StringBuilder sb = new StringBuilder();
        for (RankCategory rankCategory : RankCategory.values()) {
            int count = lottoResult.getResults().getOrDefault(rankCategory, 0);
            if (rankCategory == RankCategory.NONE) {
                continue;
            }
            if (rankCategory.isBonusStatus()) {
                formatSecondCategory(sb, rankCategory, count);
                continue;
            }
            formatRankCategory(sb, rankCategory, count);
        }
        printMessage(sb.toString().trim());
    }

    public static void printProfitRate(ProfitRate profitRate) {
        StringBuilder sb = new StringBuilder();
        formatProfitRate(profitRate, sb);
        printMessage(sb.toString());
    }

    private static void printMessage() {
        System.out.println();
    }


    private static void printMessage(String message) {
        System.out.println(message);
    }

}
