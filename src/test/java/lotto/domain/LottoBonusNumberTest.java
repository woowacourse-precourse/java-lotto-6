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
        LottoBonusNumber lottoBonusNumber = new LottoBonusNumber("7");

        assertDoesNotThrow(() -> LottoBonusNumber.validateLottoNumDuplicate(lotto, lottoBonusNumber));
    }

    @Test
    @DisplayName("보너스 넘버가 중복일 경우 에러반환.")
    public void bonusNumberDuplicateTest() {
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        LottoBonusNumber lottoBonusNumber = new LottoBonusNumber("6");

        IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
                () -> LottoBonusNumber.validateLottoNumDuplicate(lotto, lottoBonusNumber));

        assertEquals(LottoBonusNumber.BONUS_NUMBER_VALID_LOG, e.getMessage());
    }
}