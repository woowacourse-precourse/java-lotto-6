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

    @Test
    @DisplayName("당첨 번호 입력 테스트 - 정상데이터 - 성공")
    void askAnswerLottoNumbersTest() {
        System.setIn(createUserInput("1, 2, 3, 4, 5, 6"));
        String userInput = inputView.askAnswerLottoNumbers();
        assertThat(userInput).isEqualTo("1, 2, 3, 4, 5, 6");
    }

    @Test
    @DisplayName("보너스 번호 입력 테스트 - 정상데이터 - 성공")
    void askBonusNumberTest() {
        System.setIn(createUserInput("1"));
        String userInput = inputView.askBonusNumber();
        assertThat(userInput).isEqualTo("1");
    }

    private static InputStream createUserInput(String input) {
        return new ByteArrayInputStream(input.getBytes());
    }
}
