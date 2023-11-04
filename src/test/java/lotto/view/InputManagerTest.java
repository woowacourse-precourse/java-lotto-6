package lotto.view;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class InputManagerTest {
    private ByteArrayOutputStream outContent;
    private PrintStream originalOut = System.out;
    InputManager inputManager;
    InputStream in;
    
    @BeforeEach
    void beforeEach(){
        outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        inputManager = new InputManager();
    }

    @AfterEach
    void restoreStreams() {
        System.setOut(originalOut);
    }

    @ParameterizedTest
    @CsvSource(value = {"구입금액을 입력해 주세요.:1000", "당첨 번호를 입력해 주세요.:1,2,3,4,5,6", "보너스 번호를 입력해주세요.:7"}, delimiter = ':')
    @DisplayName("입력 메세지 출력하고 입력받는 메서드 테스트")
    void inputValueTest(String message, String input) {
        //given
        in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        //when
        String result = inputManager.inputValue(message);
        String printMessage = outContent.toString().trim();
        //then
        System.setIn(System.in);
        assertThat(printMessage).isEqualTo(message);
        assertThat(result).isEqualTo(input);
    }
}