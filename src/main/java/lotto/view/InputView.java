package lotto.view;

import static lotto.view.InputGuideMessage.BONUS_NUMBER_INPUT_GUIDE;
import static lotto.view.InputGuideMessage.LOTTO_PURCHASE_AMOUNT_INPUT_GUIDE;
import static lotto.view.InputGuideMessage.WINNING_NUMBERS_INPUT_GUIDE;

import java.math.BigDecimal;
import java.util.List;
import lotto.common.convertor.StringConvertor;
import lotto.domain.LottoPurchaseAmount;
import lotto.view.constant.CharacterSymbol;
import lotto.view.printer.Printer;
import lotto.view.reader.Reader;

public class InputView {

    private static final String WINNING_NUMBER_DELIMITER = CharacterSymbol.COMMA.getLiteral();

    private final Reader reader;
    private final Printer printer;
    private final InputValidator validator;

    private InputView(Reader reader, Printer printer, InputValidator validator) {
        this.reader = reader;
        this.printer = printer;
        this.validator = validator;
    }

    public static InputView of(Reader reader, Printer printer) {
        return new InputView(reader, printer, InputValidator.INSTANCE);
    }

    public LottoPurchaseAmount inputLottoPurchaseAmount() {
        printer.printLine(LOTTO_PURCHASE_AMOUNT_INPUT_GUIDE.getGuide());
        String input = reader.readLine();

        validator.validatePurchaseAmount(input);

        return new LottoPurchaseAmount(new BigDecimal(Integer.parseInt(input)));
    }

    public List<Integer> inputWinningNumbers() {
        printer.printLine(WINNING_NUMBERS_INPUT_GUIDE.getGuide());

        String input = reader.readLine();
        List<Integer> numbers = StringConvertor.toIntegerList(input, WINNING_NUMBER_DELIMITER);

        validator.validateWinningNumbers(numbers);

        return numbers;
    }

    public int inputBonusNumber() {
        printer.printLine(BONUS_NUMBER_INPUT_GUIDE.getGuide());

        String input = reader.readLine();
        validator.validateBonusNumber(input);

        return Integer.parseInt(input);
    }

}
