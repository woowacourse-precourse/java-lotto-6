package lotto.model;

import static lotto.util.message.Error.MUST_MONEY_UNIT;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import lotto.util.message.Digit;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class PurchaseTest {

    @ParameterizedTest
    @CsvSource({"0", "700", "7777", "12500"})
    @DisplayName("구매 금액은 1,000원 단위만 가능하다.")
    public void inputMoneyValidate(int money) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Purchase(money))
                .withMessageContaining(MUST_MONEY_UNIT.getError(Digit.MONEY_UNIT.getNumber()));
    }

    @ParameterizedTest
    @CsvSource({"1000,1", "7000,7", "10000,10", "777000,777"})
    @DisplayName("금액에 맞게 로또의 갯수를 저장한다.")
    public void purchaseLottoCount(int money, int expect) {
        Purchase purchase = new Purchase(money);

        int result = purchase.getCount();

        Assertions.assertThat(result).isEqualTo(expect);
    }
}