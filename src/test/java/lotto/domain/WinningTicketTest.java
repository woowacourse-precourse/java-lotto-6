package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class WinningTicketTest {

    @DisplayName("당첨 번호에 보너스 번호와 중복된 번호가 있으면 예외 발생")
    @ParameterizedTest
    @MethodSource
    void createWinningNumberByDuplicatedNumbers(Lotto winningLotto, LottoNumber bonusNumber) {

        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> new WinningTicket(winningLotto, bonusNumber));
    }

    private static Stream<Arguments> createWinningNumberByDuplicatedNumbers() {
        return Stream.of(
                Arguments.of(createLotto(1, 2, 3, 4, 5, 6), new LottoNumber(1)),
                Arguments.of(createLotto(40, 41, 42, 43, 44, 45), new LottoNumber(45))
        );
    }

    @DisplayName("당첨 번호를 생성할 수 있다")
    @Test
    void createWinningNumber() {
        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        LottoNumber bonusNumber = new LottoNumber(7);

        WinningTicket winningTicket = new WinningTicket(winningLotto, bonusNumber);

        assertThat(winningTicket.winningLotto()).isEqualTo(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        assertThat(winningTicket.bonusNumber()).isEqualTo(new LottoNumber(7));
    }

    @DisplayName("로또를 받아 순위를 계산할 수 있다.")
    @ParameterizedTest
    @MethodSource
    void match(WinningTicket winningTicket, Lotto lotto, Rank expected) {
        Rank actual = winningTicket.match(lotto);

        assertThat(actual).isEqualTo(expected);
    }

    private static Stream<Arguments> match() {
        return Stream.of(
                Arguments.of(
                        createWinningTicket(7, 1, 2, 3, 4, 5, 6),
                        createLotto(1, 2, 3, 4, 5, 6),
                        Rank.FIRST),
                Arguments.of(
                        createWinningTicket(7, 1, 2, 3, 4, 5, 6),
                        createLotto(1, 2, 3, 4, 5, 45),
                        Rank.THIRD),
                Arguments.of(
                        createWinningTicket(7, 1, 2, 3, 4, 5, 6),
                        createLotto(7, 8, 9, 10, 11, 12),
                        Rank.NONE)
        );
    }

    private static WinningTicket createWinningTicket(int bonus, Integer... nums) {
        return new WinningTicket(createLotto(nums), new LottoNumber(bonus));
    }

    private static Lotto createLotto(Integer... nums) {
        return new Lotto(Arrays.asList(nums));
    }
}
