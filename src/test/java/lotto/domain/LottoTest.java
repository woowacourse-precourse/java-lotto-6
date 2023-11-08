package lotto.domain;

import java.util.stream.Stream;
import lotto.domain.lotto.Lotto;
import lotto.domain.winning.BonusNumber;
import lotto.domain.winning.LottoNumbers;
import lotto.domain.winning.Rank;
import lotto.domain.winning.WinningNumbers;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(new LottoNumbers("1,2,3,4,5,6,7")))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new Lotto(new LottoNumbers("1,2,3,4,5,5")))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 로또_번호를_알_수_있다() {
        // given
        Lotto lotto = new Lotto(new LottoNumbers("1,2,3,4,5,6"));

        // when
        String actual = lotto.getLottoMessage();

        // then
        Assertions.assertThat(actual).isEqualTo("[1, 2, 3, 4, 5, 6]");
    }

    @ParameterizedTest
    @MethodSource("로또_번호를_비교할_수_있다_파라미터")
    void 로또_번호를_비교할_수_있다(WinningNumbers winningNumbers, Rank expected) {
        // given
        Lotto lotto = new Lotto(new LottoNumbers("1,2,3,4,5,6"));

        // when
        Rank rank = lotto.compare(winningNumbers);

        // then
        Assertions.assertThat(rank).isEqualTo(expected);
    }

    public static Stream<Arguments> 로또_번호를_비교할_수_있다_파라미터() {
        return Stream.of(
                Arguments.of(new WinningNumbers(new LottoNumbers("1,2,3,4,5,6"), new BonusNumber("7")), Rank.FIRST),
                Arguments.of(new WinningNumbers(new LottoNumbers("1,2,3,4,5,7"), new BonusNumber("6")), Rank.SECOND)
        );
    }
}