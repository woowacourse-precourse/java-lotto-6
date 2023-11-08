package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.dto.request.BonusNumberRequest;
import lotto.dto.request.PurchasePriceRequest;
import lotto.dto.request.WinningNumberRequest;
import lotto.exception.InputException;
import java.util.Arrays;
import java.util.List;

import static lotto.configuration.GameConfiguration.INPUT_SEPARATOR;
import static lotto.configuration.GameConfiguration.LOTTO_NUMBER_SIZE;
import static lotto.exception.errorcode.InputErrorCode.INPUT_NOT_NUMERIC;

public class ConsoleInputView implements InputView {
    @Override
    public PurchasePriceRequest requestPurchasePrice() {
        final String input = Console.readLine();
        return new PurchasePriceRequest(Long.parseLong(input));
    }

    @Override
    public WinningNumberRequest requestWinningNumber() {
        final String winningNumber = Console.readLine();
        validateSplitEachNumeric(winningNumber);
        return new WinningNumberRequest(getWinningNumber(winningNumber));
    }

    @Override
    public BonusNumberRequest requestBonusNumber() {
        final String bonusNumber = Console.readLine();
        validateNumeric(bonusNumber);
        return new BonusNumberRequest(Integer.parseInt(bonusNumber));
    }

    private List<Integer> getWinningNumber(final String winningNumber) {
        return Arrays.stream(winningNumber.split(INPUT_SEPARATOR))
                .mapToInt(Integer::parseInt)
                .boxed()
                .toList();
    }

    private void validateNumeric(final String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new InputException(INPUT_NOT_NUMERIC);
        }
    }

    private void validateSplitEachNumeric(final String input) {
        Arrays.stream(input.split(INPUT_SEPARATOR))
                .forEach(this::validateNumeric);
    }
}
