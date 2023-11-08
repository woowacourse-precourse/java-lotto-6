package lotto.model;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class BonusNumberTest {

    @Nested
    @DisplayName("보너스 번호가 범위를 벗어나면 예외가 발생한다.")
    class BonusNumberOutOfRangeTest {

        @DisplayName("범위의 아래 경곗값인 0으로 테스트")
        @Test
        void createBonusNumberByOutOfRangeWithBelowValue() {
            assertThatIllegalArgumentException()
                    .isThrownBy(() -> new BonusNumber(0, List.of(2, 3, 4, 5, 6, 7)))
                    .withMessageContaining("[ERROR]");
        }

        @DisplayName("범위의 위 경곗값인 46으로 테스트")
        @Test
        void createBonusNumberByOutOfRangeWithAboveValue() {
            assertThatIllegalArgumentException()
                    .isThrownBy(() -> new BonusNumber(46, List.of(1, 2, 3, 4, 5, 6)))
                    .withMessageContaining("[ERROR]");
        }
    }

    @DisplayName("보너스 번호가 당첨 번호와 중복되면 예외가 발생한다.")
    @Test
    void createBonusNumberByDuplicateWithWinningNumbers() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new BonusNumber(3, List.of(1, 2, 3, 4, 5, 6)))
                .withMessageContaining("[ERROR]");
    }
}
