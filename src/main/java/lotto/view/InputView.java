package lotto.view;

import static lotto.common.constant.ErrorConstant.ERROR_PREFIX;
import static lotto.view.InputGuideMessage.LOTTO_PURCHASE_AMOUNT_INPUT_GUIDE;
import static lotto.view.InputGuideMessage.WINNING_NUMBERS_INPUT_GUIDE;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;
import lotto.common.validator.NumericValidator;
import lotto.common.validator.StringLiteralValidator;
import lotto.domain.Lotto;
import lotto.domain.LottoPurchaseAmount;
import lotto.domain.constant.LottoNumberConstant;
import lotto.view.constant.CharacterSymbol;
import lotto.view.printer.Printer;
import lotto.view.reader.Reader;

public class InputView {

    private static final String WINNING_NUMBER_DELIMITER = CharacterSymbol.COMMA.getLiteral();

    private final Reader reader;
    private final Printer printer;

    public InputView(Reader reader, Printer printer) {
        this.reader = reader;
        this.printer = printer;
    }

    public LottoPurchaseAmount inputLottoPurchaseAmount() {
        printer.printLine(LOTTO_PURCHASE_AMOUNT_INPUT_GUIDE.getGuide());
        String input = reader.readLine();

        validatePurchaseAmountInput(input);

        return new LottoPurchaseAmount(new BigDecimal(Integer.parseInt(input)));
    }

    public List<Integer> inputWinningNumbers() {
        printer.printLine(WINNING_NUMBERS_INPUT_GUIDE.getGuide());

        String input = reader.readLine();

        validateWinningNumbers(input);

        return toIntegerList(input, WINNING_NUMBER_DELIMITER);
    }

    private void validateWinningNumbers(String input) {
        List<Integer> list = toIntegerList(input, WINNING_NUMBER_DELIMITER);
        validateNumberSize(list);
        validateNumberRange(list);
        validateNotDuplicated(list);
    }

    private static List<Integer> toIntegerList(String input, String delimiter) {
        return Stream.of(input.split(delimiter))
                .map(Integer::parseInt)
                .toList();
    }

    private static void validateNotDuplicated(List<Integer> numbers) {
        if (Set.copyOf(numbers).size() != numbers.size()) {
            throw new IllegalArgumentException("%s 당첨 번호는 중복될 수 없습니다.".formatted(ERROR_PREFIX));
        }
    }

    private static void validateNumberRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (!(number >= LottoNumberConstant.MIN_LOTTO_NUMBER && number <= LottoNumberConstant.MAX_LOTTO_NUMBER)) {
                throw new IllegalArgumentException("%s 로또 번호는 %d부터 %d 사이의 숫자여야 합니다.".formatted(
                        ERROR_PREFIX,
                        LottoNumberConstant.MIN_LOTTO_NUMBER,
                        LottoNumberConstant.MAX_LOTTO_NUMBER
                ));
            }
        }
    }

    private void validateNumberSize(List<Integer> numbers) {
        if (numbers.size() != Lotto.DEFAULT_NUMBER_SIZE) {
            throw new IllegalArgumentException(
                    "%s 당첨 숫자는 %d개 입력해야합니다.".formatted(ERROR_PREFIX, Lotto.DEFAULT_NUMBER_SIZE)
            );
        }
    }

    private void validatePurchaseAmountInput(String input) {
        validatePositiveInteger(input, "%s 구입 금액은 양수여야 합니다.".formatted(ERROR_PREFIX));
        validateDivisible(
                Integer.parseInt(input),
                LottoPurchaseAmount.AMOUNT_CLASSIFICATION_THRESHOLD,
                "%s 구입 금액은 %d원 단위로 입력해주세요.".formatted(ERROR_PREFIX, LottoPurchaseAmount.AMOUNT_CLASSIFICATION_THRESHOLD)
        );
    }

    private void validateDivisible(int dividend, int divisor, String message) {
        try {
            NumericValidator.validateDivisible(dividend, divisor);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(message);
        }
    }

    private void validatePositiveInteger(String input, String message) {
        try {
            StringLiteralValidator.validatePositiveInteger(input);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(message);
        }
    }

}
