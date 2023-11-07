package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.Domain.Bonus;
import lotto.Domain.Lotto;
import lotto.Util.LottoComparator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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

    @DisplayName("로또 비교 테스트")
    @Test
    void compareLotto() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto userLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        assertThat(LottoComparator.getMatchCount(lotto, userLotto)).isEqualTo(6);
    }

    @DisplayName("보너스 비교 테스트")
    @Test
    void compareBonus() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto userLotto = new Lotto(List.of(1, 2, 3, 7, 8, 9));
        Bonus bonus = new Bonus("4");
        assertThat(LottoComparator.getMatchBonus(lotto, bonus)).isEqualTo(true);
    }
}
