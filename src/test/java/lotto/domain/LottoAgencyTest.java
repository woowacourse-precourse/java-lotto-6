package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoAgencyTest {
    private LottoAgency lottoAgency;
    private List<Integer> winningNumbers;
    private Integer bonusNumber;

    @BeforeEach
    void setUp() {
        lottoAgency = new LottoAgency();
        winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        bonusNumber = 7;
    }

    @Test
    @DisplayName("로또 등수를 계산한다.")
    void calculateLottoRank() {
        // given
        List<Lotto> lottos = new ArrayList<>();

        lottos.add(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6))); // 1등
        lottos.add(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7))); // 2등
        lottos.add(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 45))); // 3등
        lottos.add(new Lotto(Arrays.asList(1, 2, 3, 4, 44, 45))); // 4등
        lottos.add(new Lotto(Arrays.asList(1, 2, 3, 43, 44, 45))); // 5등

        // when
        Map<LottoRank, Integer> result = lottoAgency.calculateLottoRank(lottos, winningNumbers, bonusNumber);

        // then
        assertThat(result.get(LottoRank.FIRST_PLACE)).isEqualTo(1);
        assertThat(result.get(LottoRank.SECOND_PLACE)).isEqualTo(1);
        assertThat(result.get(LottoRank.THIRD_PLACE)).isEqualTo(1);
        assertThat(result.get(LottoRank.FOURTH_PLACE)).isEqualTo(1);
        assertThat(result.get(LottoRank.FIFTH_PLACE)).isEqualTo(1);
    }

    @Test
    @DisplayName("로또 당첨 총 금액을 구한다.")
    void calculateTotalWinningAmount() {
        // given
        Map<LottoRank, Integer> winningResult = new HashMap<>();
        winningResult.put(LottoRank.FIRST_PLACE, 1);
        winningResult.put(LottoRank.SECOND_PLACE, 1);
        winningResult.put(LottoRank.THIRD_PLACE, 1);
        winningResult.put(LottoRank.FOURTH_PLACE, 1);
        winningResult.put(LottoRank.FIFTH_PLACE, 1);

        // when
        long result = lottoAgency.calculateTotalWinningAmount(winningResult);

        // then
        long expected = LottoRank.FIRST_PLACE.getWinningAmount() + LottoRank.SECOND_PLACE.getWinningAmount()
                + LottoRank.THIRD_PLACE.getWinningAmount() + LottoRank.FOURTH_PLACE.getWinningAmount()
                + LottoRank.FIFTH_PLACE.getWinningAmount();

        assertThat(result).isEqualTo(expected);
    }

    @Test
    @DisplayName("수익률을 구한다.")
    void calculateTotalReturnRate() {
        // given
        long winningAmount = 5000L;
        Integer purchasePrice = 1000;

        // when
        double result = lottoAgency.calculateTotalReturnRate(winningAmount, purchasePrice);

        // then
        assertThat(result).isEqualTo((double) 5000 / 1000 * 100);
    }
}
