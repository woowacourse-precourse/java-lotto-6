package lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class LottoNumscompareTest {

    @DisplayName("로또 번호를 비교한 값이 적절한지 확인하는 테스트")
    @Test
    void testCompareLotto() {
        LottoNumscompare lottoNumscompare = new LottoNumscompare();

        assertThat(lottoNumscompare.compareLotto(List.of(1, 2, 3, 4, 5, 6), List.of(7, 8, 9, 10, 11, 12)))
                .isEqualTo(0);

        assertThat(lottoNumscompare.compareLotto(List.of(1, 2, 3, 4, 5, 6), List.of(2, 7, 9, 10, 11, 12)))
                .isEqualTo(1);
    }
    @DisplayName("로또 번호가 맞은 순서대로 등수가 맞게 들어가는지 확인하는 테스트")
    @Test
    void testWinningRanksUpdate() {
        LottoNumscompare lottoNumscompare = new LottoNumscompare();

        lottoNumscompare.winningRanksUpdate(List.of(1, 2, 3, 4, 5, 6), 6, 7);
        assertThat(lottoNumscompare.getUserWinningRanks().get(1))
                .isEqualTo(1);

        lottoNumscompare.winningRanksUpdate(List.of(1, 2, 3, 4, 5, 6), 5, 6);
        assertThat(lottoNumscompare.getUserWinningRanks().get(2))
                .isEqualTo(1);

        lottoNumscompare.winningRanksUpdate(List.of(1, 2, 3, 4, 5, 6), 5, 8);
        assertThat(lottoNumscompare.getUserWinningRanks().get(3))
                .isEqualTo(1);
    }
    @DisplayName("수익률의 계산값이 정확하게 나오는지 확인하는 테스트")
    @Test
    void testCalculateProfitSummary() {
        LottoNumscompare lottoNumscompare = new LottoNumscompare();
        lottoNumscompare.winningRanksUpdate(List.of(1, 2, 3, 4, 5, 6), 5, 8);
        assertThat(lottoNumscompare.calculateProfitSummary(7000))
                .isEqualTo(21.4);

    }
}
