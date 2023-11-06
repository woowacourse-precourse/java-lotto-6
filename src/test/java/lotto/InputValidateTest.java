package lotto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class InputValidateTest {
    private InputValidate inputValidate;
    @BeforeEach
    void setUp(){
        inputValidate = new InputValidate();
    }
    @Test
    void 보너스_숫자의_갯수가_1개인지_확인(){
        assertThrows(IllegalArgumentException.class, () -> inputValidate.isThereGap(" 1 2"));
        assertThrows(IllegalArgumentException.class, () -> inputValidate.isThereGap("1,2,3"));
        assertThrows(IllegalArgumentException.class, () -> inputValidate.isThereGap(""));
        assertEquals("1", inputValidate.isThereGap("1"));
    }

    @Test
    void String이_int로_리턴되는지_확인(){
        assertEquals(8000, inputValidate.changeInt("8000"));
    }

    @Test
    void 여섯개의개의_숫자가_List로_변환되는지_확인(){
        assertEquals(List.of("1","2","3","4","5","6"), inputValidate.changeList("1,2,3,4,5,6"));
    }
}
