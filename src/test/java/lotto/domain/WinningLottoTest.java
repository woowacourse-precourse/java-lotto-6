package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

class WinningLottoTest {

    @Nested
    @DisplayName("[WinningLotto] 입력 테스트")
    class WinningLottoSuccessTest {

        static Stream<Arguments> successWinningLotto() {
            return Stream.of(
                    Arguments.of(List.of(1, 2, 3, 4, 5, 6), 7),
                    Arguments.of(List.of(2, 8, 15, 27, 36, 40), 5),
                    Arguments.of(List.of(1, 3, 5, 2, 4, 6), 45)
            );
        }

        @DisplayName("당첨 번호 입력이 정상적인 경우를 확인")
        @ParameterizedTest
        @MethodSource("successWinningLotto")
        void create_당첨_번호_입력이_정상적인_경우를_확인(List<Integer> winningNumbers, Integer bonusNumber) {
            Lotto winningLotto = new Lotto(winningNumbers);
            
            assertThatNoException().isThrownBy(()
                    -> WinningLotto.of(winningLotto, bonusNumber));
        }
    }

    @Nested
    @DisplayName("[WinningLotto] 예외 테스트")
    class WinningLottoExceptionTest {

        @Test
        @DisplayName("당첨 번호가 6개가 아니라면 예외가 발생한다")
        void exception_당첨_번호가_6개가_아니라면_예외가_발생한다() {
            List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5);

            assertThatThrownBy(() -> new Lotto(winningNumbers))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("[ERROR]");
        }

        @Test
        @DisplayName("당첨 번호에 중복이 있으면 예외가 발생한다")
        void exception_당첨_번호에_중복이_있으면_예외가_발생한다() {
            List<Integer> winningNumbers = List.of(1, 2, 2, 4, 5, 6);

            assertThatThrownBy(() -> new Lotto(winningNumbers))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("[ERROR]");
        }

        @Test
        @DisplayName("당첨 번호가 정해진 범위를 벗어나면 예외가 발생한다")
        void exception_당첨_번호가_정해진_범위를_벗어나면_예외가_발생한다() {
            List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 46);
            
            assertThatThrownBy(() -> new Lotto(winningNumbers))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("[ERROR]");
        }

        @DisplayName("보너스 번호가 정해진 범위를 벗어나면 예외가 발생한다")
        @ParameterizedTest
        @ValueSource(ints = {-1, 0, 46})
        void exception_보너스_번호가_정해진_범위를_벗어나면_예외가_발생한다(int bonusNumber) {
            List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
    
            Lotto winningLotto = new Lotto(winningNumbers);

            assertThatThrownBy(() -> WinningLotto.of(winningLotto, bonusNumber))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("[ERROR]");
        }

        @Test
        @DisplayName("당첨 번호와 보너스 번호가 중복되면 예외가 발생한다")
        void exception_당첨_번호와_보너스_번호가_중복되면_예외가_발생한다() {
            List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
            Integer bonusNumber = 1;
    
            Lotto winningLotto = new Lotto(winningNumbers);

            assertThatThrownBy(() -> WinningLotto.of(winningLotto, bonusNumber))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("[ERROR]");
        }
    }

    @Nested
    @DisplayName("[WinningLotto] 기능 테스트")
    class WinningLottoUnitTest {

        @Test
        @DisplayName("로또 번호와 당첨 번호를 비교하여 일치하는 숫자의 수를 센다")
        void contains_로또_번호와_당첨_번호를_비교하여_일치하는_숫자의_수를_센다() {
            List<Integer> lottoNumbers = List.of(1, 2, 3, 4, 5, 6);
            List<Integer> winningLottoNumbers = List.of(1, 2, 3, 7, 8, 9);

            Lotto lotto = new Lotto(lottoNumbers);
            Lotto anotherLotto = new Lotto(winningLottoNumbers);
            
            WinningLotto winningLotto = WinningLotto.of(anotherLotto, 10);

            assertThat(winningLotto.countMatchingNumbers(lotto))
                    .isEqualTo(3);
        }

        @Test
        @DisplayName("로또 번호에 보너스 번호가 포함되어 있는지 확인한다")
        void contains_로또_번호에_보너스_번호가_포함되어_있는지_확인한다() {
            List<Integer> lottoNumbers = List.of(1, 2, 3, 4, 5, 6);
            List<Integer> winningLottoNumbers = List.of(1, 2, 3, 7, 8, 9);

            Lotto lotto = new Lotto(lottoNumbers);
            Lotto anotherLotto = new Lotto(winningLottoNumbers);
            
            WinningLotto winningLotto = WinningLotto.of(anotherLotto, 6);

            assertThat(winningLotto.containsBonusNumber(lotto))
                    .isTrue();
        }
    }
}