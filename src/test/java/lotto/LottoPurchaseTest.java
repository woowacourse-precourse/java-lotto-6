package lotto;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import lotto.model.LottoPurchase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class LottoPurchaseTest {

    @DisplayName("입력한 구입 금액이 숫자인지 검증한다.")
    @ParameterizedTest
    @ValueSource(strings = {"-13000", "1.53", "0.555", "asdf"})
    void validateByNumericType(String input) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> LottoPurchase.validateInputTypeNumeric(input));
    }

    @DisplayName("입력한 구입 금액이 1000원 이상인지 검증한다.")
    @Test
    void validateByMinimumPrice() {
        int price = 700;
        assertThatIllegalArgumentException()
                .isThrownBy(() -> LottoPurchase.validateMinimunPrice(price));
    }
}
