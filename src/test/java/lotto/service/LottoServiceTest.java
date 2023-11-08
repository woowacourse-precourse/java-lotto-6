package lotto.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import lotto.model.Lotto;
import lotto.model.LottoTickets;
import lotto.model.WinningNumbers;
import lotto.model.WinningStatistic;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoServiceTest {
    LottoService lottoService = new LottoService();

    @Test
    @DisplayName("로또 발행 성공")
    void createLottoTickets() {
        LottoTickets lottoTickets = lottoService.createLottoTickets(8);
        assertThat(lottoTickets.getLottoTickets().size()).isEqualTo(8);
    }

    @Test
    @DisplayName("당첨 통계 생성 성공")
    void statisticWinningResult(){
        LottoTickets lottoTickets = new LottoTickets(Arrays.asList(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)), //6
                new Lotto(Arrays.asList(2, 3, 4, 5, 6, 7)), //5+1
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 8)), //5
                new Lotto(Arrays.asList(1, 2, 3, 4, 6, 8)), //5
                new Lotto(Arrays.asList(1, 2, 3, 4, 8, 9)), //4
                new Lotto(Arrays.asList(1, 2, 3, 8, 9, 10)), //3
                new Lotto(Arrays.asList(1, 2, 3, 7, 8, 9)), //3
                new Lotto(Arrays.asList(1, 2, 7, 8, 9, 10)), //2
                new Lotto(Arrays.asList(10, 11, 12, 13, 14, 15)))); //0


        WinningStatistic winningStatistic = lottoService.statisticWinningResult(lottoTickets,
                new WinningNumbers(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)), 7));

        assertAll(() -> {
            assertThat(winningStatistic.threeMatchCount()).isEqualTo(2);
            assertThat(winningStatistic.fourMatchCount()).isEqualTo(1);
            assertThat(winningStatistic.fiveMatchCount()).isEqualTo(2);
            assertThat(winningStatistic.fiveAndBonusMatchCount()).isEqualTo(1);
            assertThat(winningStatistic.sixMatchCount()).isEqualTo(1);
        });


    }
}