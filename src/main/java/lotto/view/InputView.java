package lotto.view;

import static java.util.stream.Collectors.toList;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public final class InputView extends ConsoleView {

    private static final String REQUEST_PURCHASE_AMOUNT = "구입금액을 입력해 주세요.";
    private static final String REQUEST_WINNING_NUMBERS = "당첨 번호를 입력해 주세요.";
    private static final String REQUEST_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";
    private static final String ERROR_MANDATORY_INPUT = "[ERROR] %s은(는) 필수입니다.";
    private static final String ERROR_ONLY_INT_ALLOWED = "[ERROR] 정수만 입력 가능 합니다.";

    private static final String EMPTY_STRING = "";
    private static final String DELIMITER = ",";

    private static final String PURCHASE_AMOUNT_STRING = "구입 금액";
    private static final String WINNING_NUMBERS_STRING = "당첨 번호";
    private static final String BONUS_NUMBER_STRING = "보너스 번호";

    public int inputPurchaseAmount() {
        this.println(REQUEST_PURCHASE_AMOUNT);
        final String input = this.read();
        validateNotEmpty(input, String.format(ERROR_MANDATORY_INPUT, PURCHASE_AMOUNT_STRING));
        return parse(input, Integer::parseInt);
    }

    public List<Integer> inputWinningNumbers() {
        this.println(REQUEST_WINNING_NUMBERS);
        final String input = this.read();
        validateNotEmpty(input, String.format(ERROR_MANDATORY_INPUT, WINNING_NUMBERS_STRING));
        return parse(input, this::parseToList);
    }

    public int inputBonusNumber() {
        this.println(REQUEST_BONUS_NUMBER);
        final String input = this.read();
        validateNotEmpty(input, String.format(ERROR_MANDATORY_INPUT, BONUS_NUMBER_STRING));
        return parse(input, Integer::parseInt);
    }

    private void validateNotEmpty(String input, String errorMessage) {
        if (input == null || input.trim().equals(EMPTY_STRING)) {
            throw new IllegalArgumentException(errorMessage);
        }
    }

    private <T> T parse(String input, Function<String, T> parser) {
        try {
            return parser.apply(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_ONLY_INT_ALLOWED);
        }
    }

    private List<Integer> parseToList(String input) {
        return Arrays.stream(input.split(DELIMITER))
            .map(Integer::parseInt)
            .collect(toList());
    }
}
