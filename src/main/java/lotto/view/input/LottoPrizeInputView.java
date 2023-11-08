package lotto.view.input;

import java.util.Arrays;
import java.util.List;
import lotto.domain.prize.PrizeNumber;
import lotto.domain.prize.PrizeNumberType;
import lotto.exception.ErrorMessage;
import lotto.exception.LottoException;
import lotto.view.input.reader.Reader;

public class LottoPrizeInputView extends ReaderView {
    private static final String DELIMITER_PRIZE_NUMBER = ",";

    public LottoPrizeInputView(final Reader reader) {
        super(reader);
    }

    public List<PrizeNumber> readPrizeNumbers() throws LottoException {
        final String prizeNumbersString = reader.read();

        try {
            return Arrays.stream(prizeNumbersString.split(DELIMITER_PRIZE_NUMBER))
                    .map(String::trim)
                    .mapToInt(Integer::parseInt)
                    .mapToObj(PrizeNumber::new)
                    .toList();
        } catch (NumberFormatException exception) {
            throw LottoException.of(ErrorMessage.INPUT_ONLY_NUMBERS);
        }
    }

    public PrizeNumber readBonusNumber() throws LottoException {
        final String bonusNumberString = reader.read();

        try {
            final int bonusNumber = Integer.parseInt(bonusNumberString);
            return new PrizeNumber(bonusNumber, PrizeNumberType.BONUS);
        } catch (NumberFormatException exception) {
            throw LottoException.of(ErrorMessage.INPUT_ONLY_NUMBERS);
        }
    }
}
