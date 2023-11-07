package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BonusLottoTest {
    @Test
    void 범위_밖의_번호를_입력_받았을_때_예외_처리() {
        int bonusNumber = 50;

        assertThatThrownBy(() -> new BonusLotto(bonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

}