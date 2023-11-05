package lotto;

import static lotto.resource.TextResourceProvider.QUANTITY_OUTPUT_TEXT_FORMAT;

import lotto.domain.LotteryReceipt;

public class OutputInterface {
    void printReceipt(LotteryReceipt receipt) {
        System.out.println(QUANTITY_OUTPUT_TEXT_FORMAT.format(Long.toString(receipt.size())));
    }
}
