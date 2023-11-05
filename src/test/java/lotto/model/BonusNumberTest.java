package lotto.model;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class BonusNumberTest {

    @Test
    void 보너스_번호가_범위를_벗어난_경우_예외_처리한다() {
        int input = 0;

        assertThatThrownBy(() -> new BonusNumber(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 1 ~ 45 사이의 숫자를 입력해야 합니다.");
    }
}