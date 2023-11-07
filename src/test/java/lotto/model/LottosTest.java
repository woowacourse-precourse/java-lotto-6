package lotto.model;


import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import lotto.constant.LottoRank;

class LottosTest {
    private List<Lotto> lottos;
    @BeforeEach
    void beforeEach() {
        Lotto lotto1 = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto lotto2 = new Lotto(List.of(2, 3, 4, 5, 6, 7));
        lottos = new ArrayList<>();

        lottos.add(lotto1);
        lottos.add(lotto2);
    }

    @DisplayName("Lottos 생성자 테스트")
    @Test
    void createLottos() {
        Lottos result = new Lottos(lottos);

        assertThat(result.getSize()).isEqualTo(2);
    }

    @DisplayName("Lottos 순위 결정 테스트")
    @Test
    void checkRank() {
        Lottos lottoTicket = new Lottos(lottos);
        WinningNumber winningNumber = new WinningNumber(List.of(1, 2, 3, 4, 5, 6), 7);

        List<LottoRank> lottoRanks = lottoTicket.checkRank(winningNumber);

        assertThat(lottoRanks).containsAll(List.of(LottoRank.RANK_ONE, LottoRank.RANK_TWO));
    }
}