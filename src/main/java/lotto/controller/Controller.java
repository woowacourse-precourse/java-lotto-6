package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lotto.domain.WinningNumbers;
import lotto.validator.InputValidator;
import lotto.view.InputView;

public class Controller {
    private WinningNumbers winningNumbers;

    private void getWinningNumbers() {
        String inputWinningNumbers = askWinningNumbers();
        List<String> isSplitWinningNumbers = splitWinningNumbers(inputWinningNumbers);
        checkInputValidation(inputWinningNumbers, isSplitWinningNumbers);
        winningNumbers = new WinningNumbers(convertedWinningNumbers(isSplitWinningNumbers));
    }

    private String askWinningNumbers() {
        InputView.showAskWinningNumbers();
        return Console.readLine().trim();
    }

    private List<String> splitWinningNumbers(String inputWinningNumbers) {
        return Arrays.asList(inputWinningNumbers.split(","));
    }

    private void checkInputValidation(String inputWinningNumbers, List<String> isSplitWinningNumbers) {
        InputValidator.isNullOrIsEmpty(inputWinningNumbers);
        InputValidator.includeSymbolExceptComma(inputWinningNumbers);
        InputValidator.isNotDigit(isSplitWinningNumbers);
    }

    private List<Integer> convertedWinningNumbers(List<String> isSplitWinningNumbers) {
        List<Integer> winningNumbers = new ArrayList<>();
        for (String number : isSplitWinningNumbers) {
            winningNumbers.add(Integer.parseInt(number.trim()));  // 구분자 뒤 공백 제거
        }
        return winningNumbers;
    }
}
