package lotto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import lotto.exception.LottoGameException;
import lotto.util.Validate;
import org.junit.jupiter.api.Test;

public class InputValidateTest {

    @Test
    void isNumber() {
        String input = "5";
        Long result = Validate.checkLongValidate(input
        );
        assertEquals(Long.valueOf(input), result);
    }

    @Test
    void notNumberException() {
        String input = "as";
        assertThrows(LottoGameException.class, () -> Validate.checkLongValidate(input));
    }
}
