package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoEnum;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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

    @DisplayName("로또 번호는 1부터 45여야만 한다.")
    @Test
    void createLottoByIllegalNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 46)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호가 정상적으로 정렬되는지 확인")
    @Test
    void testLottoSorting() {
        Lotto lotto = new Lotto(List.of(6, 5, 4, 3, 2, 1));
        List<Integer> sortedNumbers = lotto.getNumbers();

        assertThat(sortedNumbers).containsExactly(1, 2, 3, 4, 5, 6);
    }

    @DisplayName("로또 번호와 당첨 번호를 비교하여 등수를 반환한다.")
    @Test
    void compareLottoWithWinningNumbers() {
        List<Integer> winNumbers = List.of(1, 2, 3, 4, 5, 6);
        Integer bonusNumber = 7;

        Lotto lotto1 = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        assertThat(lotto1.getRanking(winNumbers, bonusNumber)).isEqualTo(LottoEnum.FIRST);

        Lotto lotto2 = new Lotto(List.of(1, 2, 3, 4, 5, 7));
        assertThat(lotto2.getRanking(winNumbers, bonusNumber)).isEqualTo(LottoEnum.SECOND);

        Lotto lotto3 = new Lotto(List.of(1, 2, 3, 4, 5, 8));
        assertThat(lotto3.getRanking(winNumbers, bonusNumber)).isEqualTo(LottoEnum.THIRD);

        Lotto lotto4 = new Lotto(List.of(1, 2, 3, 4, 8, 9));
        assertThat(lotto4.getRanking(winNumbers, bonusNumber)).isEqualTo(LottoEnum.FOURTH);

        Lotto lotto5 = new Lotto(List.of(1, 2, 3, 4, 7, 8));
        assertThat(lotto5.getRanking(winNumbers, bonusNumber)).isEqualTo(LottoEnum.FOURTH);

        Lotto lotto6 = new Lotto(List.of(1, 2, 3, 8, 9, 10));
        assertThat(lotto6.getRanking(winNumbers, bonusNumber)).isEqualTo(LottoEnum.FIFTH);

        Lotto lotto7 = new Lotto(List.of(1, 2, 3, 7, 8, 9));
        assertThat(lotto7.getRanking(winNumbers, bonusNumber)).isEqualTo(LottoEnum.FIFTH);

        Lotto lotto8 = new Lotto(List.of(1, 2, 7, 8, 9, 10));
        assertThat(lotto8.getRanking(winNumbers, bonusNumber)).isEqualTo(LottoEnum.NOTHING);

        Lotto lotto9 = new Lotto(List.of(1, 2, 8, 9, 10, 11));
        assertThat(lotto9.getRanking(winNumbers, bonusNumber)).isEqualTo(LottoEnum.NOTHING);
    }
}