package lotto.constant;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.Optional;

@DisplayName("우승 단계 열거형에")
class WinningGradeTest {

    @DisplayName("일치하는 숫자 개수에 따른 우승 단계 요청시")
    @Nested
    class ValueOfMatchNum {

        @DisplayName("적합한 개수의 경우 값을 반환한다.")
        @Test
        void existMatchNum() {
            // given
            // when
            final Optional<WinningGrade> result = WinningGrade.valueOfMatchNum(3);

            // then
            assertThat(result).isPresent();
        }

        @DisplayName("적합하지 않은 개수인 경우 empty를 반환한다.")
        @Test
        void invalidMatchNum() {
            // given
            // when
            final Optional<WinningGrade> result = WinningGrade.valueOfMatchNum(10);

            // then
            assertThat(result).isEmpty();
        }
    }
}
