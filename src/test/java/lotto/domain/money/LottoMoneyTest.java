package lotto.domain.money;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoMoneyTest {

    @DisplayName("잘못된 돈이 입력되면 예외가 발생합니다.")
    @ParameterizedTest
    @ValueSource(ints = {999, 900, 10001, 11000})
    void createMoney_exception_withInvalidValue(final int invalidValue) {
        assertThatIllegalArgumentException().isThrownBy(() -> LottoMoney.from(invalidValue))
                .withMessageContaining("[ERROR] 금액은 천원이상 만원 이하의 1000원 단위의 금액이어야 합니다.");
    }
}