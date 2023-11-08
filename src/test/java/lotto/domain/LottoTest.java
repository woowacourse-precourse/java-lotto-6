package lotto.domain;

import lotto.domain.Lotto;
import lotto.enums.LottoPrize;
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

    // 아래에 추가 테스트 작성 가능
    @Test
    @DisplayName("당첨 로또 번호와 발행된 로또 번호를 비교하여 등수를 반환")
    void getLottoRank() {
        Integer bonusNumber = 25;
        Lotto userLotto = new Lotto(List.of(1, 5, 10, 15, 20, 25));
        Lotto winningLotto = new Lotto(List.of(1, 5, 10, 15, 20, 30));
        LottoPrize prize = userLotto.getLottoRank(winningLotto, bonusNumber);
        assertThat(prize).isEqualTo(LottoPrize.FIVE_MATCH_BONUS);
    }
}