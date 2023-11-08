package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.mockito.Mockito.*;

class ConsoleReaderTest {
    private ConsoleReader consoleReader;

    @BeforeEach
    void setUp() {
        consoleReader = new ConsoleReader();
    }

    @DisplayName("Console.readline()과 같은 값인지 확인")
    @Test
    void readLine() {
        try(MockedStatic<Console> consoleMockedStatic = mockStatic(Console.class)) {
            String input = "default";
            when(Console.readLine()).thenReturn(input);
            assertThat(consoleReader.readLine()).isEqualTo(input);
            consoleMockedStatic.verify(Console::readLine, times(1));
        }
    }

    @DisplayName("Console.close()가 호출되었는지 확인")
    @Test
    void close() {
        try(MockedStatic<Console> consoleMockedStatic = mockStatic(Console.class)) {
            assertThatCode(() -> consoleReader.close()).doesNotThrowAnyException();
            consoleMockedStatic.verify(Console::close, times(1));
        }
    }
}