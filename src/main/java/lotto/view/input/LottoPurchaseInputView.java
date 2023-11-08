package lotto.view.input;

import lotto.domain.lotto.LottoPurchaseAmount;
import lotto.exception.ErrorMessage;
import lotto.exception.LottoException;
import lotto.view.input.reader.Reader;

public class LottoPurchaseInputView extends ReaderView {
    public LottoPurchaseInputView(final Reader reader) {
        super(reader);
    }

    public LottoPurchaseAmount readLottoPurchaseAmount() throws LottoException {
        final String lottoPurchaseAmountString = reader.read();

        try {
            final int lottoPurchaseAmount = Integer.parseInt(lottoPurchaseAmountString);
            return new LottoPurchaseAmount(lottoPurchaseAmount);
        } catch (NumberFormatException exception) {
            throw LottoException.of(ErrorMessage.INPUT_ONLY_NUMBERS);
        }
    }
}
