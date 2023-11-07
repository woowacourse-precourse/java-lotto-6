package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class MoneyTest {
    private Money money;

    @DisplayName("금액 입력 에러 확인")
    @ParameterizedTest
    @CsvSource(value = {"'',[ERROR] 1000원 이상 20억원 미만의 금액을 입력하시오", "' ',[ERROR] 1000원 이상 20억원 미만의 금액을 입력하시오",
            "012345,[ERROR] 숫자를 입력하시오",
            "ABCDE,[ERROR] 숫자를 입력하시오", "2500000000,[ERROR] 20억원 미만의 금액을 입력하시오",
            "12345,[ERROR] 1000원 단위의 금액을 입력하시오"}, ignoreLeadingAndTrailingWhitespace = false)
    void checkMoney(String inputMoney, String expected) {

        assertThatThrownBy(() -> new Money(inputMoney))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(expected);

    }

    @DisplayName("입력한 금액만큼 로또 갯수를 만들 수 있는지 확인")
    @ParameterizedTest
    @CsvSource(value = {"5000,5", "1000,1", "200000000,200000"})
    void checkPurchaseLotto(String inputMoney, int expected) {
        money = new Money(inputMoney);
        assertThat(money.toLottoAmount()).isEqualTo(expected);
    }

}