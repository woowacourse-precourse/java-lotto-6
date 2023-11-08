package lotto.domain;

import lotto.exception.ErrorCode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PurchaseLottosTest {

    @DisplayName("구입된 로또가 없는 경우")
    @Test
    void validatorSize() {

        List<Lotto> purchaseLottos = new ArrayList<>();

        assertThatThrownBy(() -> new PurchaseLottos(purchaseLottos))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorCode.NOT_FOUND_PURCHASE_LOTTO.getMessage());
    }

}
