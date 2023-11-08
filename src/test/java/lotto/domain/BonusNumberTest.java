package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BonusNumberTest {

    private WinNumber winNumber;

    @BeforeEach
    void beforeTest() {
        winNumber = new WinNumber("1,2,3,4,5,6");
    }

    @Test
    @DisplayName("보너스 번호가 1보다 작으면 에러를 발생합니다.")
    void createBonusNumberSmallerThan1() throws Exception {
        String bonusNumber = "0";
        assertThatThrownBy(() -> new BonusNumber(winNumber, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("보너스 번호가 45보다 크면 에러를 발생합니다.")
    void createBonusNumberBiggerThan45() throws Exception {
        String bonusNumber = "46";
        assertThatThrownBy(() -> new BonusNumber(winNumber, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("당첨 번호와 보너스 번호가 겹친다면 에러를 발생합니다.")
    void createBonusNumberDuplicate() throws Exception {
        for (int i = 1; i <= 6; i++) {
            String bonusNumber = String.valueOf(i);
            assertThatThrownBy(() -> new BonusNumber(winNumber, bonusNumber))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }

    @Test
    @DisplayName("당첨 번호와 보너스 번호가 겹치지 않으면서 1과 45 사이면 에러가 발생하지 않습니다.")
    void createBonusNumberNoDuplicate() throws Exception {
        for (int i = 1; i <= 6; i++) {
            String bonusNumber = String.valueOf(i + 6);
            assertThatNoException().isThrownBy(() -> new BonusNumber(winNumber, bonusNumber));
        }
    }
}