package lotto.model;

import java.util.Arrays;

import static lotto.utils.Constants.*;

public class WinningNumber {
    private final int[] numbers;
    private final int bonus;

    public WinningNumber(String givenNumbers) {
        String[] _numbersAndBonus = givenNumbers.split(SEPERATOR);

        int[] numbersAndBonus = Arrays.stream(_numbersAndBonus)
                .map((String::trim))
                .map(Integer::parseInt)
                .mapToInt(n -> n).sorted().toArray();

        numbers = Arrays.copyOfRange(numbersAndBonus, 0, LOTTO_DRAW_NUMBER_COUNT);
        bonus = numbersAndBonus[LOTTO_DRAW_NUMBER_COUNT+LOTTO_DRAW_BONUS_NUMBER_COUNT - 1];
    }

    public boolean[] getNumbersExist() {
        boolean[] winningNumbersExist = new boolean[LOTTO_UPPER_BOUND+1];
        Arrays.fill(winningNumbersExist, false);

        for(int number: this.numbers) {
            winningNumbersExist[number] = true;
        }

        return winningNumbersExist;
    }

    public int getBonus() {
        return bonus;
    }
}
