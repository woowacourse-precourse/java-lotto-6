package lotto.domain;

import static lotto.view.ExceptionMessage.DIVISIBLE_EXCEPTION;
import static lotto.view.ExceptionMessage.NATURAL_EXCEPTION;
import static lotto.view.ExceptionMessage.TYPE_EXCEPTION;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ReadPurchaseAmountTest {


    @DisplayName("로또 구입 금액의 입력 받은 값이 빈 값인지 체크 ")
    @Test
    void 입력_받은_값이_빈_값인지_체크() {
        //given
        String readAmount = "";

        //when //then
        assertThatThrownBy(() -> new ReadPurchaseAmount(readAmount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(NATURAL_EXCEPTION.getMessage());
    }

    @DisplayName("로또 구입 금액의 입력 받은 값이 1,000원으로 나누어 떨어지지 않는 경우 체크")
    @Test
    void 입력_받은_값이_1000원으로_나누어_떨어지지_않는_경우_체크() {
        //given
        String readAmount = "1234";

        //when //then
        assertThatThrownBy(() -> new ReadPurchaseAmount(readAmount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(DIVISIBLE_EXCEPTION.getMessage());
    }

    @DisplayName("숫자만 입력해 주세요.")
    @Test
    void 숫자만_입력해_주세요() {
        String readAmount = "1000j";

        //when //then
        assertThatThrownBy(() -> new ReadPurchaseAmount(readAmount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(TYPE_EXCEPTION.getMessage());
    }
}