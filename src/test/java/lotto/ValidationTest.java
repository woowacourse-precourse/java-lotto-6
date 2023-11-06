package lotto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import org.junit.jupiter.api.Test;

public class ValidationTest {

    @Test
    void 일에서_45사이의_숫자가_아닌지_확인(){
        Validation validation = new Validation();
        Exception exception = assertThrows(IllegalArgumentException.class, () -> validation.isIn1to45(99));
        assertEquals(exception.getMessage(), "보너스 숫자가 1에서 45사이의 수가 아닙니다.");
    }
}
