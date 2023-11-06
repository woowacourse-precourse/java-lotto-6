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
        List<Integer> winningNumbers = new ArrayList<>();
        for (String number : isSplitWinningNumbers) {
            winningNumbers.add(Integer.parseInt(number));
        }
        return winningNumbers;
    }
}
