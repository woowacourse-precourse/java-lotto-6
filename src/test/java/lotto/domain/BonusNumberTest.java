package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class BonusNumberTest {

    private Lotto lotto;

    @BeforeEach
    void setUp() {
        lotto = new Lotto(List.of(10, 11, 12, 13, 14, 15));
    }

    @Test
    void 보너스_번호가_1_미만일_경우_예외를_반환한다() {
        assertThatThrownBy(() -> new BonusNumber(0, lotto))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(DomainException.ERROR.getMessage());
    }

    @Test
    void 보너스_번호가_45_초과일_경우_예외를_반환한다() {
        assertThatThrownBy(() -> new BonusNumber(46, lotto))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(DomainException.ERROR.getMessage());
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 23, 45})
    void 보너스_번호가_1에서_45_사이_숫자라면_예외를_던지지_않는다(int target) {
        assertDoesNotThrow(() -> new BonusNumber(target, lotto));
    }

}
