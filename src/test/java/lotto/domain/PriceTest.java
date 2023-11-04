package lotto.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import lotto.utils.NumberUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class PriceTest {

    @ParameterizedTest(name = "정상적인 가격을 입력받는다.")
    @ValueSource(ints = {1000, 50000, 100000})
    void createPriceTest(final int price) {
        Assertions.assertDoesNotThrow(() -> new Price(price));
    }


    @ParameterizedTest(name = "1000 단위로 입력하지 않았을 시 에러반환")
    @ValueSource(ints = {123, 4325, 45667, 656877})
    void priceUnitValidTest(final int price) {
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
                () -> new Price(price));
        assertThat(e.getMessage()).isEqualTo(Price.PRICE_UNIT_VALID_LOG);
    }

    @ParameterizedTest(name = "입력받은 값이 숫자가 아닐경우 에러반환")
    @ValueSource(strings = "만원, ㅇㄹㅎㄱㅈ, 만500원")
    void priceParseIntValidTest(final String price) {
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
                () -> new Price(price));
        assertThat(e.getMessage()).isEqualTo(NumberUtil.STRING_VALID_LOG);
    }
}