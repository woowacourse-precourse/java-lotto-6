package lotto.io.read;

import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

class InputReaderTest {

    private final InputStream originalIn = System.in;
    private ByteArrayInputStream testIn;

    @AfterEach
    void restoreSystemInput() {
        System.setIn(originalIn);
        Console.close();
    }

    @Test
    void 콘솔_입력값을_문자열로_반환한다() {
        //Arrange
        String input = "Test input";
        testIn = new ByteArrayInputStream(input.getBytes());
        System.setIn(testIn);

        //Act
        String result = new InputReader().readLine();

        //Assert
        assertThat(result).isEqualTo(input);
    }
}