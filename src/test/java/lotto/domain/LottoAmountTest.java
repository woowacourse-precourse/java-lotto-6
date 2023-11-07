package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoAmountTest {
    LottoAmount lottoAmount;

    @BeforeEach
    void setUp() {
        lottoAmount = new LottoAmount();
    }

    @DisplayName("구입금액의 입력이 올바르지 않으면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"abc", "-14000", "900", "0", "", " "})
    void createInvalidPurchaseAmount(String purchaseAmount) {
        assertThatThrownBy(() -> lottoAmount.validatePurchaseAmount(purchaseAmount))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 구입 금액에 해당하는 만큼 로또를 발행해야 한다.")
    @Test
    void getPurchaseQuantityOfLotto() {
        assertThat(lottoAmount.getPurchaseQuantityOfLotto(8400)).isEqualTo(8);
    }

}
