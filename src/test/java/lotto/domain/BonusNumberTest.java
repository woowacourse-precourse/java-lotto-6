package lotto.domain;

import lotto.exception.lotto.LottoRangeException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BonusNumberTest {

    @DisplayName("보너스 번호는 1 부터 45사이의 숫자여야 한다.")
    @Test
    void createBonusWhenWrongRange() {
        Assertions.assertThatThrownBy(() -> BonusNumber.of(46))
                .isInstanceOf(LottoRangeException.class)
                .hasMessage("로또 번호는 1부터 45 사이의 숫자여야 합니다.");
    }
}