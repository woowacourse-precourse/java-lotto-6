package lotto.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningLottoTest {

    @DisplayName("우승 로또와 발행된 로또를 비교하여 순위를 계산한다.")
    @Test
    void calculateRanking() {
        LottoNumber bonusNumber = new LottoNumber(7);
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        WinningLotto winningLotto = new WinningLotto(lotto, bonusNumber);

        Lotto secondLotto = new Lotto(List.of(1, 2, 3, 4, 5, 7));

        assertEquals(Ranking.SECOND, winningLotto.calculateRanking(secondLotto));
    }

    @DisplayName("우승 로또가 보너스 번호를 포함하면 예외가 발생한다.")
    @Test
    void winningLottoContainsBonusNumber_throw_IllegalArgumentException() {
        LottoNumber bonusNumber = new LottoNumber(1);
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        assertThrows(IllegalArgumentException.class, () -> {
            new WinningLotto(lotto, bonusNumber);
        });
    }
}