package lotto.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoPurchaseAmountTest {
    @ParameterizedTest(name = "[{index}] 구입금액이 ''{0}''이면 LottoPurchaseAmountTest 생성 시 예외가 발생한다.")
    @ValueSource(strings = {"10100", "0", "-1000", "abc", "", " "})
    void cannotCreate(String element) {
        assertThatThrownBy(() -> LottoPurchaseAmount.create(element))
                .isInstanceOf(IllegalArgumentException.class);
    }
}