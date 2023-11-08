package inputdata;

import java.util.Arrays;

public class LottoWinningNumberInput {
    private int[] winningNumbers;

    public LottoWinningNumberInput(String[] winningNumbers) {
        setWinningNumbers(winningNumbers);
    }

    private void setWinningNumbers(String[] winningNumbersInput) {
        this.winningNumbers = Arrays.stream(winningNumbersInput)
                .map(String::trim)
                .mapToInt(Integer::parseInt)
                .toArray();
        Arrays.sort(this.winningNumbers);
    }

    public int[] getWinningNumbers() {
        return winningNumbers;
    }

}
