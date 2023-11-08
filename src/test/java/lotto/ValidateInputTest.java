package lotto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import lotto.Controller.Exceptable;
import lotto.Controller.ValidateInput;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ValidateInputTest {
    private ValidateInput validateInput;
    @BeforeEach
    void setUp(){
        validateInput = new ValidateInput();
    }
    @Test
    void 보너스_숫자의_갯수가_1개인지_확인(){
        assertThrows(IllegalArgumentException.class, () -> validateInput.canNumber(" 1 2"));
        assertThrows(IllegalArgumentException.class, () -> validateInput.canNumber("1,2,3"));
        assertThrows(IllegalArgumentException.class, () -> validateInput.canNumber(""));
        assertEquals("1", validateInput.canNumber("1"));
    }

    @Test
    void String이_int로_리턴되는지_확인(){
        assertEquals(8000, validateInput.validateCost("8000"));
    }

    @Test
    void 여섯개의_숫자가_List로_변환되는지_확인(){
        assertEquals(List.of(1,2,3,4,5,6), validateInput.validateWinningNums("1,2,3,4,5,6"));
    }

    @Test
    void 여섯개의_숫자에_공백이_있는지_확인(){
        assertThrows(IllegalArgumentException.class, () -> validateInput.validateWinningNums("1,2,3 3,4,5 3,6"));
    }

    @Test
    void 당첨번호_숫자_양_끝_공백_처리_확인(){
        assertEquals(List.of(1,2,3,4,5,6), validateInput.validateWinningNums("1, 2, 3, 4, 5, 6"));
        assertEquals(List.of(1,2,3,4,5,6), validateInput.validateWinningNums("1, 2, 3, 4, 5, 6   "));
        assertEquals(List.of(1,2,3,4,5,6), validateInput.validateWinningNums("   1, 2, 3, 4, 5,6"));
        assertEquals(List.of(1,2,3,4,5,6), validateInput.validateWinningNums("1,2,3,4,5, 6"));
    }
}
