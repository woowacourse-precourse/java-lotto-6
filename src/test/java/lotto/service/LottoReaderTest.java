package lotto.service;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.List;
import lotto.domain.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoReaderTest {

    @DisplayName("로또 번호를 당첨번호와 비교하여 당첨 금액을 반환한다.")
    @Test
    void getWinningPrize() {
        List<Lotto> lottos = List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(1, 2, 3, 4, 5, 7)),
                new Lotto(List.of(1, 2, 3, 4, 8, 9)));
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        assertThat(new LottoReader(lottos, winningNumbers, 7).getStatistic().getWinningPrize())
                .isEqualTo(2000000000 + 30000000 + 50000);
    }
}
