package lotto.model;
import lotto.util.ErrorMessage;
import lotto.util.exception.CustomException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class WinningNumberTest {
    @DisplayName("잘못된 구분자가 입력 되면 예외가 발생 한다.")
    @Test
    public void 잘못된_구분자가_입력된다() {
        IllegalArgumentException illegalArgumentException=assertThrows(CustomException.class, () -> {
            new WinningNumber("1.2,3,4,5,6");
        });
        assertEquals(illegalArgumentException.getMessage(), ErrorMessage.WRONG_WINNING_NUMBER_COUNT.getMessage());
    }

    @DisplayName("구분자는 입력이 올바르지만, 입력 받은 번호가 정수형이 아니다.")
    @Test
    public void 잘못된_자료형의_번호가_입력된다() {
        IllegalArgumentException illegalArgumentException=assertThrows(CustomException.class, () -> {
            new WinningNumber("1,2,3,4,5,육");
        });
        assertEquals(illegalArgumentException.getMessage(), ErrorMessage.WRONG_WINNING_NUMBER_FORMAT.getMessage());
    }

    @DisplayName("입력은 잘 됐지만, 입력 받은 값들이 로또의 조건인 중복 되지 않는다에 어긋 난다.")
    @Test
    public void 중복되는_번호가_입력된다() {
        IllegalArgumentException illegalArgumentException=assertThrows(CustomException.class, () -> {
            new WinningNumber("1,2,3,4,5,5");
        });
        assertEquals(illegalArgumentException.getMessage(), ErrorMessage.LOTTO_MUST_HAVE_NOT_DUPLICATED_NUMBER.getMessage());
    }

    @DisplayName("입력은 잘 됐지만, 입력 받은 값들이 1-45 범위를 초과 한다.")
    @Test
    public void 올바른_로또_범위를_초과한다() {
        IllegalArgumentException illegalArgumentException=assertThrows(CustomException.class, () -> {
            new WinningNumber("1,2,3,4,5,46");
        });
        assertEquals(illegalArgumentException.getMessage(), ErrorMessage.LOTTO_MUST_HAVE_BETWEEN_1_AND_45.getMessage());
    }
}
