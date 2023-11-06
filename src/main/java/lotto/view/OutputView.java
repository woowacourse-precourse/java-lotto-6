package lotto.view;

import lotto.constant.RankCategory;
import lotto.model.Lotto;
import lotto.model.LottoResult;
import lotto.model.ProfitRate;
import lotto.model.collections.LottoBundle;

import java.text.DecimalFormat;
import java.util.List;
import java.util.stream.Collectors;

import static lotto.view.Message.*;

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

    public static void printLottoResult(LottoResult lottoResult, ProfitRate profitRate) {
        StringBuilder sb = new StringBuilder();
        for (RankCategory rankCategory : RankCategory.values()) {
            if (rankCategory == RankCategory.NONE) {
                continue;
            }
            int count = lottoResult.getResults().getOrDefault(rankCategory, 0);
            if (rankCategory.isBonusStatus()) {
                sb.append(rankCategory.getMatchingNumbers())
                        .append("개 일치, 보너스 볼 일치 (")
                        .append(formatPrize(rankCategory.getPrize()))
                        .append("원) - ")
                        .append(count)
                        .append("개\n");
                continue;
            }
            sb.append(rankCategory.getMatchingNumbers())
                    .append("개 일치 (")
                    .append(formatPrize(rankCategory.getPrize()))
                    .append("원) - ")
                    .append(count)
                    .append("개\n");
        }
        sb.append("총 수익률은 ")
                .append(String.format("%.1f", profitRate.getRate()))
                .append("%입니다.");
        printMessage(sb.toString());
    }

    public static void printErrorMessage() {
        printMessage("[ERROR]");
    }

    private static String formatPrize(int prize) {
        DecimalFormat df = new DecimalFormat("###,###");
        return df.format(prize);
    }

    private static String formatLottoNumbers(List<Integer> numbers) {
        return numbers.stream()
                .map(Object::toString)
                .collect(Collectors.joining(", ", "[", "]"));
    }

    private static void printMessage() {
        System.out.println();
    }


    private static void printMessage(String message) {
        System.out.println(message);
    }

}
