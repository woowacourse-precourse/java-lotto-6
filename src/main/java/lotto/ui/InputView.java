package lotto.ui;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import lotto.domain.ErrorMessage;

public class InputView {
    public InputView() {
    }

    public Long readMoney() {
        try {
            return Long.valueOf(Console.readLine());
        } catch (Exception ex) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_INPUT_ERROR.getValue());
        }
    }

    public List<Integer> readWinningNumbers() {
        try {
            return Arrays.stream(Console.readLine().split(","))
                .map(Integer::valueOf)
                .toList();
        } catch (Exception ex) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_INPUT_ERROR.getValue());
        }
    }

    public int readBonusNumber() {
        try {
            return Integer.parseInt(Console.readLine());
        } catch (Exception ex) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_INPUT_ERROR.getValue());
        }
    }
}
