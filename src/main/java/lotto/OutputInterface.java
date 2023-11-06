package lotto;

import static lotto.resource.TextResourceProvider.LOTTERY_EARNING_RATE_RESULT_TEXT;
import static lotto.resource.TextResourceProvider.LOTTO_NUMBERS_TEXT_FORMAT;
import static lotto.resource.TextResourceProvider.OUTPUT_LOTTERY_RESULT_HEADER_LINE_TEXT;
import static lotto.resource.TextResourceProvider.OUTPUT_LOTTERY_RESULT_TEXT;
import static lotto.resource.TextResourceProvider.QUANTITY_OUTPUT_TEXT_FORMAT;

import lotto.domain.LotteryReceipt;
import lotto.domain.LotteryResults;
import lotto.domain.PurchasedLottery;

public class OutputInterface {
    void printReceipt(LotteryReceipt receipt) {
        System.out.println(QUANTITY_OUTPUT_TEXT_FORMAT.format(Long.toString(receipt.size())));
        System.out.println(renderReceipt(receipt));
    }

    void printResults(LotteryResults results, double earningRate){
        System.out.println(OUTPUT_LOTTERY_RESULT_TEXT);
        System.out.println(OUTPUT_LOTTERY_RESULT_HEADER_LINE_TEXT);
        System.out.println(LOTTERY_EARNING_RATE_RESULT_TEXT.format(String.format("%.1f",earningRate)));

    }

    String renderReceipt(LotteryReceipt receipt) {
        StringBuilder builder = new StringBuilder();
        for (PurchasedLottery lottery : receipt.getLotteries()) {
            builder.append(renderPurchasedLottery(lottery));
        }
        return builder.toString();
    }

    String renderPurchasedLottery(PurchasedLottery lottery) {
        StringBuilder builder = new StringBuilder();
        String[] arguments = lottery.getNumbers()
                .stream()
                .map(number -> Integer.toString(number))
                .toArray(String[]::new);

        return LOTTO_NUMBERS_TEXT_FORMAT.format(arguments);
    }

}
