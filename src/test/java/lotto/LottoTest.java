package lotto;

import lotto.model.Lotto;
import lotto.model.PlayerNumber;
import lotto.model.Rank;
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

    @DisplayName("로또를 생성하면 정렬된다.")
    @Test
    void createLottoWithSort() {
        Lotto lotto = new Lotto(List.of(6, 5, 4, 3, 2, 1));
        assertThat(lotto.getNumbers()).isEqualTo(List.of(1, 2, 3, 4, 5, 6));
    }

    @DisplayName("로또 번호와 당첨 번호를 비교한다. 5개 일치")
    @Test
    void compareLottoWithPlayerNumberIsRankThird() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        List<Integer> winning = List.of(1, 2, 3, 4, 5, 7);
        int bonus = 8;
        PlayerNumber player = new PlayerNumber(winning, bonus);

        assertThat(lotto.compare(player)).isEqualTo(Rank.THIRD);
    }

    @DisplayName("로또 번호와 당첨 번호를 비교한다. 5개 일치, 보너스 번호 일치")
    @Test
    void compareLottoWithPlayerNumberIsRankSecond() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        List<Integer> winning = List.of(1, 2, 3, 4, 5, 7);
        int bonus = 6;
        PlayerNumber player = new PlayerNumber(winning, bonus);

        assertThat(lotto.compare(player)).isEqualTo(Rank.SECOND);
    }
}