package lotto.io;

import static org.assertj.core.api.Assertions.assertThat;

import lotto.ConsoleTestSuper;
import org.junit.jupiter.api.Test;

class ConsoleOutputTest extends ConsoleTestSuper {

    @Test
    void console_테스트() {
        String message = "hello, precourse!";

        new ConsoleOutput().print(message);

        assertThat(outputStream.toString()).isEqualTo(message);
    }

    @Test
    void 인자가없는_consoleLine_테스트() {
        String expected = "\n";

        new ConsoleOutput().println();

        assertThat(outputStream.toString()).isEqualTo(expected);
    }

    @Test
    void 기본_consoleLine_테스트() {
        String message = "hello, precourse!";

        new ConsoleOutput().println(message);

        assertThat(outputStream.toString()).isEqualTo(message + "\n");
    }

}