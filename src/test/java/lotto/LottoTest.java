package lotto;

import lotto.data.Lotto;
import lotto.data.LottoResult;
import lotto.data.WinningNumber;
import lotto.provider.LottoProvider;
import lotto.provider.PrizeProvider;
import lotto.provider.WinningNumberProvider;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구입금액 만큼의 로또를 구매한다.")
    @Test
    void 구입금액_만큼의_로또를_구매한다() {
        //given
        String purchaseAmount = "6000";
        LottoProvider lottoProvider = new LottoProvider();

        //when
        List<Lotto> lottos = lottoProvider.buyLottos(purchaseAmount);

        //then
        assertThat(lottos.size())
                .isEqualTo(6);
    }

    @DisplayName("컴마로 구분된 당첨번호를 정수 리스트 형태로 반환한다.")
    @Test
    void 당첨번호_정수_배열_형태로_반환() {
        //given
        String winningNumberInput = "1,2,3,4,5,6";
        WinningNumberProvider winningNumberProvider = new WinningNumberProvider();

        //when
        List<Integer> winningNumber = winningNumberProvider.getWinningNumber(winningNumberInput);

        //then
        assertThat(winningNumber)
                .isEqualTo(List.of(1, 2, 3, 4, 5, 6));
    }

    @DisplayName("당첨금 결과를 확인한다.")
    @Test
    void 당첨_결과_확인() {
        //given
        Lotto lotto1 = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto lotto2 = new Lotto(List.of(1, 2, 3, 4, 5, 7));
        Lotto lotto3 = new Lotto(List.of(1, 2, 3, 4, 5, 16));
        Lotto lotto4 = new Lotto(List.of(1, 2, 3, 4, 15, 16));
        Lotto lotto5 = new Lotto(List.of(1, 2, 3, 14, 15, 16));
        Lotto lotto6 = new Lotto(List.of(1, 2, 13, 14, 15, 16));
        List<Lotto> lottos = List.of(lotto1, lotto2, lotto3, lotto4, lotto5, lotto6);
        WinningNumber winningNumber = new WinningNumber(List.of(1, 2, 3, 4, 5, 6), 7);
        PrizeProvider prizeProvider = new PrizeProvider();

        //when
        LottoResult lottoResult = prizeProvider.getLottoResult(lottos, winningNumber);
        List<Integer> winningResult = lottoResult.getWinningResult();
        int totalPrize = lottoResult.getTotalPrize();

        //then
        assertThat(winningResult)
                .isEqualTo(List.of(1, 1, 1, 1, 1, 1));
        assertThat(totalPrize)
                .isEqualTo(2031555000);
    }
}