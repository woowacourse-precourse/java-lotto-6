package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BonusNumberTest {

    @Nested
    @DisplayName("보너스 번호가 범위를 벗어나면 예외가 발생한다.")
    class BonusNumberOutOfRangeTest {

        @DisplayName("범위의 아래 경곗값인 0으로 테스트")
        @Test
        void createBonusNumberByOutOfRangeWithBelowValue() {
            assertThatThrownBy(() -> new BonusNumber(0, List.of(2, 3, 4, 5, 6, 7)))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @DisplayName("범위의 위 경곗값인 46으로 테스트")
        @Test
        void createBonusNumberByOutOfRangeWithAboveValue() {
            assertThatThrownBy(() -> new BonusNumber(46, List.of(1, 2, 3, 4, 5, 6)))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }
}
