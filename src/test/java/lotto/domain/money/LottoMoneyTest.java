package lotto.domain.money;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import lotto.validator.domain.exception.DomainExceptionMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoMoneyTest {

    @DisplayName("잘못된 돈이 입력되면 예외가 발생합니다.")
    @ParameterizedTest
    @ValueSource(ints = {999, 900, 10001, 1000001})
    void createMoney_exception_withInvalidValue(final int invalidValue) {
        assertThatIllegalArgumentException().isThrownBy(() -> LottoMoney.from(invalidValue))
                .withMessageContaining(DomainExceptionMessage.INVALID_MONEY_VALUE.value());
    }

    @DisplayName("투입 금액에 따른 구매 가능한 로또 개수를 계산할 수 있다.")
    @Test
    void calculateBuyingCount() {
        // given
        int moneyValue = 10000;
        int expectCount = 10;

        // when
        LottoMoney lottoMoney = LottoMoney.from(moneyValue);

        // then
        assertThat(lottoMoney.calculateBuyingCount()).isEqualTo(expectCount);
    }
}