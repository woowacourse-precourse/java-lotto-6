package lotto.view.output.writer;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("콘솔 출력 테스트")
class ConsoleWriterTest {
    private PrintStream standardOut;
    private OutputStream captor;
    private ConsoleWriter consoleWriter;

    @BeforeEach
    void setUp() {
        standardOut = System.out;
        captor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(captor));

        consoleWriter = new ConsoleWriter();
    }

    @AfterEach
    void tearDown() {
        System.setOut(standardOut);
        System.out.println(output());
    }

    String output() {
        return captor.toString();
    }

    @Test
    @DisplayName("개행 없이 문자열을 출력한다.")
    void Should_Print_String_Without_NewLine_When_Print() {
        //given
        final String expected = "WithoutNewLine";

        //when
        consoleWriter.print(expected);

        //then
        assertThat(output()).isEqualTo(expected);
    }

    @Test
    @DisplayName("개행을 포함하여 문자열을 출력한다.")
    void Should_Print_String_With_NewLine_When_PrintLine() {
        //given
        final String expected = "WithNewLine\n";

        //when
        consoleWriter.println(expected.trim());

        //then
        assertThat(output()).isEqualTo(expected);
    }
}
