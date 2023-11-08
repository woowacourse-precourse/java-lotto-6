package lotto.view.input.reader;

import static org.mockito.Mockito.mockStatic;

import camp.nextstep.edu.missionutils.Console;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

@DisplayName("콘솔 입력 테스트")
class ConsoleReaderTest {

    private ConsoleReader consoleReader;

    @BeforeEach
    void setUp() {
        consoleReader = new ConsoleReader();
    }

    @Test
    @DisplayName("입력은 콘솔로 받아야 합니다.")
    void Should_Read_From_Console_When_Read() {
        //given
        try (MockedStatic<Console> mockConsole = mockStatic(Console.class)) {
            //when
            mockConsole.when(Console::readLine).thenReturn("1");
            consoleReader.read();

            //then
            mockConsole.verify(Console::readLine);
        }
    }
}
