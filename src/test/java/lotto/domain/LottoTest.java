package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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

    @DisplayName("compare은 당첨번호와 보너스번호를 받아서, 몇 개가 일치하는지 여부를 반환한다.")
    @ParameterizedTest
    @MethodSource("generateLottoNumberAndMatchResult")
    void compareTest(List<Integer> lottoNumbers, List<Integer> winningNumbers, int bonusNumber, int matchCount, boolean matchBonus) {
        // given
        Lotto lotto = new Lotto(lottoNumbers);

        // when
        LottoMatchResult result = lotto.compare(winningNumbers, bonusNumber);

        // then
        assertThat(result.matchCount()).isEqualTo(matchCount);
        assertThat(result.matchBonus()).isEqualTo(matchBonus);
    }

    static Stream<Arguments> generateLottoNumberAndMatchResult() {
        return Stream.of(
                Arguments.of(List.of(1, 2, 3, 4, 5, 6), List.of(1, 2, 4, 8, 16, 32), 7, 3, false),
                Arguments.of(List.of(1, 2, 3, 4, 5, 6), List.of(11, 12, 13, 14, 15, 16), 1, 0, true),
                Arguments.of(List.of(1, 2, 3, 4, 5, 6), List.of(1, 2, 3, 4, 5, 6), 7, 6, false)
        );
    }
}