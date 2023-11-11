package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.Ranking;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

class LottoServiceTest {
    private LottoService lottoService;

    @BeforeEach
    void setUp() {
        lottoService = new LottoService();
    }

    @DisplayName("로또 발행 테스트")
    @Test
    void getLottosTest() {
        Integer price = 1000;

        ArrayList<Lotto> lottos = lottoService.getLottos(price, 7, 12);
        assertThat(lottos.get(0).getNumbers().stream()
                .sorted()
                .collect(Collectors.toList())
        ).isEqualTo(new Lotto(List.of(7, 8, 9, 10, 11, 12)).getNumbers());
    }

    @DisplayName("발행된 로또 리스트로 변경 테스트")
    @Test
    void getLottoListTest() {
        ArrayList<Lotto> lottos = new ArrayList<>();
        lottos.add(new Lotto(List.of(1, 6, 5, 4, 3, 2)));
        lottos.add(new Lotto(List.of(12, 10, 9, 8, 11, 7)));

        assertThat(lottoService.getLottoList(lottos)).contains("[1, 2, 3, 4, 5, 6]", "[7, 8, 9, 10, 11, 12");
    }

    @DisplayName("당첨 통계 테스트")
    @Test
    void getWinningStaticTest() {
        ArrayList<Lotto> lottos = new ArrayList<>();
        lottos.add(new Lotto(List.of(1, 6, 5, 4, 3, 2)));
        lottos.add(new Lotto(List.of(12, 10, 9, 8, 11, 7)));

        Integer bonusNumber = 4;
        Lotto winningLotto = new Lotto(List.of(1, 6, 5, 3, 2, 12));

        HashMap<Ranking, Integer> winningStatic = new HashMap<>();
        winningStatic.put(Ranking.SECOND, 1);
        winningStatic.put(Ranking.NOT_PRIZE, 1);

        assertThat(lottoService.getWinningStatic(lottos, winningLotto, bonusNumber)).isEqualTo(winningStatic);
    }

    @DisplayName("당첨 통계 결과 생성 테스트")
    @Test
    void makeWinningStaticResultTest() {
        HashMap<Ranking, Integer> winningStatic = new HashMap<>();
        winningStatic.put(Ranking.SECOND, 1);
        winningStatic.put(Ranking.NOT_PRIZE, 1);

        assertThat(lottoService.makeWinningStaticResult(winningStatic))
                .contains("3개 일치 (5,000원) - 0개",
                        "4개 일치 (50,000원) - 0개",
                        "5개 일치 (1,500,000원) - 0개",
                        "5개 일치, 보너스 볼 일치 (30,000,000원) - 1개",
                        "6개 일치 (2,000,000,000원) - 0개"
                );
    }

    @DisplayName("수익률 계산 테스트")
    @Test
    void getRateOfReturnTest() {
        Integer price = 3000;

        HashMap<Ranking, Integer> winningStatic = new HashMap<>();
        winningStatic.put(Ranking.SECOND, 1);
        winningStatic.put(Ranking.NOT_PRIZE, 1);

        assertThat(lottoService.getRateOfReturn(price, winningStatic)).isEqualTo(30000000 / (double) 3000 * 100);
    }
}