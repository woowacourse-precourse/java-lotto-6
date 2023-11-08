package lotto.provider;

import java.util.ArrayList;
import java.util.List;

public class WinningNumberProvider {
    public List<Integer> getWinningNumber(String winningNumberInput) {
        String[] splitInputs = winningNumberInput.split(",");
        List<Integer> winningNumbers = new ArrayList<>();

        for (String splitInput : splitInputs) {
            int winningNumber = Integer.parseInt(splitInput);
            winningNumbers.add(winningNumber);
        }

        return winningNumbers;
    }
}
