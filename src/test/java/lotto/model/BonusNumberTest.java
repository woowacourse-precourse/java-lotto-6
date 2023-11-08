package lotto.model;

import lotto.util.ErrorMessage;
import lotto.util.exception.CustomException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BonusNumberTest {

    @DisplayName("보너스 번호가 숫자가 아닙니다.")
    @Test
    public void 숫자가_아닌_보너스_번호가_입력된_경우() {
        IllegalArgumentException illegalArgumentException=assertThrows(CustomException.class, () -> {
            new BonusNumber("둘");
        });
        assertEquals(illegalArgumentException.getMessage(), ErrorMessage.WRONG_BONUS_NUMBER_FORMAT.getMessage());
    }

    @DisplayName("보너스 번호가 1-45 범위를 벗어납니다.")
    @Test
    public void 일에서_사십오_범위를_벗어난_보너스_번호가_입력된_경우() {
        IllegalArgumentException illegalArgumentException=assertThrows(CustomException.class, () -> {
            new BonusNumber("48");
        });
        assertEquals(illegalArgumentException.getMessage(), ErrorMessage.WRONG_BONUS_NUMBER_RANGE.getMessage());
    }
}
