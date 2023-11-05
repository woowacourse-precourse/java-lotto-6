package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNoException;
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

    @DisplayName("구입 금액이 1000원 단위이다.")
    @ParameterizedTest
    @ValueSource(ints = {1000, 10000, 11000, 510000, 11000})
    void 구입_금액_단위(int price){
        assertThatNoException().isThrownBy(() -> new Price(price));
    }

    @DisplayName("구입 금액으로 발행할 로또 개수를 구한다.")
    @Test
    void 구입_금액으로_로또_개수_반환(){
        //given
        int purchasePrice = 101000;
        Price price = new Price(purchasePrice);

        //when
        int lottoCount = price.getLottoCount();

        //then
        assertThat(lottoCount).isEqualTo(101);
    }

}