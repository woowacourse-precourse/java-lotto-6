package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CompareTest {

    @Test
    @DisplayName("구입한 로또와 당첨 번호 비교 후 등수 확인")
    void 등수_확인() {
        List<Lotto> purchase = new ArrayList<>();
        purchase.add(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        Lotto lucky = new Lotto(List.of(1, 2, 3, 30, 31, 32));
        BonusNumber bonus = new BonusNumber("45", lucky);

        Compare compare = new Compare();
        compare.matchLotto(purchase, lucky, bonus);

        assertThat(compare.getWinningRank().get(4)).isEqualTo(1);
    }

    @Test
    @DisplayName("수익률 포맷 확인")
    void 수익률_포맷_확인() {
        List<Lotto> purchase = new ArrayList<>();
        purchase.add(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        Lotto lucky = new Lotto(List.of(1, 2, 3, 30, 31, 32));
        BonusNumber bonus = new BonusNumber("45", lucky);

        Compare compare = new Compare();
        compare.matchLotto(purchase, lucky, bonus);

        assertThat(compare.caculateProfits(1000)).isEqualTo("500.0");

    }

}