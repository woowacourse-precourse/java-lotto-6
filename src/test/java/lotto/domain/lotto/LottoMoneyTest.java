package lotto.domain.lotto;

import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class LottoMoneyTest {


    @ParameterizedTest
    @DisplayName("money가 0이거나 1000원 단위가 아니라면 예외 발생")
    @ValueSource(ints = {0, 50, 1500})
    void 로또머니_생성_시_단위가_맞지_않는다면_예외(int money) {
        Assertions.assertThatThrownBy(() -> new LottoMoney(money))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @DisplayName("money가 0이 아니고 1000원 단위라면 생성 성공")
    @ValueSource(ints = {1000, 10000, 200000})
    void 로또머니_생성_시_예외가_발생하지_않는다면_성공(int money) {
        assertDoesNotThrow(() -> new LottoMoney(money));
    }

    @ParameterizedTest(name = "돈이 {0}원일때 {1}개 구매 가능")
    @DisplayName("로또를 몇개 구매 가능한지 개수 계산")
    @CsvSource(value = {"1000,1", "10000,10"})
    void 로또_구매_가능_개수_계산(int money, int expected) {
        //given
        LottoMoney lottoMoney = new LottoMoney(money);

        //when
        int count = lottoMoney.calculatePurchasableCount();

        //then
        Assertions.assertThat(count).isEqualTo(expected);
    }
}