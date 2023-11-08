package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import java.util.stream.Collectors;
import lotto.model.Lotto;
import lotto.utils.Constants;
import lotto.utils.ErrorMessage;
import lotto.utils.Util;

public class InputView {
    private static final String NEW_LINE = System.lineSeparator();
    private static final String INPUT_BUY_AMOUNT = "구입금액을 입력해 주세요.";
    private static final String INPUT_WINNING_NUMBER = "당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";

    public int inputBuyAmount() {
        System.out.println(INPUT_BUY_AMOUNT);
        String amount = Console.readLine();
        validateIntRange(amount);
        validateDivisibleByThousand(amount);
        return Integer.parseInt(amount);
    }

    public Lotto inputWinningLotto() {
        System.out.println(NEW_LINE + INPUT_WINNING_NUMBER);
        List<String> winningNumber = Util.splitByComma(Util.removeSpace(Console.readLine()));
        validateWinningNumber(winningNumber);
        return new Lotto(winningNumber.stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList())
        );
    }

    public int inputBonusNumber() {
        System.out.println(NEW_LINE + INPUT_BONUS_NUMBER);
        String number = Console.readLine();
        validateIntRange(number);
        validateLottoRange(number);
        return Integer.parseInt(number);
    }

    private void validateWinningNumber(List<String> numbers) {
        if (numbers.size() != Constants.LOTTO_SIZE) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_LOTTO_SIZE.getMessage());
        }
        numbers.forEach(this::validateLottoRange);
    }

    private void validateIntRange(String input) throws IllegalArgumentException {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_INT_RANGE.getMessage());
        }
    }

    private void validateDivisibleByThousand(String input) {
        int amount = Integer.parseInt(input);
        if (amount % Constants.LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_DIVISIBLE.getMessage());
        }
    }

    private void validateLottoRange(String input) {
        int number = Integer.parseInt(input);
        if (number < Constants.MIN_RANGE || number > Constants.MAX_RANGE) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_LOTTO_RANGE.getMessage());
        }
    }
}
