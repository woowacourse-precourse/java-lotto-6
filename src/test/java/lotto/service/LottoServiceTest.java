package lotto.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.domain.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoServiceTest {
    private LottoService lottoService = new LottoService(new RandomNumberGenerator());

    @Test
    @DisplayName("구매 개수를 전달했을 때, 해당 개수만큼의 로또 티켓을 반환한다.")
    public void should_returnLottoTickets_when_passAmount() {
        //given
        String money = "2000";

        //when
        List<Lotto> lottos = lottoService.buyMultipleLotto(money);

        //then
        assertThat(lottos.size()).isEqualTo(2);
        assertThat(lottos.get(0).getNumbers().size()).isEqualTo(6);
        assertThat(lottos.get(1).getNumbers().size()).isEqualTo(6);
    }

    @Test
    @DisplayName("로또 당첨 결과 확인")
    public void checkWinningResult() {
        //given
        lottoService = new LottoService(new TestNumberGenerator(List.of(1, 2, 3, 4, 5, 6)));
        lottoService.buyMultipleLotto("1000");
        lottoService.getWinningLotto("1,2,3,6,7,8", "10");

        //when
//        WinningResult lottoResult = lottoService.getLottoResult();

        //then
        System.out.println();
    }
}