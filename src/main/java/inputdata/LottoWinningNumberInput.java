package inputdata;

import java.util.Arrays;

public class LottoWinningNumberInput {
    private int[] winningNumbers;

    public LottoWinningNumberInput(int[] winningNumbers) {
        this.winningNumbers = winningNumbers;
    }

    public int[] setWinningNumbers(String[] winningNumbersInput) {
        this.winningNumbers = Arrays.stream(winningNumbersInput)
                .map(String::trim)
                .mapToInt(Integer::parseInt)
                .toArray();
        Arrays.sort(this.winningNumbers);

        return this.winningNumbers;
    }

    public int[] getWinningNumbers() {
        return winningNumbers;
    }

}
