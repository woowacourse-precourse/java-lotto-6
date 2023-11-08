package lotto.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class BonusNumberTest {

    Lotto winningNumbers = new Lotto(Arrays.asList(1,2,3,4,5,6));
    @Nested
    @DisplayName("보너스 숫자 입력 예외 테스트")
    class BonusValidateTeset {
        @Test
        void 보너스_숫자는_당첨_번호와_중복돼선_안된다() {
            assertThrows(IllegalArgumentException.class, () -> new BonusNumber(1,winningNumbers));
        }
    }

    @Test
    void 보너스_숫자_입력이_정상적으로_처리되어야_한다() {
        assertDoesNotThrow(()-> new BonusNumber(7,winningNumbers));
    }

}