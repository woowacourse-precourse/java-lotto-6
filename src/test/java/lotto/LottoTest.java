package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import java.util.stream.Stream;
import lotto.domain.Lotto;
import lotto.domain.LottoWinning;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LottoTest {

    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    // 아래에 추가 테스트 작성 가능

    @Test
    void 로또_번호에_1_부터_45_범위를_넘는_값이_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 46)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("유효한 로또 번호가 아닙니다 : 46");
    }

    @Test
    void 당첨_로또에_보너스_번호가_포함되면_예외가_발생한다() {
        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonusNumber = 1;
        assertThatThrownBy(() -> winningLotto.confirmLottoWinning(winningLotto, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("보너스 번호는 당첨 번호에 포함되지 않은 숫자여야 합니다.");
    }

    @Test
    void 유효하지_않은_보너스_번호인_경우_예외가_발생한다() {
        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonusNumber = 46;
        assertThatThrownBy(() -> winningLotto.confirmLottoWinning(winningLotto, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("유효한 로또 번호가 아닙니다 : 46");
    }

    @ParameterizedTest
    @MethodSource("provideLottoArguments")
    void 당첨_로또와_보너스_번호가_주어지면_해당_로또의_당첨_여부를_확인할_수_있다(
            Lotto winningTicket,
            int bonusNumber,
            LottoWinning lottoWinning
    ) {
        Lotto givenLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        assertThat(givenLotto.confirmLottoWinning(winningTicket, bonusNumber))
                .isEqualTo(lottoWinning);
    }

    static Stream<Arguments> provideLottoArguments() {
        return Stream.of(
                Arguments.of(
                        new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                        7,
                        LottoWinning.FIRST
                ),
                Arguments.of(
                        new Lotto(List.of(11, 2, 3, 4, 5, 6)),
                        1,
                        LottoWinning.SECOND
                ),
                Arguments.of(
                        new Lotto(List.of(11, 2, 3, 4, 5, 6)),
                        7,
                        LottoWinning.THIRD
                ),
                Arguments.of(
                        new Lotto(List.of(11, 12, 3, 4, 5, 6)),
                        7,
                        LottoWinning.FOURTH
                ),
                Arguments.of(
                        new Lotto(List.of(11, 12, 13, 4, 5, 6)),
                        7,
                        LottoWinning.FIFTH
                ),
                Arguments.of(
                        new Lotto(List.of(11, 12, 13, 14, 5, 6)),
                        7,
                        LottoWinning.LOSE
                ),
                Arguments.of(
                        new Lotto(List.of(11, 12, 13, 14, 15, 6)),
                        7,
                        LottoWinning.LOSE
                ),
                Arguments.of(
                        new Lotto(List.of(11, 12, 13, 14, 15, 16)),
                        7,
                        LottoWinning.LOSE
                )
        );
    }
}