package lotto;

import static lotto.resource.TextResourceProvider.LOTTO_NUMBERS_TEXT_FORMAT;

import lotto.service.dto.LotteryDto;
import lotto.service.dto.LotteryReceiptDto;

public class ReceiptRenderer {
    public String render(LotteryReceiptDto receipt) {
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
}
