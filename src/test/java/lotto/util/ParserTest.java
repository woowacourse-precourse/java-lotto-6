package lotto.util;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import lotto.domain.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ParserTest {
    @DisplayName("구입 금액을 입력받아 정수로 반환한다.")
    @Test
    void parsePurchasePrice() {
        // given
        String input = "1000";

        // when
        int actual = Parser.parsePurchasePrice(input);

        // then
        assertEquals(1000, actual);
    }

}
