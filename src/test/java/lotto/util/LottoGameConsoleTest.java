package lotto.util;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.common.ConsoleTest;
import org.assertj.core.api.ThrowableAssert.ThrowingCallable;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoGameConsoleTest extends ConsoleTest {
    @Nested
    class ReadCostTest {
        @DisplayName("로또 구입 가격을 입력 받을 수 있다")
        @Test
        void success() {
            // given
            setStdin("1000");

            // when
            int cost = LottoGameConsole.readCost();

            // then
            assertThat(cost).isEqualTo(1000);
        }

        @DisplayName("입력을 숫자로 변환할 수 없으면 예외가 발생한다.")
        @Test
        void failToNonNumber() {
            // given
            setStdin("1000k");

            // when
            ThrowingCallable target = () -> LottoGameConsole.readCost();

            // then
            assertThatThrownBy(target).isInstanceOf(NumberFormatException.class);
        }

        @DisplayName("로또 구입 가격 검증 테스트")
        @ParameterizedTest(name = "구입 가격이 {0}이면 예외가 발생한다.")
        @ValueSource(strings = {"0", "999", "11100", "-500", "-1000"})
        void failToValidation(String input) {
            // given
            setStdin(input);

            // when
            ThrowingCallable target = () -> LottoGameConsole.readCost();

            // then
            assertThatIllegalArgumentException().isThrownBy(target);
        }
    }

    @Test
    void readTargetLotto() {
        // given

        // when

        // then
    }

    @Test
    void readBonusNumber() {
        // given

        // when

        // then
    }
}
