package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.*;

class PurchaseLottoTest {

    @ParameterizedTest
    @CsvSource({"10000,10", "50000,50", "130000,130"})
    @DisplayName("구매 로또 개수 계산 테스트")
    void calculateLottoCount(int money, int expected) {
        //given
        PurchaseLotto purchaseLotto = new PurchaseLotto(money);

        //when
        int count = purchaseLotto.calculateLottoCount();

        //then
        assertThat(count).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource({"10", "500", "-1", "10000000", "2700"})
    @DisplayName("금액 입력시 예외처리 확인")
    void inputExceptionTest(int money) {
        assertThatThrownBy(() -> new PurchaseLotto(money))
                .isInstanceOf(IllegalArgumentException.class);
    }
}