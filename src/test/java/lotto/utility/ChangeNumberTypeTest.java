package lotto.utility;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import lotto.domain.Purchase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ChangeNumberTypeTest {
    @DisplayName("구입 금액에 숫자를 입력한다.")
    @Test
    void testValidateNumber() {
        // 유효한 구입금액
        assertDoesNotThrow(() -> new Purchase(1000));
        assertDoesNotThrow(() -> new Purchase(5000));

        // 문자열인 경우 예외 발생
        assertThrows(IllegalArgumentException.class, () -> new Purchase(Integer.parseInt("abc")));
    }
}
