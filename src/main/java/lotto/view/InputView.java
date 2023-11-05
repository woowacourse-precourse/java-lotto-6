package lotto.view;

import lotto.domain.dto.input.PurchaseLottoDto;
import lotto.io.Reader;
import lotto.io.Writer;

public class InputView {
    private static final String INPUT_PURCHASE_AMOUNT = "구입금액을 입력해 주세요.";
    private final Writer writer;
    private final Reader reader;

    public InputView(Writer writer, Reader reader) {
        this.writer = writer;
        this.reader = reader;
    }

    public PurchaseLottoDto getPurchaseAmount() {
        writer.writeln(INPUT_PURCHASE_AMOUNT);
        try {
            int amount = reader.readInt();
            return new PurchaseLottoDto(amount);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getPurchaseAmount();
        }
    }
}
