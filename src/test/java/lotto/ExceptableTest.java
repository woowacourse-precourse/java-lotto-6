package lotto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import lotto.Controller.Exceptable;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ExceptableTest {

    @DisplayName("1,000원으로 나누어 떨어지지 않는 경우 예외가 발생한다.")
    @Test
    void validateCostByDivided(){
        Exceptable exceptable = new Exceptable();
        assertThrows(IllegalArgumentException.class, () -> exceptable.validateDivided(1100));
        assertEquals(true, exceptable.validateDivided(1000));
    }

}
