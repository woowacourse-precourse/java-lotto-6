package lotto;

import lotto.Model.PriceValidator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PriceValidatorTest {

    @DisplayName("로또구입 금액 입력값에 문자가 있으면 예외")
    @Test
    void invalidInput1() {
        Assertions.assertThatThrownBy(() -> new PriceValidator("5000원"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또구입 금액 입력값이 1000원 단위가 아니면 예외")
    @Test
    void invalidInput2() {
        Assertions.assertThatThrownBy(() -> new PriceValidator("5500"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또구입 금액 입력값이 1000원~20억원 사이가 아니면 예외")
    @Test
    void invalidInput3() {
        Assertions.assertThatThrownBy(() -> new PriceValidator("0"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또구입 금액 입력값이 1000원~20억원 사이가 아니면 예외")
    @Test
    void invalidInput4() {
        Assertions.assertThatThrownBy(() -> new PriceValidator("2000001000"))
                .isInstanceOf(IllegalArgumentException.class);
    }



}
