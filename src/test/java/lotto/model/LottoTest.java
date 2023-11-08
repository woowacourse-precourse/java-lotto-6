package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {

    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> Lotto.from(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> Lotto.from(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 로또_번호의_범위가_1보다_작거나_45보다_클_경우_예외가_발생한다() {
        assertThatThrownBy(() -> Lotto.from(List.of(0, 1, 2, 3, 4, 46)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @MethodSource(value = "provideLottoTestData")
    void compareWinLotto_메서드는_당첨_로또와_비교해_등수를_구한다(Lotto lotto, Ranking result) {
        //given
        WinLotto winLotto = new WinLotto(Lotto.from(List.of(1, 2, 3, 4, 5, 6)), new LottoNumber(7));
        //when
        Ranking ranking = lotto.compareWinLotto(winLotto);
        //then
        assertThat(ranking).isEqualTo(result);
    }

    @Test
    void getNumberValues_메서드는_로또가_가진_숫자들을_반환한다() {
        //given
        Lotto lotto = Lotto.from(List.of(1, 2, 3, 4, 5, 6));
        //when
        List<Integer> numberValues = lotto.getNumberValues();
        //then
        assertThat(numberValues).containsExactly(1, 2, 3, 4, 5, 6);
    }

    //당첨 로또 번호 1,2,3,4,5,6 과 비교할 로또와, 결과 등수 데이터 제공
    static List<Arguments> provideLottoTestData() {
        return Arrays.asList(
                Arguments.of(Lotto.from(List.of(1, 2, 3, 4, 5, 6)), Ranking.FIRST),
                Arguments.of(Lotto.from(List.of(1, 2, 3, 4, 5, 7)), Ranking.SECOND),
                Arguments.of(Lotto.from(List.of(1, 2, 3, 4, 5, 8)), Ranking.THIRD),
                Arguments.of(Lotto.from(List.of(1, 2, 3, 4, 8, 9)), Ranking.FOURTH),
                Arguments.of(Lotto.from(List.of(1, 2, 3, 8, 9, 10)), Ranking.FIFTH),
                Arguments.of(Lotto.from(List.of(1, 2, 10, 11, 12, 13)), Ranking.NONE)
        );
    }
}