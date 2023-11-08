package lotto;


import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.WinningRank;
import lotto.domain.dto.BuyLottoInfo;
import lotto.domain.dto.LottoWinResult;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mockStatic;

@DisplayName("LottoService 클래스 테스트")
public class LottoServiceTest {

    LottoService lottoService;

    @BeforeEach
    void setting(){
        lottoService = new LottoService();
    }

    @Test
    @DisplayName("만원이 주어졌을 때 10개의 티켓을 샀는지 확인한다.")
    void makeProperLotto(){
        int money = 10000;
        BuyLottoInfo lottoTickets = lottoService.createLottoTickets(money);

        // 만 원으로 티켓을 삿으므로 10장이 있어야 한다.
        assertThat(lottoTickets.getLottoTicketCount()).isEqualTo(10);
        assertThat(lottoTickets.getUserLottoNumbers().size()).isEqualTo(10);
    }

    @Test
    @DisplayName("등수 당첨 테스트")
    void 등수_당첨_테스트(){
        int money = 5000;

        try(MockedStatic<Randoms> mock = mockStatic(Randoms.class)) {
            mock.when(() ->Randoms.pickUniqueNumbersInRange(anyInt(), anyInt(), anyInt()))
                    .thenReturn(List.of(1,2,3,4,5,6),
                            List.of(1,2,3,4,5,7),
                            List.of(1,2,3,4,5,10),
                            List.of(1,2,3,4,10,20),
                            List.of(1,2,3,10,20,30));

            lottoService.createLottoTickets(money);
            lottoService.createWinningLotto(List.of(1,2,3,4,5,6), 7);
            LottoWinResult lottoWinResult = lottoService.checkWinningLotto();
            Map<WinningRank, Integer> winningRankCount = lottoWinResult.getWinningRankCount();
            assertThat(winningRankCount.get(WinningRank.JACKPOT)).isEqualTo(1);
            assertThat(winningRankCount.get(WinningRank.SECOND_WINNER)).isEqualTo(1);
            assertThat(winningRankCount.get(WinningRank.THIRD_WINNER)).isEqualTo(1);
            assertThat(winningRankCount.get(WinningRank.FOURTH_WINNER)).isEqualTo(1);
            assertThat(winningRankCount.get(WinningRank.FIFTH_WINNER)).isEqualTo(1);
        }

    }


}
