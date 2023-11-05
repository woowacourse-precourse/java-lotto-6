package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.util.ExceptionEnum;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class PriceTest{

    @DisplayName("구입 금액이 1000원 단위가 아니면 예외 처리한다.")
    @ParameterizedTest
    @ValueSource(ints = {100, 10100, 11200, 5100, 10})
    void 구입_금액_단위_예외_처리(int price){
        assertThatThrownBy(() -> new Price(price)).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionEnum.INVALID_PURCHASE_PRICE_UNIT.getMessage());
    }

}