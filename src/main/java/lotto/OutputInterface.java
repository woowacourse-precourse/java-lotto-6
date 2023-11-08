package lotto;

import static lotto.resource.TextResourceProvider.LOTTERY_EARNING_RATE_RESULT_TEXT;
import static lotto.resource.TextResourceProvider.OUTPUT_LOTTERY_RESULT_HEADER_LINE_TEXT;
import static lotto.resource.TextResourceProvider.OUTPUT_LOTTERY_RESULT_TEXT;
import static lotto.resource.TextResourceProvider.QUANTITY_OUTPUT_TEXT_FORMAT;

import java.util.List;
import lotto.service.dto.LotteryReceiptDto;
import lotto.service.dto.LotteryResultDto;

public class OutputInterface {
    private Output out;
    private ReceiptRenderer receiptRenderer;
    private LotteryResultRenderer lotteryResultRenderer;

    public OutputInterface(Output out, ReceiptRenderer receiptRenderer,
                           LotteryResultRenderer lotteryResultRenderer) {
        this.out = out;
        this.receiptRenderer = receiptRenderer;
        this.lotteryResultRenderer = lotteryResultRenderer;
    }

    public void printReceipt(LotteryReceiptDto receipt) {
        out.println(QUANTITY_OUTPUT_TEXT_FORMAT.format(Long.toString(receipt.quantity())));
        out.println(receiptRenderer.render(receipt));
    }

    public void printResults(List<LotteryResultDto> results, double earningRate) {
        out.println(OUTPUT_LOTTERY_RESULT_TEXT);
        out.println(OUTPUT_LOTTERY_RESULT_HEADER_LINE_TEXT);
        out.println(lotteryResultRenderer.render(results));
        out.println(LOTTERY_EARNING_RATE_RESULT_TEXT.format(String.format("%.1f", earningRate)));
    }
}
