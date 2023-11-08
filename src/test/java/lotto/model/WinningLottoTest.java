package lotto.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class WinningLottoTest {

    private Lotto winningNumbers;
    private Lotto userLotto;
    private WinningLotto winningLotto;
    private int bonusNumber;

    @BeforeEach
    void setUp() {
        winningNumbers = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        bonusNumber = 7;
        winningLotto = new WinningLotto(winningNumbers, bonusNumber);
    }

    @DisplayName("일치하는 번호가 없으면 꼴등이 된다.")
    @Test
    void matchWithNoMatchingNumbers() {
        userLotto = new Lotto(List.of(8, 9, 10, 11, 12, 13));

        LottoRank result = winningLotto.match(userLotto);

        assertThat(result).isEqualTo(LottoRank.NONE);
    }

    @Test
    @DisplayName("보너스 번호가 없는 로또번호 5개 일치는 3등이 된다.")
    void matchWithFiveMatchingNumbers() {
        userLotto = new Lotto(List.of(1, 2, 3, 4, 5, 45));

        LottoRank result = winningLotto.match(userLotto);

        assertThat(result).isEqualTo(LottoRank.THIRD);
    }

    @Test
    @DisplayName("보너스 번호가 있는 로또번호 5개 일치는 2등이 된다.")
    void matchWithFiveMatchingNumbersAndBonus() {
        userLotto = new Lotto(List.of(1, 2, 3, 4, 5, 45));
        winningLotto = new WinningLotto(winningNumbers, 45);

        LottoRank result = winningLotto.match(userLotto);

        assertThat(result).isEqualTo(LottoRank.SECOND);
    }

    @Test
    @DisplayName("모든 숫자가 일치하면 1등이 된다.")
    void matchWithAllMatchingNumbers() {
        userLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        LottoRank result = winningLotto.match(userLotto);

        assertThat(result).isEqualTo(LottoRank.FIRST);
    }
}