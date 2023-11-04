package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class PurchaseAmountTest {

    @ParameterizedTest
    @ValueSource(ints = {0, -23})
    void 구입_금액이_1원_이상이_아닐_경우_에러_발생(int money) {
        Assertions.assertThatThrownBy(() -> new PurchaseAmount(money))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("구입 금액은 1원 이상이어야 합니다.");
    }

    @ParameterizedTest
    @ValueSource(ints = {1001, 999, 1, 1234, 42342})
    void 구입_금액이_1000원_단위가_아닐_경우_에러_발생(int money) {
        Assertions.assertThatThrownBy(() -> new PurchaseAmount(money))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("구입 금액이 1000원 단위이어야 합니다.");
    }

    @ParameterizedTest
    @ValueSource(ints = {1000, 2000, 35000, 14000})
    void 구입_금액이_1원_이상이고_1000원_단위일_경우_정상_생성(int money) {
        Assertions.assertThatNoException()
                .isThrownBy(() -> new PurchaseAmount(money));
    }
}