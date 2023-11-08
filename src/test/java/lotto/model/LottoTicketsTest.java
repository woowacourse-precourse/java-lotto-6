package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LottoTicketsTest {
    private LottoTickets lottoTickets;
    private WinningNumbers winningNumbers;
    private BonusNumber bonusNumber;

    @BeforeEach
    void generateLottoTickets() {
        // given
        List<Lotto> lottos = List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(1, 2, 3, 4, 5, 7)),
                new Lotto(List.of(1, 2, 3, 4, 5, 8))
        );
        lottoTickets = new LottoTickets(lottos);
        winningNumbers = new WinningNumbers("1,2,3,4,5,6");
        bonusNumber = new BonusNumber("7", winningNumbers);
    }

    @DisplayName("사용자가 구매한 로또 티켓들의 총 상금 금액을 반환한다.")
    @Test
    void getTotalPrize() {
        // when
        long totalPrize = lottoTickets.getTotalPrize(winningNumbers, bonusNumber);

        // then
        assertThat(totalPrize).isEqualTo(2_031_500_000);
    }

    @DisplayName("사용자가 구매한 로또 티켓들이 당첨되었다면 몇 개씩 당첨되었는지 반환한다.")
    @ParameterizedTest
    @CsvSource(value = {"2_000_000_000:1", "30_000_000:1", "1_500_000:1"}, delimiter = ':')
    void getEachPrize(int prize, long count) {
        // when
        Map<Integer, Long> eachPrize = lottoTickets.getEachPrize(winningNumbers, bonusNumber);

        // then
        assertThat(eachPrize.get(prize)).isEqualTo(count);
    }

    @DisplayName("사용자가 구매한 로또 티켓들은 한 줄씩 문자열 형태로 출력되어야 한다.")
    @Test
    void lottoTicketsToString() {
        // when
        String lottoNumbers = lottoTickets.toString();

        // then
        assertThat(lottoNumbers).isEqualTo(
                """
                        [1, 2, 3, 4, 5, 6]
                        [1, 2, 3, 4, 5, 7]
                        [1, 2, 3, 4, 5, 8]"""
        );
    }
}