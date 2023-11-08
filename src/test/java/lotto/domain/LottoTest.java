package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lotto.common.LottoWinnerTable;

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
    void 로또끼리_번호_비교를_위해_List_반환_필요() {
        // given
        List<Integer> givenNumbers = List.of(1, 2, 3, 4, 5, 6);
        Lotto givenLotto = new Lotto(givenNumbers);
        // when
        List<Integer> numbers = givenLotto.getNumbers();

        // then
        assertThat(numbers).isEqualTo(givenNumbers);
    }

    @Test
    void 입력받은_당첨번호로_로또번호를_생성가능해야_함() {
        // given
        List<Integer> givenNumbers = List.of(1, 2, 3, 4, 5, 6);
        String givenStringNumber = "1,2,3,4,5,6";
        // when
        Lotto lotto = Lotto.fromString(givenStringNumber);
        List<Integer> numbers = lotto.getNumbers();

        // then
        assertThat(numbers).isEqualTo(givenNumbers);
    }

    @Test
    void 몇_등_당첨되었는지_반환_필요() {
        // given
        Lotto givenLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto givenWinnerLotto = new Lotto(List.of(1, 2, 3, 4, 5, 7));
        BonusNumber givenBonusNumber = BonusNumber.fromStringWitValidateWinningNumber("6",
                givenWinnerLotto.getNumbers());
        LottoWinnerTable givenWinner = LottoWinnerTable.SECOND;
        // when
        LottoWinnerTable winnerResult = givenLotto.compareWinningNumber(givenWinnerLotto, givenBonusNumber);

        // then
        assertThat(winnerResult).isEqualTo(givenWinner);
    }
}