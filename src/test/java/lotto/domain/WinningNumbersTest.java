package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class WinningNumbersTest {
    static Stream<Arguments> provideWinningNumbersWithDuplicateBonusNumber() {
        return Stream.of(
                Arguments.of(List.of(1, 2, 3, 4, 5, 6), 1),
                Arguments.of(List.of(45, 44, 43, 42, 41, 40), 42)
        );
    }

    @ParameterizedTest
    @MethodSource("provideWinningNumbersWithDuplicateBonusNumber")
    void 보너스_번호가_당첨_번호에_포함되면_예외를_발생시킨다(List<Integer> winningNumbers, int bonusNumber) {
        // given
        Lotto winningLotto = new Lotto(winningNumbers);
        LottoNumber bonusLottoNumber = LottoNumber.valueOf(bonusNumber);

        // when & then
        assertThatThrownBy(() -> new WinningNumbers(winningLotto, bonusLottoNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 보너스 번호는 당첨 번호에 포함될 수 없습니다.");
    }

    static Stream<Arguments> provideValidWinningNumbers() {
        return Stream.of(
                Arguments.of(List.of(1, 2, 3, 4, 5, 6), 7),
                Arguments.of(List.of(45, 44, 43, 42, 41, 40), 39)
        );
    }

    @ParameterizedTest
    @MethodSource("provideValidWinningNumbers")
    void 올바른_당첨_번호로_당첨_번호를_생성할_수_있다(List<Integer> winningNumbers, int bonusNumber) {
        // given
        Lotto winningLotto = new Lotto(winningNumbers);
        LottoNumber bonusLottoNumber = LottoNumber.valueOf(bonusNumber);

        // when & then
        assertThatCode(() -> new WinningNumbers(winningLotto, bonusLottoNumber))
                .doesNotThrowAnyException();
    }
}
