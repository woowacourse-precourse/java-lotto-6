package lotto.utility;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import lotto.domain.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ChangeListTypeTest {
    @DisplayName("당첨 번호 각각에 숫자를 입력한다.")
    @Test
    void testValidateNumber() {
        // 유효한 당첨번호
        assertDoesNotThrow(() -> ChangeListType.parseInput("1,2,3,4,5,6"));
        assertDoesNotThrow(() -> ChangeListType.parseInput("1,7,9,14,18,45"));

        // 문자열 포함인 경우 예외 발생
        assertThrows(IllegalArgumentException.class, () -> ChangeListType.parseInput("a,b,c,d,e,f"));
        assertThrows(IllegalArgumentException.class, () -> ChangeListType.parseInput("1,b,3,d,5,f"));
    }
}
