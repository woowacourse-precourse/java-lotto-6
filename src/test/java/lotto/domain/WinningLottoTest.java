package lotto.domain;

import lotto.enums.Rank;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class WinningLottoTest {

    WinningLotto winningLotto;
    @BeforeEach
    @Test
    void createWinningLotto() {
        winningLotto = WinningLotto.of(Lotto.valueOf(List.of(1,2,3,4,5,6)), LottoNumber.valueOf(7));
    }

    @DisplayName("보너스 번호가 당첨 번호에 포함되면 예외 발생")
    @Test
    void createWinningLottoByContainNumber() {
        assertThatThrownBy(() -> WinningLotto.of(Lotto.valueOf(List.of(1,2,3,4,5,6)), LottoNumber.valueOf(2)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호와 당첨 번호 비교하는 기능")
    @Test
    void match() {
        assertThat(winningLotto.match(Lotto.valueOf(List.of(1,2,3,4,5,6)))).isEqualTo(Rank.FIRST);
        assertThat(winningLotto.match(Lotto.valueOf(List.of(1,2,3,4,5,7)))).isEqualTo(Rank.SECOND);
        assertThat(winningLotto.match(Lotto.valueOf(List.of(1,2,3,4,5,8)))).isEqualTo(Rank.THIRD);
        assertThat(winningLotto.match(Lotto.valueOf(List.of(1,2,3,4,7,8)))).isEqualTo(Rank.FOURTH);
        assertThat(winningLotto.match(Lotto.valueOf(List.of(1,2,3,7,8,9)))).isEqualTo(Rank.FIFTH);
    }
}