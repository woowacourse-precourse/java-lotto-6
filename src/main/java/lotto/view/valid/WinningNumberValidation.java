package lotto.view.valid;

import lotto.domain.WinningLotto;

import java.util.Arrays;
import java.util.List;

import static lotto.constant.SymbolConstant.COMMA;

public class WinningNumberValidation implements InputValidation<WinningLotto> {

    @Override
    public WinningLotto validateInput(final String inputText, final ViewValidator viewValidator) {
        List<String> winningNumbersText = Arrays.asList(inputText.split(COMMA));
        viewValidator.validateWinningNumberSize(winningNumbersText);
        List<Integer> winningNumbers = viewValidator.validateWinningNumberFormat(winningNumbersText);

        return WinningLotto.of(winningNumbers);
    }
}
