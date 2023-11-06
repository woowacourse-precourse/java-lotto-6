package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lotto.validator.InputValidator;
import lotto.view.InputView;

public class WinningNumbers {
    public List<Integer> askWinningNumbers() {
        InputView.showAskWinningNumbers();
        String inputWinningNumbers = Console.readLine();
        List<String> isSplitWinningNumbers = Arrays.asList(inputWinningNumbers.split(","));
        checkInputValidation(inputWinningNumbers, isSplitWinningNumbers);
        List<Integer> winningNumbers = new ArrayList<>();
        for (String number : isSplitWinningNumbers) {
            winningNumbers.add(Integer.parseInt(number));
        }
        return winningNumbers;
    }

    private void checkInputValidation(String inputWinningNumbers, List<String> isSplitWinningNumbers) {
        InputValidator.isNullOrIsEmpty(inputWinningNumbers);
        InputValidator.includeSymbolExceptComma(inputWinningNumbers);
        InputValidator.isNotDigit(isSplitWinningNumbers);
    }
}
