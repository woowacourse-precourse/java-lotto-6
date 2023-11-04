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
        WinningNumbers winningNumbers = mock(WinningNumbers.class);
        Money fiveThousand = new Money(5_000);
        LottoMachine lottoMachine = new LottoMachine();
        LottoService lottoService = new LottoService(winningNumbers, lottoMachine);
        List<Lotto> lottos = lottoService.getLottosWith(fiveThousand);
        assertThat(lottos).hasSize(5);
    }

    @DisplayName("당첨 내역을 구한다.")
    @Test
    void calculateRankList() {
        //given
        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonus = 7;
        WinningNumbers winningNumbers = new WinningNumbers(winningLotto, bonus);
        List<Lotto> lottos = List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(1, 2, 3, 4, 5, 7)),
                new Lotto(List.of(1, 2, 3, 4, 5, 8)),
                new Lotto(List.of(1, 2, 3, 4, 7, 8)),
                new Lotto(List.of(1, 2, 3, 7, 8, 9)),
                new Lotto(List.of(1, 2, 8, 9, 10, 11)),
                new Lotto(List.of(8, 9, 10, 11, 12, 13))
        );
        LottoMachine mockMachine = mock(LottoMachine.class);
        LottoService lottoService = new LottoService(winningNumbers, mockMachine);

        //when
        EnumMap<Rank, Integer> result = lottoService.rank(lottos);

        //then
        assertThat(result.values()).containsExactly(1, 1, 1, 1, 1, 2);
    }
}
