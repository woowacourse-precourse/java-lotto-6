package lotto.view;

import lotto.dto.input.AmountDto;
import lotto.io.input.StdReader;
import lotto.io.output.StdWriter;

public class InputView {
    private final StdReader reader;
    private final StdWriter writer;

    public InputView(StdReader reader, StdWriter writer) {
        this.reader = reader;
        this.writer = writer;
    }

    public AmountDto readPurchaseAmount() {
        writer.writeLine("구입금액을 입력해 주세요.");
        String input = reader.readLine();
        InputValidator.verifyNonEmptyInput(input);
        InputValidator.verifyNumericString(input);
        return new AmountDto(input);
    }
}
