package lotto.view;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.assertj.core.api.Assertions.assertThat;
public class InputViewTest {
    InputView inputView = new InputView();
    @Test
    @DisplayName("구입 금액 테스트")
    void buyLottoTickets() {
        System.setIn(userInput("3000"));
        String input = inputView.buyLottoTickets();
        assertThat(input).isEqualTo("3000");
    }

    @Test
    @DisplayName("당첨 번호 입력 테스트")
    void requestLottoNumber() {
        System.setIn(userInput("1,2,3,4,5,6"));
        String input = inputView.requestLottoNumber();
        assertThat(input).isEqualTo("1,2,3,4,5,6");
    }

    @Test
    @DisplayName("보너스 번호 입력 테스트")
    void requestBonusNumber() {
        System.setIn(userInput("7"));
        String input = inputView.requestBonusNumber();
        assertThat(input).isEqualTo("7");
    }
    private static InputStream userInput (String input){
        return new ByteArrayInputStream(input.getBytes());
    }
}
