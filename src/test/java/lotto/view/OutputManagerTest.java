package lotto.view;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

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

    @DisplayName("로또의 번호를 출력한다.")
    @Test
    void printLotto() {
        OutputManager outputManager = new OutputManager();
        String expectedMessage = "[1, 2, 3, 4]";
        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);

        outputManager.printLotto(numbers);
        assertThat(expectedMessage).isEqualTo(outputMessage.toString().trim());
    }
}
