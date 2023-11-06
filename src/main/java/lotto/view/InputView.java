package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import lotto.domain.wrapper.LottoNumber;
import lotto.domain.wrapper.PurchaseAmount;
import lotto.utils.ErrorMessage;
import lotto.utils.LottoConstant;

public class InputView {
    public int getPurchaseAmount() {
        String input = Console.readLine();
        try {
            validateNotNull(input);
            validateNotEmpty(input);
            validateParsedToInteger(input);
            new PurchaseAmount(Integer.parseInt(input));
        } catch (IllegalArgumentException illegalArgumentException) {
            System.out.println(illegalArgumentException.getMessage());
            getPurchaseAmount();
        }
        return Integer.parseInt(input);
    }

    public List<Integer> getWinningNumbers() {
        String input = Console.readLine();
        validateNotNull(input);
        validateNotEmpty(input);
        return Arrays.stream(input.split(LottoConstant.DELIMITER.get()))
                .peek(this::validateParsedToInteger)
                .map(Integer::parseInt)
                .toList();
    }

    public int getBonusNumber(List<Integer> winningNumbers) {
        String input = Console.readLine();
        try {
            validateBonusNumber(input, winningNumbers);
            LottoNumber bonusNumber = new LottoNumber(Integer.parseInt(input));
        } catch (IllegalArgumentException illegalArgumentException) {
            System.out.println(illegalArgumentException.getMessage());
            getBonusNumber(winningNumbers);
        }
        return Integer.parseInt(input);
    }

    private void validateBonusNumber(String input, List<Integer> winningNumbers) {
        validateNotNull(input);
        validateNotEmpty(input);
        validateParsedToInteger(input);
        if (winningNumbers.contains(Integer.parseInt(input))) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_NUMBER_DUPLICATION.getWithPrefix());
        }
    }

    private void validateNotNull(String input) {
        if (input == null) {
            throw new IllegalArgumentException(ErrorMessage.NULL_INPUT.getWithPrefix());
        }
    }

    private void validateNotEmpty(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException(ErrorMessage.EMPTY_INPUT.getWithPrefix());
        }
    }

    private void validateParsedToInteger(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException numberFormatException) {
            throw new IllegalArgumentException(ErrorMessage.NOT_INTEGER_INPUT.getWithPrefix());
        }
    }
}
