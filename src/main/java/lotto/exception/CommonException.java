package lotto.exception;

import lotto.model.Number;
import static lotto.view.ErrorMessage.*;

public class CommonException {
    public static void checkNumberException(int num) throws IllegalArgumentException {
        try {
            Number.checkRange(num);
        } catch (IllegalArgumentException e) {
            outOfBoundExceptionMessage();
            throw new IllegalArgumentException();
        }
    }

}
