package lotto.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;


public class PriceExceptionTest {

    @Test
    @DisplayName("올바른 가격을 입력했을 때")
    void checkRightPrice() {
        int validMoney = 2000;
        assertThatCode(() -> PriceException.validPrice(validMoney)).doesNotThrowAnyException();
    }

    @Test
    @DisplayName("음수인 값을 입력했을 경우")
    void testValidPriceWithNegativeInput() {
        int negativeMoney = -1000;
        assertThatThrownBy(() -> PriceException.validPrice(negativeMoney))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] : 구입 가격은 양수여야 합니다.");
    }

    @Test
    @DisplayName("유효하지 않은 문자열을 입력했을 경우")
    void testValidPriceWithInvalidInput() {
        String invalidInput = "abc";
        assertThatThrownBy(() -> PriceException.checkValidNumber(invalidInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] : 옳바른 숫자를 입력해주세요.");
    }

    @Test
    @DisplayName("빈칸이 존재할 경우")
    public void testCheckValidNumberWithInputContainingSpace() {
        String inputWithSpace = "12 34";
        assertThatThrownBy(() -> PriceException.checkValidNumber(inputWithSpace))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] : 입력값에 빈칸은 있으면 안됩니다.");
    }

    @Test
    @DisplayName("빈값이 존재할 경우")
    public void testCheckEmptyWithEmptyInput() {
        String emptyInput = "";
        assertThatThrownBy(() -> PriceException.checkValidNumber(emptyInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] : 빈값은 입력할 수 없습니다.");
    }

    @Test
    @DisplayName("1000의 배수가 아닌 값을 입력했을 경우")
    public void testCheckPriceWithNotMultipleOfThousand() {
        assertThatThrownBy(() -> PriceException.validPrice(300))
                .isInstanceOf(IllegalArgumentException.class);

    }

}
