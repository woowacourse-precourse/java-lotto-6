package lotto.domain.winninglotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import java.util.stream.Stream;
import lotto.domain.lotto.Lotto;
import lotto.domain.ranking.LottoRanking;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class WinningLottoTest {

    @DisplayName("로또 번호들과 보너스 번호로 생성할 수 있다.")
    @Test
    void createByLottoNumbersAndBonusNumberValue() {
        // given
        List<Integer> lottoNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumberValue = 7;

        // when
        WinningLotto winningLotto = WinningLotto.of(lottoNumbers, bonusNumberValue);

        // then
        assertThat(winningLotto).isInstanceOf(WinningLotto.class);
    }

    @DisplayName("입력 받은 로또 번호와 보너스 번호가 유효하지 않다면 예외가 발생한다.")
    @ParameterizedTest(
        name = "[{index}] : lotto = {0}, bonusNumber = {1}, errorMessage = {2}"
    )
    @MethodSource("winningLottoExceptionArgument")
    void createLottoByInvalidRangeNumber(final List<Integer> lottoNumbers,
        final int bonusNumberValue,
        final String errorMessage) {
        // when, then
        assertThatThrownBy(() -> WinningLotto.of(lottoNumbers, bonusNumberValue))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage(errorMessage);
    }

    static Stream<Arguments> winningLottoExceptionArgument() {
        return Stream.of(
            Arguments.of(
                List.of(1, 2, 3, 4, 5, 50),
                10,
                "로또 번호는 1 이상 45 이하여야 합니다."
            ),
            Arguments.of(
                List.of(1, 2, 3, 4, 5, 6, 7),
                10,
                "6개의 숫자로 이루어진 로또 번호를 입력해 주세요."
            ),
            Arguments.of(
                List.of(1, 1, 3, 4, 5, 6),
                10,
                "로또 번호는 중복될 수 없습니다."
            ),
            Arguments.of(
                List.of(1, 2, 3, 4, 5, 6),
                50,
                "보너스 번호는 1 이상 45 이하여야 합니다."
            ),
            Arguments.of(
                List.of(1, 2, 3, 4, 5, 6),
                1,
                "보너스 번호는 로또 번호와 중복될 수 없습니다."
            )
        );
    }

    @DisplayName("입력받은 로또의 등수를 판단한다.")
    @ParameterizedTest(
        name = "[{index}] : winning = {0} | {1}, lotto = {2}. expected = {3}"
    )
    @MethodSource("lottoJudgeArgument")
    void judgeLottoRankingByInputLotto(final List<Integer> winningLottoNumbers,
                                       final int bonusNumberValue,
                                       final List<Integer> lottoNumbers,
                                       final String expected) {
        // given
        WinningLotto winningLotto = WinningLotto.of(winningLottoNumbers, bonusNumberValue);
        Lotto lotto = new Lotto(lottoNumbers);

        // when
        LottoRanking ranking = winningLotto.judge(lotto);

        // then
        assertThat(ranking.name()).isEqualTo(expected);
    }

    static Stream<Arguments> lottoJudgeArgument() {
        return Stream.of(
            Arguments.of(
                List.of(1, 2, 3, 4, 5, 6),
                10,
                List.of(1, 2, 3, 4, 5, 6),
                "FIRST"
            ),
            Arguments.of(
                List.of(1, 2, 3, 4, 5, 6),
                10,
                List.of(1, 2, 3, 4, 5, 10),
                "SECOND"
            ),
            Arguments.of(
                List.of(1, 2, 3, 4, 5, 6),
                10,
                List.of(1, 2, 3, 4, 5, 16),
                "THIRD"
            ),
            Arguments.of(
                List.of(1, 2, 3, 4, 5, 6),
                10,
                List.of(1, 2, 3, 4, 15, 16),
                "FOURTH"
            ),
            Arguments.of(
                List.of(1, 2, 3, 4, 5, 6),
                10,
                List.of(1, 2, 3, 14, 15, 16),
                "FIFTH"
            ),
            Arguments.of(
                List.of(1, 2, 3, 4, 5, 6),
                10,
                List.of(1, 2, 13, 14, 15, 16),
                "UNRANKED"
            ),
            Arguments.of(
                List.of(1, 2, 3, 4, 5, 6),
                10,
                List.of(1, 12, 13, 14, 15, 16),
                "UNRANKED"
            )
        );
    }
}