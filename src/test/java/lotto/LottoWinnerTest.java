package lotto;

import lotto.model.Bonus;
import lotto.model.Lotto;
import lotto.model.LottoWinner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoWinnerTest {
    @DisplayName("당첨 로또와 발행 로또를 비교하여 일치하는 숫자의 개수를 반환한다.")
    @Test
    void countSameNumbersWithLotto() {

        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Bonus winningBonus = new Bonus(14);
        LottoWinner.create(winningLotto, winningBonus);

        Lotto purchaseLotto = new Lotto(List.of(1, 2, 11, 12, 13, 14));
        int sameCount = LottoWinner.compareWinningLotto(purchaseLotto);

        assertThat(sameCount).isEqualTo(2);
    }

    @DisplayName("발행 로또에 보너스 번호가 존재하는 경우 0.5를 반환한다.")
    @Test
    void containBonusNumberInLotto() {

        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Bonus winningBonus = new Bonus(14);
        LottoWinner.create(winningLotto, winningBonus);

        Lotto purchaseLotto = new Lotto(List.of(1, 2, 11, 12, 13, 14));
        float sameCount = LottoWinner.compareBonusLotto(purchaseLotto);

        assertThat(sameCount).isEqualTo(0.5f);
    }

    @DisplayName("발행 로또에 보너스 번호가 존재하지 않는 경우 0을 반환한다.")
    @Test
    void notContainsBonusNumberInLotto() {

        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Bonus winningBonus = new Bonus(45);
        LottoWinner.create(winningLotto, winningBonus);

        Lotto purchaseLotto = new Lotto(List.of(1, 2, 11, 12, 13, 14));
        float sameCount = LottoWinner.compareBonusLotto(purchaseLotto);

        assertThat(sameCount).isEqualTo(0);
    }
}
