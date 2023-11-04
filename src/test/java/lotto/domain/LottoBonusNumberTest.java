package lotto.domain;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Arrays;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoBonusNumberTest {
    @Test
    @DisplayName("보너스 넘버가 정상적으로 생성된다.")
    public void createBonusNumberTest() {
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        int bonusNumber = 7;

        assertDoesNotThrow(() -> LottoBonusNumber.validateLottoNumDuplicate(lotto, bonusNumber));
    }

    @Test
    @DisplayName("보너스 넘버가 중복일 경우 에러반환.")
    public void bonusNumberDuplicateTest() {
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        int bonusNumber = 6;

        IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
                () -> LottoBonusNumber.validateLottoNumDuplicate(lotto, bonusNumber));

        assertEquals(LottoBonusNumber.BONUS_NUMBER_VALID_LOG, e.getMessage());
    }
}