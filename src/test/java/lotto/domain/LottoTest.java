package lotto.domain;

import static lotto.config.GameNumberConfig.LOTTO_RANGE_MAX;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoTest {
    private static final int LOTTO_RANGE_OVER = LOTTO_RANGE_MAX.getValue() + 1;

    @DisplayName("중복된 값으로 생성하는 경우 에러")
    @Test
    void checkLottoDuplicateTest() {
        assertThatThrownBy(() -> new Lotto(List.of(1,2,3,4,5,5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("범위를 넘어가는 값으로 생성하는 경우 에러")
    @Test
    void checkLottoRangeOverTest() {
        assertThatThrownBy(() -> new Lotto(List.of(1,2,3,4,5,LOTTO_RANGE_OVER)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("번호 개수가 안 맞는 경우 에러")
    @Test
    void checkLottoNumberOverTest() {
        assertThatThrownBy(() -> new Lotto(List.of(1,2,3,4,5,6,7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("Lotto 생성 성공")
    @Test
    void createLottoNumberTest() {
        Assertions.assertThatNoException().isThrownBy(
                () -> new Lotto(List.of(1,2,3,4,5,6))
        );
    }

}
