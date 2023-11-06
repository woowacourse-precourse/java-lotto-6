package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;

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

    @Test
    void 로또_번호의_범위가_1보다_작거나_45보다_클_경우_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(0,1,2,3,4,46)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @MethodSource(value = "provideLottoTestData")
    void 당첨_로또와_비교해_등수를_구한다(Lotto lotto, Ranking result) {
        //given
        WinLotto winLotto = new WinLotto(new Lotto(List.of(1, 2, 3, 4, 5, 6)), new LottoNumber(7));
        //when
        Ranking ranking = lotto.compareWinLotto(winLotto);
        //then
        assertThat(ranking).isEqualTo(result);
    }

    static List<Arguments> provideLottoTestData() {
        return Arrays.asList(
                Arguments.of(new Lotto(List.of(1, 2, 3, 4, 5, 6)), Ranking.FIRST),
                Arguments.of(new Lotto(List.of(1, 2, 3, 4, 5, 7)), Ranking.SECOND),
                Arguments.of(new Lotto(List.of(1, 2, 3, 4, 5, 8)), Ranking.THIRD),
                Arguments.of(new Lotto(List.of(1, 2, 3, 4, 8, 9)), Ranking.FOURTH),
                Arguments.of(new Lotto(List.of(1, 2, 3, 8, 9, 10)), Ranking.FIFTH),
                Arguments.of(new Lotto(List.of(1, 2, 10, 11, 12, 13)), Ranking.NONE)
        );
    }
}