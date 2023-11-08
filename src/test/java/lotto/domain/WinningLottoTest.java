package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.constants.Prize;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WinningLottoTest {

    @DisplayName("값이 유효하면 객체를 생성한다.")
    @Test
    void should_CreateWinningLotto_When_Valid() {
        WinningLotto winLotto = WinningLotto.of(new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new BonusNumber(7, new Lotto(List.of(1, 2, 3, 4, 5, 6))));
        assertThat(winLotto).isNotNull();
    }

    @DisplayName("올바르게 순위를 배정한다.")
    @Test
    void should_RankCorrectPlace() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        WinningLotto winningLotto = WinningLotto.of(lotto, new BonusNumber(10, lotto));
        Lotto fifthPlace = new Lotto(List.of(4, 5, 6, 7, 8, 9));
        assertThat(winningLotto.rankPrize(fifthPlace).getMessage()).isEqualTo(Prize.FIFTH.getMessage());
    }
}
