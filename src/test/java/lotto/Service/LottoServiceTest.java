package lotto.Service;

import static lotto.Util.Constants.PERCENT;

import java.util.List;
import lotto.Domain.Lotto;
import lotto.Domain.Rank;
import lotto.Domain.WinningResult;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class LottoServiceTest {
    LottoService lottoService;

    @BeforeEach
    void setUp() {
        lottoService = new LottoService();
    }

    @DisplayName("입력 금액을 1,000 단위로 나눈 갯수 만큼 로또를 구매한다.")
    @Test
    void purchaseLottoTest() {
        //given
        int money = 10000;

        //when
        List<Lotto> purchaseLotto = lottoService.purchaseLotto(money);

        //then
        Assertions.assertThat(purchaseLotto.size()).isEqualTo(10);
    }

    @DisplayName("1,000원으로 나누어 떨어지지 않는 금액으로 서비스를 호출하면 예외가 발생한다.")
    @Test
    void purchaseLottoByInvalidMoneyTest() {
        //given
        int money = 10111;

        //when

        //then
        Assertions.assertThatThrownBy(() -> lottoService.purchaseLotto(money))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("중복된 숫자가 포함된 당첨번호로 당첨로또를 생성하면 예외가 발생한다.")
    @Test
    void createWinningLottoByDuplicateNumbers() {
        //given
        List<Integer> duplicatedNumbers = List.of(1, 2, 3, 4, 5, 5);
        int bonusNum = 6;

        //when

        //then
        Assertions.assertThatThrownBy(() -> lottoService.createWinningLotto(duplicatedNumbers, bonusNum)).isInstanceOf(
                IllegalArgumentException.class);

    }

    @DisplayName("당첨 번호에 포함된 보너스번호로 당첨로또를 생성하면 예외가 발생한다.")
    @Test
    void createWinningLottoByDuplicateBonusNumber() {
        //given
        List<Integer> duplicatedNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNum = 6;

        //when

        //then
        Assertions.assertThatThrownBy(() -> lottoService.createWinningLotto(duplicatedNumbers, bonusNum)).isInstanceOf(
                IllegalArgumentException.class);

    }


    @Nested
    @DisplayName("당첨 번호와 보너스 번호가 생성되었을 때")
    class createResultTest {
        List<Lotto> purchaseLotto;
        List<Integer> winningNumber;
        int bonusNumber = 1;

        @DisplayName("당첨 번호가 모두 같은 로또가 한 개 이상 있으면 FIRST RANK 를 한 개 이상 가진다")
        @Test
        void createResult() {
            //given
            purchaseLotto = lottoService.purchaseLotto(5000);
            winningNumber = purchaseLotto.get(0).getNumbers();
            while (winningNumber.contains(bonusNumber)) {
                bonusNumber++;
            }
            lottoService.createWinningLotto(winningNumber, bonusNumber);

            //when
            WinningResult result = lottoService.createResult();

            //then
            Assertions.assertThat(result.result().get(Rank.FIRST) >= 1).isTrue();
        }

        @DisplayName("구매한 로또 갯수만큼 당첨 결과가 생성된다.")
        @Test
        void createResultOfLottoNum() {
            //given
            purchaseLotto = lottoService.purchaseLotto(5000);
            winningNumber = List.of(1, 2, 3, 4, 5, 6);
            bonusNumber = 7;
            lottoService.createWinningLotto(winningNumber, bonusNumber);

            //when
            WinningResult result = lottoService.createResult();
            int resultCount = 0;
            for (Rank key : result.result().keySet()) {
                resultCount += result.result().get(key);
            }

            //then
            Assertions.assertThat(resultCount).isEqualTo(purchaseLotto.size());
        }
        @DisplayName("로또 수익률은 상금을 구매금액으로 나눈 값의 100%이다. ")
        @Test
        void getRevenue() {
            //given
            purchaseLotto = lottoService.purchaseLotto(1000);
            winningNumber = purchaseLotto.get(0).getNumbers();
            while (winningNumber.contains(bonusNumber)) {
                bonusNumber++;
            }
            lottoService.createWinningLotto(winningNumber, bonusNumber);

            //when
            WinningResult result = lottoService.createResult();
            double revenue = lottoService.getRevenue();

            //then
            Assertions.assertThat(revenue).isEqualTo(result.getIncome()/1000*PERCENT);
        }
    }
}