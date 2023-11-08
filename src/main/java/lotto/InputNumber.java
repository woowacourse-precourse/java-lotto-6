package lotto;

import static lotto.Constants.*;

public class InputNumber extends Input {

    protected Integer translateToValueType(String noEmptyReadLine) {
        try {
            return Integer.parseInt(noEmptyReadLine);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(TYPE_ERROR);
        }
    }
}
