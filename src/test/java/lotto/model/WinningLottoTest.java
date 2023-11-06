package lotto.model;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningLottoTest {


    @DisplayName("로또 두 개를 비교하여 몇 개의 숫자가 일치하는 지 확인한다.")
    @Test
    void createTwoLottoAndCompare() {
        Lotto lotto = LottoGenerator.createLotto(List.of(1, 2, 3, 4, 5, 6));
        WinningLotto winningLotto = new WinningLotto(LottoGenerator.createLotto(List.of(4, 5, 6, 7, 8, 9)),
                new BonusNumber(10));

        assertThat(winningLotto.compareLotto(lotto)).isEqualTo(Rank.FIFTH);
    }


}