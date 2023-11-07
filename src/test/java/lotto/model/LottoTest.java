package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import lotto.constant.LottoRank;

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

    @DisplayName("로또 번호가 1과 45 사이가 아니라면 예외가 발생한다.")
    @Test
    void createLottoByWrongRange() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 46, 5, 4)))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 0, 5, 4)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("내 로또 번호와 당첨 번호를 비교해서 LottoRank를 반환한다.")
    @Test
    void compareMyLottoWithWinningNumber() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        WinningNumber winningNumber = new WinningNumber(List.of(1, 2, 3, 4, 5, 6), 7);

        LottoRank lottoRank = lotto.getRank(winningNumber);

        assertThat(lottoRank).isEqualTo(LottoRank.RANK_ONE);
    }
}