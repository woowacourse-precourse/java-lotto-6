package domain.validator;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import util.ErrorMessage;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PriceValidatorTest extends NsTest {
    private final PriceValidator priceValidator = new PriceValidator();

    @DisplayName("정해진 단위(1000원) 단위가 아닐 시 예외 발생")
    @ParameterizedTest
    @ValueSource(ints ={123,1234,1001,100001,100100})
    void priceIsntInStandardUnit(int price) {
        assertThatThrownBy(() -> priceValidator.checkPriceValidation(price))
                .isInstanceOf(IllegalArgumentException.class);
        assertThat(output()).isEqualTo(ErrorMessage.PRICE_ISNT_IN_STANDARD_UNIT.getErrorMessage());
    }

    @DisplayName("금액이 음수이면 예외 발생")
    @ParameterizedTest
    @ValueSource(ints ={-1,-100,-120120})
    void priceIsNegative(int price) {
        assertThatThrownBy(() -> priceValidator.checkPriceValidation(price))
                .isInstanceOf(IllegalArgumentException.class);
        assertThat(output()).isEqualTo(ErrorMessage.PRICE_IS_NEGATIVE.getErrorMessage());
    }

    @Override
    public void runMain(){
    }
}