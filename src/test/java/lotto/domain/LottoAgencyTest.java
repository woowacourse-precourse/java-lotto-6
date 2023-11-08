package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
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
}
