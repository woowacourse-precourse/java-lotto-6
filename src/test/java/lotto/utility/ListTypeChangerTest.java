package lotto.utility;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ListTypeChangerTest {
    @DisplayName("당첨 번호 각각에 숫자를 입력한다.")
    @Test
    void testValidateNumber() {
        assertDoesNotThrow(() -> ListTypeChanger.changeListType("1,2,3,4,5,6"));
        assertDoesNotThrow(() -> ListTypeChanger.changeListType("1,7,9,14,18,45"));

        assertThrows(IllegalArgumentException.class, () -> ListTypeChanger.changeListType("a,b,c,d,e,f"));
        assertThrows(IllegalArgumentException.class, () -> ListTypeChanger.changeListType("1,b,3,d,5,f"));
    }
}
