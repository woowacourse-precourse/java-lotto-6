package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class WinningNumberTest {

    @DisplayName("당첨 번호에 보너스 번호와 중복된 번호가 있으면 예외 발생")
    @ParameterizedTest
    @MethodSource
    void createWinningNumberByDuplicatedNumbers(Lotto winningLotto, LottoNumber bonusNumber) {

        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> new WinningNumber(winningLotto, bonusNumber));
    }

    public static Stream<Arguments> createWinningNumberByDuplicatedNumbers() {
        return Stream.of(
                Arguments.of(new Lotto(List.of(1, 2, 3, 4, 5, 6)), new LottoNumber(1)),
                Arguments.of(new Lotto(List.of(40, 41, 42, 43, 44, 45)), new LottoNumber(45))
        );
    }

    @DisplayName("당첨 번호를 생성할 수 있다")
    @Test
    void createWinningNumber() {
        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        LottoNumber bonusNumber = new LottoNumber(7);

        WinningNumber winningNumber = new WinningNumber(winningLotto, bonusNumber);


        assertThat(winningNumber.getWinningLotto()).isEqualTo(new Lotto(List.of(1,2,3,4,5,6)));
        assertThat(winningNumber.getBonusNumber()).isEqualTo(new LottoNumber(7));
    }
}
