package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BonusNumberTest {
    @DisplayName("보너스 번호 0일때 예외 테스트")
    @Test
    void 보너스번호를_0이하로_생성() {
        assertThatThrownBy(() -> new BonusNumber(0))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 44일때 정상 테스트")
    @Test
    void 보너스번호를_유효범위내_생성() {
        assertEquals(44, new BonusNumber(44).getBonusNumber());
    }

    @DisplayName("보너스 번호 46일때 예외 테스트")
    @Test
    void 보너스번호를_46이상으로_생성() {
        assertThatThrownBy(() -> new BonusNumber(46))
                .isInstanceOf(IllegalArgumentException.class);
    }
}