package lotto.domain;

import lotto.config.LottoRank;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class WinningNumTest {

    @Test
    @DisplayName("당첨 등수 테스트")
    void compare() {
        WinningNum winningNum = new WinningNum(new ArrayList<>(List.of(1, 2, 3, 4, 5, 6)));
        winningNum.setBonusNumber(7);

        Lotto lotto = new Lotto(List.of(1, 2, 3, 7, 8, 9));
        Assertions.assertThat(winningNum.compare(lotto)).isEqualTo(LottoRank.FIFTH.getNum());
    }
}