package lotto.common;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoExceptionTest {
    @Nested
    @DisplayName("LottoException을 상속받은 예외 클래스는")
    class Describe {
        static class TestLottoException extends LottoException {
            public TestLottoException(String message) {
                super(message);
            }
        }

        @DisplayName("IllegalArgumentException을 상속받는다.")
        @Test
        void isIllegalArgumentException() {
            // given
            String errorMessage = "에러 메시지";

            // when
            TestLottoException lottoException = new TestLottoException(errorMessage);

            // then
            assertThat(lottoException).isInstanceOf(IllegalArgumentException.class);
        }

        @DisplayName("에러 메시지의 접두사에 [ERROR]를 포함한다.")
        @Test
        void containsErrorMessage() {
            // given
            String errorMessage = "에러 메시지";

            // when
            TestLottoException lottoException = new TestLottoException(errorMessage);

            // then
            assertThat(lottoException).hasMessageContaining("[ERROR] 에러 메시지");
        }
    }
}