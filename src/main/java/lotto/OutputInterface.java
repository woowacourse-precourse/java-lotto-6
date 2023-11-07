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
import lotto.service.dto.LotteryDto;
import lotto.service.dto.LotteryReceiptDto;
import lotto.service.dto.LotteryResultDto;

public class OutputInterface {

    private NumberFormat numberFormat;
    private Output out;

    OutputInterface(Output out, NumberFormat numberFormat) {
        this.numberFormat = numberFormat;
        this.out = out;
    }

    public void printReceipt(LotteryReceiptDto receipt) {
        out.println(QUANTITY_OUTPUT_TEXT_FORMAT.format(Long.toString(receipt.quantity())));
        out.println(renderReceipt(receipt));
    }

    public void printResults(List<LotteryResultDto> results, double earningRate) {
        out.println(OUTPUT_LOTTERY_RESULT_TEXT);
        out.println(OUTPUT_LOTTERY_RESULT_HEADER_LINE_TEXT);
        out.println(renderLotteryResults(results));
        out.println(LOTTERY_EARNING_RATE_RESULT_TEXT.format(String.format("%.1f", earningRate)));

    }

    private String renderReceipt(LotteryReceiptDto receipt) {
        StringBuilder builder = new StringBuilder();
        for (LotteryDto lottery : receipt.lotteries()) {
            builder.append(renderPurchasedLottery(lottery));
        }
        return builder.toString();
    }

    private String renderPurchasedLottery(LotteryDto lottery) {
        String[] arguments = lottery.numbers()
                .stream()
                .sorted()
                .map(number -> Integer.toString(number))
                .toArray(String[]::new);

        return LOTTO_NUMBERS_TEXT_FORMAT.format(arguments) + "\n";
    }

    private String renderLotteryResults(List<LotteryResultDto> results) {
        StringBuilder builder = new StringBuilder();
        for (LotteryResultDto result : results) {
            builder.append(renderLotteryResult(result));
        }
        return builder.toString();
    }

    private String renderLotteryResult(LotteryResultDto result) {
        if ("LAST_PLACE".equals(result.ranking())) {
            return "";
        }
        String counts = Integer.toString(result.counts());
        String matches = Integer.toString(result.rankingMatches());
        String amount = renderAmount(result.rankingAmount());
        if ("SECOND".equals(result.ranking())) {
            String header = LOTTERY_RANKING_RESULT_SECOND_HEADER_FORMAT.format(matches, amount);
            return LOTTERY_RANKING_RESULT_FORMAT.format(header, counts) + "\n";
        }
        String header = LOTTERY_RANKING_RESULT_DEFAULT_HEADER_FORMAT.format(matches, amount);
        return LOTTERY_RANKING_RESULT_FORMAT.format(header, counts) + "\n";
    }

    private String renderAmount(int amount) {
        return numberFormat.format(amount);
    }

}
