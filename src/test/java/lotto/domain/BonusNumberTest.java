package lotto.domain;

import static lotto.config.GameNumberConfig.LOTTO_RANGE_MAX;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BonusNumberTest {
    private static final int LOTTO_RANGE_OVER = LOTTO_RANGE_MAX.getValue() + 1;

    private final Lotto lotto = new Lotto(List.of(1,2,3,4,5,6));

    @DisplayName("number가 lotto와 중복인 경우 에러")
    @Test
    void checkDuplicateTest() {
        assertThatThrownBy(() -> new BonusNumber(lotto, 1))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("number가 범위를 넘어가는 경우 에러")
    @Test
    void checkRangeOverTest() {
        assertThatThrownBy(() -> new BonusNumber(lotto, LOTTO_RANGE_OVER))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("BonusNumber 생성 성공")
    @Test
    void createLottoNumberTest() {
        Assertions.assertThatNoException().isThrownBy(
                () -> new BonusNumber(lotto, 7)
        );
    }
}
