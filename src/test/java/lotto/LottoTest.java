package lotto;

import lotto.domain.Lotto;
import lotto.domain.Rank;
import lotto.dto.AnswerLotto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

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
    void 당첨번호를_가지고_등수를_알수있다(){
        //given
        AnswerLotto answerLotto = new AnswerLotto(Arrays.asList(1, 2, 3, 4, 5, 6), 7);
        Lotto lotto1 = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        Lotto lotto2 = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7));
        Lotto lotto3 = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 8));
        Lotto lotto4 = new Lotto(Arrays.asList(1, 2, 3, 4, 10, 11));
        Lotto lotto5 = new Lotto(Arrays.asList(1, 2, 3, 10, 11, 12));
        Lotto lotto6 = new Lotto(Arrays.asList(1, 2, 10, 11, 12, 13));

        //when
        Rank rank1 = lotto1.calculateLottoWinnings(answerLotto);
        Rank rank2 = lotto2.calculateLottoWinnings(answerLotto);
        Rank rank3 = lotto3.calculateLottoWinnings(answerLotto);
        Rank rank4 = lotto4.calculateLottoWinnings(answerLotto);
        Rank rank5 = lotto5.calculateLottoWinnings(answerLotto);
        Rank rank6 = lotto6.calculateLottoWinnings(answerLotto);
        //then
        Assertions.assertThat(rank1).isEqualTo(Rank.FIRST_PLACE);
        Assertions.assertThat(rank2).isEqualTo(Rank.SECOND_PLACE);
        Assertions.assertThat(rank3).isEqualTo(Rank.THIRD_PLACE);
        Assertions.assertThat(rank4).isEqualTo(Rank.FOURTH_PLACE);
        Assertions.assertThat(rank5).isEqualTo(Rank.FIFTH_PLACE);
        Assertions.assertThat(rank6).isEqualTo(Rank.NOTHING);

    }
}