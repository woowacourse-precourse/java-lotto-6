package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class WinnerStatisticsTest {

    private Lottos issuedLottos;

    private Lotto winningLotto;

    private int bonusNumber;

    @BeforeEach
    public void setUp() {
        bonusNumber = 7;
        winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        issuedLottos = new Lottos(
                List.of(
                        new Lotto(List.of(1, 2, 3, 4, 5, 6)), // 1등 6
                        new Lotto(List.of(2, 3, 4, 5, 6, 7)), // 2등 5
                        new Lotto(List.of(2, 3, 4, 5, 6, 8)), // 3등 5
                        new Lotto(List.of(3, 4, 5, 6, 7, 8)), // 4등 4
                        new Lotto(List.of(4, 5, 6, 7, 8, 9)), // 5등 3개
                        new Lotto(List.of(5, 6, 7, 8, 9, 10)), // 0등 2개
                        new Lotto(List.of(6, 7, 8, 9, 10, 11)) // 0등 1개
                )
        );
    }

    @DisplayName("당첨자 통계를 집계한 후, toString 값 검증")
    @Test
    public void collectAndToString() throws Exception {
        //given
        WinnerStatistics winnerStatistics = new WinnerStatistics();

        //when
        MatchingResults matchingResults = issuedLottos.matchAll(winningLotto, new LottoNumber(bonusNumber));
        winnerStatistics.collect(matchingResults);

        //then
        Assertions.assertThat(winnerStatistics.toString()).isEqualTo(
                "3개 일치 (5,000원) - 1개\n" +
                        "4개 일치 (50,000원) - 1개\n" +
                        "5개 일치 (1,500,000원) - 1개\n" +
                        "5개 일치, 보너스 볼 일치 (30,000,000원) - 1개\n" +
                        "6개 일치 (2,000,000,000원) - 1개\n"
        );
     }
}
