package lotto.message;

import static lotto.message.LottoGameErrorMessage.NOT_ABLE_TO_PARSE_INT_MESSAGE;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class LottoGameErrorMessageTest {

    @Test
    public void errorPrefixTestOnConstructor() {
        assertTrue(NOT_ABLE_TO_PARSE_INT_MESSAGE.getMessage().contains("[ERROR]"));
    }
}