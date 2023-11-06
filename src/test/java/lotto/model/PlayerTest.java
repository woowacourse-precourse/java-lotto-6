package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.constant.LottoPrize;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PlayerTest {
    LottoGenerator lottoGenerator;
    LottoMachine lottoMachine;
    LottoShop lottoShop;

    @BeforeEach
    void init_environment() {
        // 고정된 번호의 로또 생성기. 8개까지만 생성 가능.
        lottoGenerator = new LottoNotRandomGenerator();
        lottoMachine = new LottoMachine(lottoGenerator);
        lottoShop = new LottoShop(lottoMachine);
    }

    // 로또 구매 테스트
    @DisplayName("player가 로또를 구매한다. 구매한 로또가 테스트에서 설계한 로또 목록와 다르면 테스트에 실패한다.")
    @Test
    void buyLottoTickets_테스트() {
        // given
        Player player = new Player();
        int budget = 8000;
        player.setBudget(budget);
        List<Lotto> expected = ((LottoNotRandomGenerator) lottoGenerator).fixedTickets;

        // when
        player.buyLottoTickets(lottoShop);
        List<Lotto> actual = player.getLottoTickets();

        // then
        assertThat(actual).isEqualTo(expected);
    }

    @DisplayName("player가 계산한 당첨 통계(수익률 제외)가 예상과 틀리면 테스트에 실패한다.")
    @Test
    void 당첨_통계_계산_테스트() {
        // given
        Player player = new Player();
        int budget = 8000;
        player.setBudget(budget);
        // 로또 8000원 어치(8개) 구매
        player.buyLottoTickets(lottoShop);
        // 고정된 당첨 번호
        WinningLotto winningLotto = LottoNotRandomGenerator.winningLotto;
        // 기대되는 당첨 통계
        Map<LottoPrize, Integer> expected = new HashMap<>() {{
            put(LottoPrize.FIRST, 1);   // 1등 1개
            put(LottoPrize.SECOND, 0);   // 2등 0개
            put(LottoPrize.THIRD, 1);   // 3등 1개
            put(LottoPrize.FOURTH, 1);   // 4등 1개
            put(LottoPrize.FIFTH, 3);   // 5등 3개
            put(LottoPrize.NOTHING, 2);   // 꽝 2개
        }};

        // when
        player.calculateWinningLottoWithMine(winningLotto);
        Map<LottoPrize, Integer> actual = player.getWinningStatistics().getPrizeCounter();

        // then
        assertThat(actual).isEqualTo(expected);
    }

    @DisplayName("player가 계산한 수익률이 예상과 틀리면 테스트에 실패한다. (주의: 소수점 둘째자리에서 반올림한 값으로 비교한다.)")
    @Test
    void 수익률_계산_테스트() {
        // given
        Player player = new Player();
        int budget = 8000;
        player.setBudget(budget);
        // 로또 8000원 어치(8개) 구매
        player.buyLottoTickets(lottoShop);
        // 고정된 당첨 번호
        WinningLotto winningLotto = LottoNotRandomGenerator.winningLotto;
        Map<LottoPrize, Integer> expectedPrizeCounter = new HashMap<>() {{
            put(LottoPrize.FIRST, 1);   // 1등 1개
            put(LottoPrize.SECOND, 0);   // 2등 0개
            put(LottoPrize.THIRD, 1);   // 3등 1개
            put(LottoPrize.FOURTH, 1);   // 4등 1개
            put(LottoPrize.FIFTH, 3);   // 5등 3개
            put(LottoPrize.NOTHING, 2);   // 꽝 2개
        }};
        Long expectedSum = 0L;
        for (LottoPrize lottoPrize : expectedPrizeCounter.keySet()) {
            Long count = Long.valueOf(expectedPrizeCounter.get(lottoPrize));
            Long prize = lottoPrize.getPrize();
            expectedSum += prize * count;
        }
        String expected = String.format("%.1f", (double) expectedSum / budget * 100.0);

        // when
        player.calculateWinningLottoWithMine(winningLotto);
        String actual = String.format("%.1f", player.getWinningStatistics().getRateOfReturn());

        // then
        assertThat(actual).isEqualTo(expected);
    }
}

