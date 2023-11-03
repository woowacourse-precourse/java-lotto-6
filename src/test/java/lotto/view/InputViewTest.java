package lotto.view;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.assertj.core.api.Assertions.assertThat;

public class InputViewTest {
    InputView inputView = new InputView();

    @Test
    @DisplayName("지불금액 입력 테스트 - 정상데이터 - 성공")
    void askPaymentAmountTest() {
        System.setIn(createUserInput("5000"));
        String userInput = inputView.askPaymentAmount();
        assertThat(userInput).isEqualTo("5000");
    }

    private static InputStream createUserInput(String input) {
        return new ByteArrayInputStream(input.getBytes());
    }
}
