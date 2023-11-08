package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.model.LottoPurchase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class LottoPurchaseTest {

    @DisplayName("구입 금액 입력에 대한 유효성 검증 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"700", "7777", "7700", "Asdf"})
    void validateLottoPurchase(String input) {
        assertThatThrownBy(() -> new LottoPurchase(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구입 금액에 대한 로또 구입 수량 검증 테스트")
    @Test
    void validateGetLottoPurchaseCount() {
        LottoPurchase lottoPurchase = new LottoPurchase("7000");
        assertThat(7).isEqualTo(lottoPurchase.getLottoCount());
    }

}
