package lotto.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.dto.LottoTicket;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LottoServiceTest {
    private LottoService lottoService = new LottoService();

    @DisplayName("발행 로또 정보 DTO 테스트")
    @Test
    void tickets() {
        lottoService.buyTickets(5000);

        List<LottoTicket> dtos = lottoService.tickets();

        assertThat(dtos.size()).isEqualTo(5);
        assertThat(dtos).allSatisfy(dto -> assertThat(dto.numbers()).isSorted());
    }

    @DisplayName("당첨 등수 카운트")
    @ParameterizedTest
    @CsvSource(value = {"FIFTH,1", "FOURTH,0", "THIRD,0", "SECOND,1", "FIRST,1"})
    void countPrize(String prizeName, int prizeCount) {
        List<Lotto> lottos = new ArrayList<>();
        lottos.add(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        lottos.add(new Lotto(List.of(3, 5, 11, 16, 32, 38)));
        lottos.add(new Lotto(List.of(7, 1, 2, 3, 4, 5)));
        lottos.add(new Lotto(List.of(1, 8, 11, 31, 41, 42)));
        lottos.add(new Lotto(List.of(13, 14, 16, 38, 42, 45)));
        lottos.add(new Lotto(List.of(7, 11, 30, 40, 42, 43)));
        lottos.add(new Lotto(List.of(2, 13, 22, 32, 38, 45)));
        lottos.add(new Lotto(List.of(1, 3, 5, 14, 22, 45)));
        lottoService.initPayment(8000);
        lottoService.initLottos(lottos);
        lottoService.initMainNumbers(List.of(1, 2, 3, 4, 5, 6));
        lottoService.initBonusNumber(7);
        lottoService.initWinningNumbers();

        Map<String, Integer> counter = lottoService.getPrizeResult().prizeCount();

        assertThat(counter.get(prizeName)).isEqualTo(prizeCount);
    }

    @DisplayName("당첨 금액 합산")
    @Test
    void sumPrizeMoney() {
        List<Lotto> lottos = new ArrayList<>();
        lottos.add(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        lottos.add(new Lotto(List.of(3, 5, 11, 16, 32, 38)));
        lottos.add(new Lotto(List.of(7, 1, 2, 3, 4, 5)));
        lottos.add(new Lotto(List.of(1, 8, 11, 31, 41, 42)));
        lottos.add(new Lotto(List.of(13, 14, 16, 38, 42, 45)));
        lottos.add(new Lotto(List.of(7, 11, 30, 40, 42, 43)));
        lottos.add(new Lotto(List.of(2, 13, 22, 32, 38, 45)));
        lottos.add(new Lotto(List.of(1, 3, 5, 14, 22, 45)));
        lottoService.initPayment(8000);
        lottoService.initLottos(lottos);
        lottoService.initMainNumbers(List.of(1, 2, 3, 4, 5, 6));
        lottoService.initBonusNumber(7);
        lottoService.initWinningNumbers();

        int prizeMoney = lottoService.getPrizeResult().prizeMoney();

        assertThat(prizeMoney).isEqualTo(2030005000);
    }


}
