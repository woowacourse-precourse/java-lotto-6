package lotto;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import lotto.io.UserInputReader;
import org.assertj.core.api.ThrowableAssert.ThrowingCallable;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

public class IOTest {

    private static final InputStream stdIn = System.in;

    @DisplayName("숫자가 아닌 문자가 구입금액 또는 보너스 번호로 입력된 경우")
    @Test
    void throwExceptionForNotPureNumber() {
        assertInvalidString(() -> UserInputReader.readPureNumber(), "8kA000");
        UserInputReader.close();
        assertValidString(() -> UserInputReader.readPureNumber(), " 239023");
        UserInputReader.close();
    }

    @DisplayName("숫자가 아닌 문자가 당첨 번호로 입력된 경우")
    @Test
    void throwExceptionForNotPureNumberList() {
        assertInvalidString(() -> UserInputReader.readMultiplePureNumbers(),
                "1, 2,K, 2,3,45,5,323,k");
        UserInputReader.close();
        assertValidString(() -> UserInputReader.readMultiplePureNumbers(),
                " 1, 2,3,4, 5,5,600");
        UserInputReader.close();
    }

    void assertInvalidString(final ThrowingCallable throwingCallable, final String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        assertThatThrownBy(throwingCallable).isInstanceOf(IllegalArgumentException.class);
        System.setIn(stdIn);
    }

    void assertValidString(final Executable executable, final String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        Assertions.assertDoesNotThrow(executable);
        System.setIn(stdIn);
    }
}
