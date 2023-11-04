package lotto.view.input;

import camp.nextstep.edu.missionutils.Console;
import lotto.message.ErrorMessage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.*;

class LottoGameStartInputTest {

    private final LottoGameStartInput lottoGameStartInput = new LottoGameStartInput();

    private OutputStream captor;

    @AfterEach
    void tearDown(){
        Console.close();
    }

    private void init() {
        captor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(captor));
    }

    private String output() {
        return captor.toString();
    }

    @Test
    @DisplayName("사용자에게 금액을 물어보는 메시지가 출력된다.")
    public void displayRequestLottoPurchaseAmount() {
        // given
        init();
        String input = "8000";
        String result = "구입할 Lotto 금액을 입력해 주세요.\n\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        // when
        lottoGameStartInput.requestLottoPurchaseAmount();
        // then
        assertThat(result).isEqualTo(output());
    }

    @Test
    @DisplayName("사용자에게 구입할 로또 금액을 입력받을 수 있다.")
    public void requestLottoPurchaseAmount() {
        // given
        String input = "98000";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        // when
        long amount = lottoGameStartInput.requestLottoPurchaseAmount();
        // then
        assertThat(amount).isEqualTo(98000L);
    }

    @ParameterizedTest(name = "{index}: 숫자가 아닌 입력으로 {0}이 들어오면 예외가 발생한다.")
    @DisplayName("숫자가 아닌 다른 입력이 들어오면 예외가 발생한다.")
    @ValueSource(strings = {"asda", "안녕하세요", "中國語", "ひらがな"})
    public void notNumberExceptionTest(String input) {
        // given
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        // when // then
        assertThatThrownBy(() -> lottoGameStartInput.requestLottoPurchaseAmount())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.INVALID_AMOUNT_FORMAT.getMessage());
    }

    @ParameterizedTest(name = "{index}: 금액이 {0}이면 예외가 발생한다.")
    @DisplayName("Lotto의 금액이 0보다 크지 않으면 예외가 발생한다.")
    @ValueSource(strings = {"0","-1000","-1500"})
    public void positiveNumberExceptionTest(String input) {
        // given
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        // when // then
        assertThatThrownBy(() -> lottoGameStartInput.requestLottoPurchaseAmount())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.AMOUNT_LESS_THAN_ZERO.getMessage());
    }

}