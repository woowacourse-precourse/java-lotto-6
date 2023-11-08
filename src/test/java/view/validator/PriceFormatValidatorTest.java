package view.validator;

import camp.nextstep.edu.missionutils.test.NsTest;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import util.ErrorMessage;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PriceFormatValidatorTest extends NsTest {

    PriceFormatValidator priceFormatValidator = new PriceFormatValidator();

    @DisplayName("구매 금액이 입력되지 않으면 예외가 발생한다.")
    @Test
    void priceIsEmpty() {
        assertThatThrownBy(() -> priceFormatValidator.checkPriceFormat(""))
                .isInstanceOf(IllegalArgumentException.class);
        assertThat(output()).isEqualTo(ErrorMessage.PRICE_DOESNT_ENTER.getErrorMessage());
    }

    @DisplayName("구매 금액이 숫자 이외의 문자가 포함되면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"123a","abc","a1000"," 100","  2  "})
    void priceContainNonNumericCharacter(String input) {
        assertThatThrownBy(() -> priceFormatValidator.checkPriceFormat(input))
                .isInstanceOf(IllegalArgumentException.class);
        assertThat(output()).isEqualTo(ErrorMessage.PRICE_CONTAIN_NON_NUMERIC_CHARACTER.getErrorMessage());
    }

    @Override
    public void runMain() {

    }
}