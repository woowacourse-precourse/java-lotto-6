package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class WinningNumber {
    private List<Integer> winningNumbers;
    public WinningNumber(String inputWinning) {
        winningNumbers = new ArrayList<>();
        isRightFormat(inputWinning);
        setWinningNumbers(inputWinning);
    }

    public void isRightFormat(String inputWinning) {
        for (String s : inputWinning.split(",")) {
            isInteger(s);
        }
    }

    public void isInteger(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    public void setWinningNumbers(String inputWinning) {
        for (String s : inputWinning.split(",")) {
            winningNumbers.add(Integer.parseInt(s));
        }
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }
}
