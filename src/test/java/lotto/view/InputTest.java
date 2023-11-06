package lotto.view;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayInputStream;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class InputTest {

    private static ByteArrayInputStream inputMessage;

    protected void systemIn(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
    }

    @BeforeEach
    void setUpStreams() {
    }

    @AfterEach
    void restoresStreams() {
        System.setIn(System.in);
    }

    @DisplayName("1개의 정수 입력")
    @Test
    public void receiveOneNumber() {
        String input = "1";
        inputMessage = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputMessage);

        Integer receivedNumber = Input.receiveOneNumber();

        Assertions.assertEquals(Integer.parseInt(input), receivedNumber);
    }

    @DisplayName("여러개의 정수를 콤마로 구분하여 입력")
    @Test
    public void receiveNumbersSeparatedByCommas() {
        String input = "1,2,3";
        inputMessage = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputMessage);

        List<Integer> receivedNumbers = Input.receiveNumbersSeparatedByCommas();

        assertThat(receivedNumbers).contains(1, 2, 3);
    }
}
