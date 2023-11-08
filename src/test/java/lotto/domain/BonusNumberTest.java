package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class BonusNumberTest {

    @DisplayName("당첨 로또 번호와 보너스 번호가 중복되면 오류 발생")
    @Test
    void 로또와_보너스_번호_중복_확인() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        assertThatThrownBy(() -> new BonusNumber(2, lotto))
                .isInstanceOf(IllegalArgumentException.class);
    }
}