package lotto;

import static lotto.ErrorMessage.DUPLICATE_NUMBER_ERROR_MESSAGE;
import static lotto.ErrorMessage.NUMBER_1_ESCAPE_ERROR_MESSAGE;
import static lotto.ErrorMessage.NUMBER_6_ESCAPE_ERROR_MESSAGE;
import static lotto.ErrorMessage.ONLY_INTEGER_ERROR_MESSAGE;
import static lotto.ErrorMessage.RANGE_1_45_ERROR_MESSAGE;
import static lotto.ErrorMessage.UNDER_1000_ERROR_MESSAGE;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ErrorTest {

    @DisplayName("1000원 이하의 값 입력 시 예외가 발생한다.")
    @Test
    void isUnder1000Price() {
        assertThatThrownBy(() -> Error.CHECK.isUnder1000Price(900))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(UNDER_1000_ERROR_MESSAGE.get());
    }

    @DisplayName("로또 번호 중 문자열이 들어갈 시 예외가 발생한다.")
    @Test
    void isAllInteger() {
        assertThatThrownBy(() -> Error.CHECK.isAllInteger(new String[]{"1", "3", "-"}))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ONLY_INTEGER_ERROR_MESSAGE.get());
    }

    @DisplayName("보너스 번호에 문자열이 들어갈 시 예외가 발생한다.")
    @Test
    void testIsAllInteger() {
        assertThatThrownBy(() -> Error.CHECK.isAllInteger("일"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ONLY_INTEGER_ERROR_MESSAGE.get());
    }

    @DisplayName("숫자의 범위가 1 ~ 45 를 벗어날 시 예외가 발생한다.")
    @Test
    void isRange45() {
        assertThatThrownBy(() -> Error.CHECK.isRange45(List.of(1, 2, 3, 4, 5, 46)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(RANGE_1_45_ERROR_MESSAGE.get());
    }

    @DisplayName("로또 번 중 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void isDuplicate() {
        assertThatThrownBy(() -> Error.CHECK.isDuplicate(List.of(1, 2, 3, 4, 5, 1)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(DUPLICATE_NUMBER_ERROR_MESSAGE.get());
    }

    @DisplayName("보너스 번호와 로또 번호를 비호해 중복된 숫자가 있다면 예외가 발생한다.")
    @Test
    void testIsDuplicate() {
        assertThatThrownBy(() -> Error.CHECK.isDuplicate(new Lotto(List.of(1, 2, 3, 4, 5, 6)), 1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(DUPLICATE_NUMBER_ERROR_MESSAGE.get());
    }

    @DisplayName("로또 번호 입력시 6개를 입력하지 않으면 예외가 발생한다.")
    void isCollect6Number() {
        assertThatThrownBy(() -> Error.CHECK.isCollect6Number(List.of(1, 2, 3, 4, 5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(NUMBER_6_ESCAPE_ERROR_MESSAGE.get());
    }

}