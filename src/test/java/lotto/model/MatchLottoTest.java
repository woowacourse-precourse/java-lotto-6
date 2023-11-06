package lotto.model;


import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class MatchLottoTest {

    @Test
    void 당첨_번호_확인() {
        MatchLotto matchLotto = new MatchLotto();
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;
        List<Lotto> purchaseHistory = new ArrayList<>();
        purchaseHistory.add(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        purchaseHistory.add(new Lotto(List.of(1, 2, 3, 4, 5, 7)));
        purchaseHistory.add(new Lotto(List.of(1, 2, 3, 4, 5, 8)));
        purchaseHistory.add(new Lotto(List.of(1, 2, 3, 4, 7, 8)));

        matchLotto.matchLotto(winningNumbers, bonusNumber, purchaseHistory);

        assertThat(matchLotto.getWinningMatchResult()).isEqualTo(List.of(6, 5, 5, 4));
        assertThat(matchLotto.getBonusMatchResult()).isEqualTo(List.of(false, true, false, true));
    }
}