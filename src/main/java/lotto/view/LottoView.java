package lotto.view;

import lotto.controller.dto.input.LottoPurchaseAmountDto;
import lotto.io.reader.Reader;
import lotto.io.writer.Writer;

public class LottoView {

    private final Reader reader;
    private final Writer writer;

    public LottoView(Reader reader, Writer writer) {
        this.reader = reader;
        this.writer = writer;
    }

    public LottoPurchaseAmountDto inputLottoPurchaseAmount() {
        writer.writeLine(LottoMessage.INPUT_LOTTO_PURCHASE_AMOUNT.getMessage());
        return new LottoPurchaseAmountDto(reader.readLine());
    }
}
