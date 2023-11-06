package lotto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class InputValidateTest {
    @Test
    void 보너스_숫자의_갯수가_1개인지_확인(){
        InputValidate inputValidate = new InputValidate();
        assertThrows(IllegalArgumentException.class, () -> inputValidate.isThereGap(" 1 2"));
        assertThrows(IllegalArgumentException.class, () -> inputValidate.isThereGap("1,2,3"));
        assertThrows(IllegalArgumentException.class, () -> inputValidate.isThereGap(""));
        assertEquals(true, inputValidate.isThereGap("1"));
    }
}
