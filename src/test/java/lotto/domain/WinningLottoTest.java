package lotto.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningLottoTest {

    @DisplayName("맞춘 로또 번호 갯수를 반환한다.")
    @Test
    void getMatchedCountCompareTo() {
        Lotto boughtLotto = Lotto.of(List.of(1, 2, 3, 4, 5, 6));
        WinningLotto winningLotto = WinningLotto.of(Lotto.of(List.of(1, 2, 3, 4, 5, 6)), BonusBall.valueOf(23));

        assertThat(6).isEqualTo(winningLotto.getMatchedCountCompareTo(boughtLotto));
    }

    @DisplayName("보너스 번호 맞춤 여부를 반환한다.")
    @Test
    void isBonusNumMatchedTo() {
        Lotto boughtLotto = Lotto.of(List.of(1, 2, 3, 4, 5, 6));
        WinningLotto winningLotto = WinningLotto.of(Lotto.of(List.of(1, 2, 3, 4, 5, 6)), BonusBall.valueOf(23));

        assertThat(winningLotto.isBonusNumMatchedTo(boughtLotto)).isFalse();
    }
}