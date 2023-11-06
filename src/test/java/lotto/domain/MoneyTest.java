package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class MoneyTest {
    private Money money;

    @ParameterizedTest
    @CsvSource(value = {"'',[ERROR] 1000원 이상 20억원 미만의 금액을 입력하시오", "' ',[ERROR] 1000원 이상 20억원 미만의 금액을 입력하시오",
            "012345,[ERROR] 숫자를 입력하시오",
            "ABCDE,[ERROR] 숫자를 입력하시오", "2500000000,[ERROR] 20억원 미만의 금액을 입력하시오",
            "12345,[ERROR] 1000원 단위의 금액을 입력하시오"}, ignoreLeadingAndTrailingWhitespace = false)
    void 금액입력_검증(String inputMoney, String expected) {

        assertThatThrownBy(() -> new Money(inputMoney))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(expected);

    }

    @ParameterizedTest
    @CsvSource(value = {"5000,5", "1000,1", "200000000,200000"})
    void 구입가능한_로또갯수(String inputMoney, int expected) {
        money = new Money(inputMoney);
        assertThat(money.toLottoAmount()).isEqualTo(expected);
    }

}