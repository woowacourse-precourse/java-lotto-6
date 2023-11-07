package lotto;

import static org.junit.jupiter.api.Assertions.*;

import lotto.view.ValidationView;
import org.junit.jupiter.api.Test;

public class InputValidationTest {
    @Test
    void 구매_금액_입력_테스트(){
        assertThrows(IllegalArgumentException.class, () -> {
            ValidationView.isDivided("1500");
        });
    }
}
