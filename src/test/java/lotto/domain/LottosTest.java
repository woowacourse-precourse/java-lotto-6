package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static lotto.exception.ExceptionMessage.EMPTY;
import static lotto.exception.ExceptionMessage.NOT_NUMBER;
import static lotto.exception.ExceptionMessage.INDIVISIBLE;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

public class LottosTest {
    @DisplayName("[Success] 구매한 금액을 1,000으로 나누어 구매 개수를 리턴한다.")
    @ParameterizedTest
    @CsvSource(value = {"1000:1", "2000:2", "4000:4"}, delimiter = ':')
    void getLottosByPurchaseMoney(String input, int expected) {
        assertThat(Lottos.purchase(input).getLottoQuantity())
                .isEqualTo(expected);
    }

    @DisplayName("[Exception] 입력한 금액이 숫자가 아니면 예외가 발생한다.")
    @Test
    void getLottosByNotNumberInput() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Lottos.purchase("숫자가아님").getLottoQuantity())
                .withMessage(NOT_NUMBER.getMessage());
    }

    @DisplayName("[Exception] 입력한 금액이 공백이면 예외가 발생한다.")
    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {" ", "  ", "\t", "\n"})
    void getLottosByNullInput(String input) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Lottos.purchase(input).getLottoQuantity())
                .withMessage(EMPTY.getMessage());
    }

    @DisplayName("[Exception] 입력한 금액이 1,000으로 나누어지지 않는 숫자이면 예외가 발생한다")
    @Test
    void getLottosByIndivisibleInput() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Lottos.purchase("1200").getLottoQuantity())
                .withMessage(INDIVISIBLE.getMessage());
    }
}
