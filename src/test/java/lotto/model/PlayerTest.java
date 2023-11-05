package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashMap;
import java.util.Map;
import lotto.constant.LottoPrize;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PlayerTest {
    private static WinningStatistics getWinningStatistics() {
        // 고정된 번호의 로또 생성기
        LottoGenerator lottoGenerator = new LottoNotRandomGenerator();
        LottoMachine lottoMachine = new LottoMachine(lottoGenerator);

        LottoShop lottoShop = new LottoShop(lottoMachine);
        Player player = new Player();
        int budget = 8000;

        player.setBudget(budget);
        // 로또 8000원 어치(8개) 구매
        player.buyLottoTickets(lottoShop);

        // 고정된 당첨 번호
        WinningLotto winningLotto = LottoNotRandomGenerator.winningLotto;
        // 당첨 통계 계산
        player.calculateWinningLottoWithMine(winningLotto);

        return player.getWinningStatistics();
    }

    @DisplayName("player가 계산한 당첨 통계가 예상과 틀리면 테스트에 실패한다.")
    @Test
    void getWinningStatistics_test() {
        // given
        WinningStatistics winningStatistics = getWinningStatistics();
        Map<LottoPrize, Integer> expected = new HashMap<>() {{
            put(LottoPrize.FIRST, 1);   // 1등 1개
            put(LottoPrize.SECOND, 0);   // 2등 0개
            put(LottoPrize.THIRD, 1);   // 3등 1개
            put(LottoPrize.FOURTH, 1);   // 4등 1개
            put(LottoPrize.FIFTH, 3);   // 5등 3개
            put(LottoPrize.NOTHING, 2);   // 꽝 2개
        }};

        // when
        Map<LottoPrize, Integer> prizeCounter = winningStatistics.getPrizeCounter();

        // then
        assertThat(prizeCounter).isEqualTo(expected);
    }
}

