package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import lotto.exception.ExceptionMessage;

public class InputView {
    public int readAmount() {
        String input = Console.readLine();
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_MONEY_FORMAT.getMessage());
        }
    }

    public List<Integer> readWinningLottoNumbers() {
        String input = Console.readLine();
        String[] split = input.split(",");
        try {
            return Arrays.stream(split)
                    .map(Integer::parseInt)
                    .toList();
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_LOTTO_FORMAT.getMessage());
        }
    }

    public int readBonus() {
        String input = Console.readLine();
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_BONUS_NUMBER_FORMAT.getMessage());
        }
    }
}
