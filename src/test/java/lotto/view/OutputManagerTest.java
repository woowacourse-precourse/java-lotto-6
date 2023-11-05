package lotto.view;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;

class OutputManagerTest {
    private static OutputStream outputMessage;

    @BeforeEach
    void setUpStreams() {
        outputMessage = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputMessage));
    }

    @AfterEach
    void restoresStreams() {
        System.setOut(System.out);
    }

    @DisplayName("입력받은 메시지를 출력한다.")
    @Test
    void printMessage() {
        OutputManager outputManager = new OutputManager();
        String expectedMessage = "테스트 메시지입니다.";
        outputManager.printMessage(expectedMessage);
        assertThat(expectedMessage).isEqualTo(outputMessage.toString().trim());
    }
}
