package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WinningLottoTest {

    @Test
    @DisplayName("정상적으로 WinningLotto가 생가는지 테스트")
    void testWinningLottoByValidList() {
        Lotto lotto = new Lotto(new ArrayList<>(List.of(1, 2, 3, 4, 5, 6)));
        BonusNumber bonusNumber = new BonusNumber("7");

        WinningLotto winningLotto = new WinningLotto(lotto, bonusNumber);

        assertThat(winningLotto.getWinningLotto())
                .containsExactlyElementsOf(lotto.getNumbers());
        assertThat(winningLotto.getBonusNumber())
                .isEqualTo(bonusNumber.getBonusNumber());
    }

}
