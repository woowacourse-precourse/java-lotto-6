package lotto;

import static java.util.stream.Collectors.toList;
import static lotto.resource.TextResourceProvider.LOTTO_NUMBERS_TEXT_FORMAT;
import static lotto.resource.TextResourceProvider.QUANTITY_OUTPUT_TEXT_FORMAT;

import java.util.List;
import lotto.domain.LotteryReceipt;
import lotto.domain.PurchasedLottery;

public class OutputInterface {
    void printReceipt(LotteryReceipt receipt) {
        System.out.println(QUANTITY_OUTPUT_TEXT_FORMAT.format(Long.toString(receipt.size())));
        System.out.println(renderReceipt(receipt));
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
