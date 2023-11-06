package model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoVendorTest {

    @DisplayName("로또 구입 금액이 나누어 떨어지지 않으면 예외가 발생한다.")
    @Test
    void createLottoVendorByInvalidPurchaseAmount() {
        assertThatThrownBy(() -> new LottoVendor("23"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
