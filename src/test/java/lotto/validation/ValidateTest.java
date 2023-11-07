package lotto.validation;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Arrays;
import java.util.List;
import lotto.utils.Validator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ValidateTest {

    @DisplayName("구입 금액 유효성 검증 테스트")
    @Test
    void 로또_구입_금액_테스트() {
        List<String> validMoneyList = Arrays.asList("1000", "2000"); // 유효한 금액 리스트
        for (String money : validMoneyList) {
            assertDoesNotThrow(() -> Validator.validateMoney(money));
        }

        List<String> invalidMoneyList = Arrays.asList("200", "1000j", "1500"); // 유효하지 않은 금액 리스트
        for (String money : invalidMoneyList) {
            assertThrows(IllegalArgumentException.class, () -> Validator.validateMoney(money));
        }
    }
}
