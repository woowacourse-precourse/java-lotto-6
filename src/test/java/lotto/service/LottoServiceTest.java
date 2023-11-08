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
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LottoServiceTest {
    private LottoService lottoService;

    @ParameterizedTest(name = "{0}원 지불 시, 1000으로 나눈 값인 {1}개 구매")
    @DisplayName("지불한 돈에 따라 로또 티켓을 반환한다.")
    @CsvSource({
            "'1000', 1",
            "'2000', 2",
            "'3000', 3"
    })
    public void should_returnLottoTickets_when_passAmount(String input, int amount) {
        //given & when
        lottoService = new LottoService(new LottoGenerator());
        List<Lotto> issuedLotto = lottoService.issueMultipleLotto(PurchaseAmount.from(input));

        //then
        assertThat(issuedLotto.size()).isEqualTo(amount);
    }

    @Test
    @DisplayName("로또 당첨 결과 확인")
    public void should_returnTotalPrize_when_compareWinning() {
        //given
        lottoService = new LottoService(new TestGenerator(List.of(1, 2, 3, 4, 5, 6)));
        List<Lotto> issuedLotto = lottoService.issueMultipleLotto(PurchaseAmount.from("1000"));
        WinningLotto winningLotto = lottoService.getWinningLotto(getWinning("1,2,3,6,7,8"), getBonus("10"));

        //when
        WinningResult lottoResult = lottoService.getWinningResult(issuedLotto, winningLotto);

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