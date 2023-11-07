package lotto.domain.utils;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import lotto.domain.model.LottoTicket;
import lotto.domain.model.LottoWinningNumber;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoRankingServiceTest {

    @Test
    @DisplayName("matching된 횟수에 해당하는 등수를 매겨준다.")
    void calculateRanking() {
        //given
        LottoWinningNumber winningNumber = new LottoWinningNumber("1,2,3,4,5,6",7);
        LottoRankingService lottoRankingService = new LottoRankingService(winningNumber);
        LottoTicket ticket = new LottoTicket(List.of(1,2,3,4,5,7));
        //when
        Integer ranking = lottoRankingService.calculateRanking(ticket);
        //then
        Assertions.assertThat(ranking).isEqualTo(2);
    }
}