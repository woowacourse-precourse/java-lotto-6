package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


class LottoAmountTest {

    @Test
    @DisplayName("로또 금액이 1000으로 나눠 떨어지지 않는다면 예외를 발생시킨다.")
    void validateAmount_throwException() {
        /**
         * given : 1000원 단위가 아닌 수가 주어진다. (1001)
         * when : LottoAmount 객체를 생성한다.
         * then : IllegalArgumentException 예외가 발생한다.
         */
        String amount = "1001";

        assertThatThrownBy(() -> new LottoAmount(amount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("로또 금액을 1000원 단위로 입력해주세요.");
    }

    @Test
    @DisplayName("로또 금액이 1000으로 나눠 떨어지지 않는다면 예외를 발생시킨다.")
    void validateAmount_dontThrowException() {
        /**
         * given : 1000원 단위의 수가 주어진다.
         * when : LottoAmount 객체를 생성한다.
         * then : 예외가 발생하지 않는다.
         */
        String amount = "5000";

        assertThatCode(() -> new LottoAmount(amount))
                .doesNotThrowAnyException();
    }
}