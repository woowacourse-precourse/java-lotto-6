package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.*;


class LottoMachineTest {

    @ParameterizedTest
    @CsvSource({"5,5", "10,10", "0,0"})
    @DisplayName("로또 생성개수 확인")
    void createLotto(int amount, int expected) {
        //given
        LottoMachine lottoMachine = new LottoMachine(amount);

        //when
        List<Lotto> lottoPapers = lottoMachine.getLottoPapers();

        //then
        assertThat(lottoPapers.size()).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource({"10000,10", "5000,5", "3000,3"})
    @DisplayName("구매금액 입력시 로또 생성개수 확인")
    void buyLottoAmountTest(int money, int expected) {
        //given
        PurchaseLotto purchaseLotto = new PurchaseLotto(money);

        //when
        LottoMachine lottoMachine = LottoMachine.buyLotto(purchaseLotto);
        List<Lotto> lottoPapers = lottoMachine.getLottoPapers();

        //then
        assertThat(lottoPapers.size()).isEqualTo(expected);
    }
}