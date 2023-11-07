package lotto.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.constants.WinningType;
import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.dto.PurchaseAmount;
import lotto.dto.WinningLotto;
import lotto.dto.WinningResult;
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
        List<Lotto> lottos = lottoService.buyMultipleLotto(PurchaseAmount.from("2000"));

        //then
        assertThat(lottos.size()).isEqualTo(2);
    }

    @Test
    @DisplayName("로또 당첨 결과 확인")
    public void checkWinningResult() {
        //given
        lottoService = new LottoService(new TestNumberGenerator(List.of(1, 2, 3, 4, 5, 6)));
        lottoService.buyMultipleLotto(PurchaseAmount.from("1000"));
        WinningLotto winningLotto = lottoService.getWinningLotto(getWinning("1,2,3,6,7,8"), getBonus("10"));

        //when
        WinningResult lottoResult = lottoService.getLottoResult(winningLotto);

        //then
        assertThat(lottoResult.getTotalPrize()).isEqualTo(WinningType.FOUR.calculateProfit(1));
    }


    private Lotto getWinning(String input) {
        return new Lotto(input);
    }

    private LottoNumber getBonus(String input) {
        return LottoNumber.from(input);
    }
}