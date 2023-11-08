package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LottoStatisticTest {

    private LottoStatistic lottoStatistic;

    private final List<Lotto> issueLottos = new ArrayList<>();

    @BeforeEach
    void 초기_값_세팅() {
        WinningLotto winningLotto = new WinningLotto(List.of(1, 2, 3, 4, 5, 6), 7);
        issueLottos.add(new Lotto(List.of(1, 2, 3, 4, 5, 6)));    // 1등
        issueLottos.add(new Lotto(List.of(1, 2, 3, 4, 5, 7)));    // 2등
        issueLottos.add(new Lotto(List.of(1, 2, 3, 4, 5, 8)));    // 3등
        issueLottos.add(new Lotto(List.of(1, 2, 3, 8, 9, 10)));   // 5등
        issueLottos.add(new Lotto(List.of(1, 2, 6, 8, 9, 10)));   // 5등
        lottoStatistic = new LottoStatistic(issueLottos, winningLotto);
    }

    @Test
    @DisplayName("당첨 통계 업데이트 테스트")
    void 당첨_통계_업데이트_테스트() {
        Map<LottoGrade, Integer> result = lottoStatistic.getResult();

        Integer first = result.get(LottoGrade.FIRST);
        Integer second = result.get(LottoGrade.SECOND);
        Integer third = result.get(LottoGrade.THIRD);
        Integer fourth = result.get(LottoGrade.FOURTH);
        Integer fifth = result.get(LottoGrade.FIFTH);

        Assertions.assertThat(first).isEqualTo(1);
        Assertions.assertThat(second).isEqualTo(1);
        Assertions.assertThat(third).isEqualTo(1);
        Assertions.assertThat(fourth).isEqualTo(0);
        Assertions.assertThat(fifth).isEqualTo(2);
    }

    @Test
    @DisplayName("총 수익률 구하기 테스트")
    void 총_수익률_구하기() {
        int purchaseAmount = 20000000;
        double returnRate = lottoStatistic.getAllReturnRate(purchaseAmount);

        Assertions.assertThat(returnRate).isEqualTo(((double) 2031510000 / purchaseAmount) * 100);
    }
}
