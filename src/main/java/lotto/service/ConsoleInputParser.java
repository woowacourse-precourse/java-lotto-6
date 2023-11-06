package lotto.service;

import java.util.Arrays;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.wrapper.BonusNumber;
import lotto.domain.wrapper.PurchaseAmount;
import lotto.utils.ErrorMessage;
import lotto.utils.LottoConstant;

public class ConsoleInputParser {
    public PurchaseAmount toPurchaseAmount(String input) {
        validateInteger(input);
        return new PurchaseAmount(Integer.parseInt(input));
    }

    public Lotto toLotto(String input) {
        List<Integer> numbers = Arrays.stream(input.split(LottoConstant.DELIMITER.get()))
                .map(String::trim)
                .peek(this::validateInteger)
                .map(Integer::parseInt)
                .toList();
        return new Lotto(numbers);
    }

    public BonusNumber toBounsNumber(String input, Lotto winningLotto) {
        validateInteger(input);
        return new BonusNumber(Integer.parseInt(input), winningLotto);
    }

    private void validateInteger(String input) {
        validateNotNull(input);
        validateNotEmpty(input);
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException numberFormatException) {
            throw new IllegalArgumentException(ErrorMessage.NOT_INTEGER_INPUT.getWithPrefix());
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
}
