package lotto;

import static lotto.resource.TextResourceProvider.LOTTERY_EARNING_RATE_RESULT_TEXT;
import static lotto.resource.TextResourceProvider.LOTTERY_RANKING_RESULT_DEFAULT_HEADER_FORMAT;
import static lotto.resource.TextResourceProvider.LOTTERY_RANKING_RESULT_FORMAT;
import static lotto.resource.TextResourceProvider.LOTTERY_RANKING_RESULT_SECOND_HEADER_FORMAT;
import static lotto.resource.TextResourceProvider.LOTTO_NUMBERS_TEXT_FORMAT;
import static lotto.resource.TextResourceProvider.OUTPUT_LOTTERY_RESULT_HEADER_LINE_TEXT;
import static lotto.resource.TextResourceProvider.OUTPUT_LOTTERY_RESULT_TEXT;
import static lotto.resource.TextResourceProvider.QUANTITY_OUTPUT_TEXT_FORMAT;

import java.text.NumberFormat;
import java.util.List;
import lotto.domain.LotteryRanking;
import lotto.domain.LotteryReceipt;
import lotto.domain.LotteryResult;
import lotto.domain.PurchasedLottery;

public class OutputInterface {

    private NumberFormat numberFormat;

    OutputInterface(NumberFormat numberFormat) {
        this.numberFormat = numberFormat;
    }

    void printReceipt(LotteryReceipt receipt) {
        System.out.println(QUANTITY_OUTPUT_TEXT_FORMAT.format(Long.toString(receipt.size())));
        System.out.println(renderReceipt(receipt));
    }

    void printResults(List<LotteryResult> results, double earningRate) {
        System.out.println(OUTPUT_LOTTERY_RESULT_TEXT);
        System.out.println(OUTPUT_LOTTERY_RESULT_HEADER_LINE_TEXT);
        System.out.println(renderLotteryResults(results));
        System.out.println(LOTTERY_EARNING_RATE_RESULT_TEXT.format(String.format("%.1f", earningRate)));

    }

    String renderReceipt(LotteryReceipt receipt) {
        StringBuilder builder = new StringBuilder();
        for (PurchasedLottery lottery : receipt.getLotteries()) {
            builder.append(renderPurchasedLottery(lottery));
        }
        return builder.toString();
    }

    String renderPurchasedLottery(PurchasedLottery lottery) {
        String[] arguments = lottery.getNumbers()
                .stream()
                .sorted()
                .map(number -> Integer.toString(number))
                .toArray(String[]::new);

        return LOTTO_NUMBERS_TEXT_FORMAT.format(arguments)+"\n";
    }

    String renderLotteryResults(List<LotteryResult> results) {
        StringBuilder builder = new StringBuilder();
        for (LotteryResult result : results) {
            builder.append(renderLotteryResult(result));
        }
        return builder.toString();
    }

    String renderLotteryResult(LotteryResult result) {
        String counts = Integer.toString(result.counts());
        if (result.ranking() == LotteryRanking.LAST_PLACE) {
            return "";
        }
        if (result.ranking() == LotteryRanking.SECOND) {
            String matches = Integer.toString(result.ranking().matches);
            String amount = renderAmount(result.ranking().getAmount());
            String header = LOTTERY_RANKING_RESULT_SECOND_HEADER_FORMAT.format(matches, amount);
            return LOTTERY_RANKING_RESULT_FORMAT.format(header, counts) + "\n";
        }
        String matches = Integer.toString(result.ranking().matches);
        String amount = renderAmount(result.ranking().getAmount());
        String header = LOTTERY_RANKING_RESULT_DEFAULT_HEADER_FORMAT.format(matches, amount);
        return LOTTERY_RANKING_RESULT_FORMAT.format(header, counts) + "\n";
    }

    String renderAmount(int amount) {
        return numberFormat.format(amount);
    }

}
