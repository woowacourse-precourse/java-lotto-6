package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;

import java.util.EnumMap;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoServiceTest {
    @DisplayName("5천원일 경우 로또 5개를 발행한다.")
    @Test
    void makeFiveWithFiveThousand() {
        //given
        WinningNumbers winningNumbers = mock(WinningNumbers.class);
        Money fiveThousand = new Money(5_000);
        LottoMachine lottoMachine = new LottoMachine();
        RankCounter rankCounter = new RankCounter();
        LottoService lottoService = new LottoService(winningNumbers, lottoMachine, rankCounter);

        //when
        List<Lotto> lottos = lottoService.getLottosWith(fiveThousand);

        //then
        assertThat(lottos).hasSize(5);
    }

    @DisplayName("당첨 내역을 구한다.")
    @Test
    void calculateRankList() {
        //given
        WinningNumbers winningNumbers = LottoFixture.standard();
        List<Lotto> lottos = LottoFixture.all();
        LottoMachine mockMachine = mock(LottoMachine.class);
        RankCounter rankCounter = new RankCounter();
        LottoService lottoService = new LottoService(winningNumbers, mockMachine, rankCounter);

        //when
        EnumMap<Rank, Integer> result = lottoService.rank(lottos);

        //then
        assertThat(result.values()).containsExactly(1, 1, 1, 1, 1, 3);
    }
}
