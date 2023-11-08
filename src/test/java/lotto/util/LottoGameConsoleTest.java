package lotto.util;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.common.ConsoleTest;
import lotto.model.Lotto;
import org.assertj.core.api.ThrowableAssert.ThrowingCallable;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoGameConsoleTest extends ConsoleTest {
    @DisplayName("로또 구입 가격 입력 테스트")
    @Nested
    class ReadCostTest {
        @DisplayName("로또 구입 가격을 입력 받는다.")
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

    @DisplayName("당첨 로또 입력 테스트")
    @Nested
    class ReadTargetLottoTest {
        @DisplayName("당첨 로또를 입력 받는다.")
        @Test
        void success() {
            // given
            setStdin("1,2,3,4,5,6");

            // when
            Lotto lotto = LottoGameConsole.readTargetLotto();

            // then
            String expected = "[1, 2, 3, 4, 5, 6]";
            String actual = lotto.toString();

            assertThat(actual).isEqualTo(expected);
        }

        @DisplayName("숫자가 아닌 입력이 있으면 예외가 발생한다.")
        @Test
        void failToNonNumber() {
            // given
            setStdin("1,2,3,4,a,6");

            // when
            ThrowingCallable target = () -> LottoGameConsole.readTargetLotto();

            // then
            assertThatThrownBy(target).isInstanceOf(NumberFormatException.class);
        }

        @DisplayName("번호가 6개가 아니면 예외가 발생한다.")
        @ParameterizedTest(name = "입력 -> {0}")
        @ValueSource(strings = {"1,2,3,4,5", "1,2,3,4,5,6,7"})
        void failToNonSixSize(String input) {
            // given
            setStdin(input);

            // when
            ThrowingCallable target = () -> LottoGameConsole.readTargetLotto();

            // then
            assertThatIllegalArgumentException().isThrownBy(target);
        }

        @DisplayName("중복되는 번호가 있으면 예외가 발생한다.")
        @Test
        void failToDuplicatedNumber() {
            // given
            setStdin("1,2,3,4,5,5");

            // when
            ThrowingCallable target = () -> LottoGameConsole.readTargetLotto();

            // then
            assertThatIllegalArgumentException().isThrownBy(target);
        }

        @DisplayName("범위를 벗어나는 번호가 있으면 예외가 발생한다.")
        @ParameterizedTest(name = "입력 -> {0}")
        @ValueSource(strings = {"1,2,3,4,5,2000000", "-1,2,3,4,5,6"})
        void failToOutOfRangeNumber(String input) {
            // given
            setStdin(input);

            // when
            ThrowingCallable target = () -> LottoGameConsole.readTargetLotto();

            // then
            assertThatIllegalArgumentException().isThrownBy(target);
        }
    }

    @DisplayName("보너스 번호 입력 테스트")
    @Nested
    class ReadBonusNumberTest {
        @DisplayName("보너스 번호를 입력 받는다.")
        @Test
        void success() {
            // given
            setStdin("30");

            // when
            int bonusNumber = LottoGameConsole.readBonusNumber();

            // then
            assertThat(bonusNumber).isEqualTo(30);
        }

        @DisplayName("입력을 숫자로 변환할 수 없으면 예외가 발생한다.")
        @Test
        void failToNonNumber() {
            // given
            setStdin("30k");

            // when
            ThrowingCallable target = () -> LottoGameConsole.readBonusNumber();

            // then
            assertThatThrownBy(target).isInstanceOf(NumberFormatException.class);
        }

        @DisplayName("번호가 범위를 벗어나면 예외가 발생한다.")
        @ParameterizedTest(name = "입력 -> {0}")
        @ValueSource(strings = {"0", "-10", "46"})
        void failToOutOfRangeNumber(String input) {
            // given
            setStdin(input);

            // when
            ThrowingCallable target = () -> LottoGameConsole.readBonusNumber();

            // then
            assertThatIllegalArgumentException().isThrownBy(target);
        }
    }
}
