package lotto.view;

import static lotto.view.ErrorMessage.ILLEGAL_MONEY;
import static lotto.view.OutputView.printErrorMessage;
import static lotto.view.OutputView.printSystemMessage;
import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class OutputViewTest {
    private final ByteArrayOutputStream output = new ByteArrayOutputStream();

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(output));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(System.out);
        output.reset();
    }

    @DisplayName("출력 (구매 금액 입력 안내 문구)")
    @Test
    void 출력테스트_printSystemMessage() {
        //given
        String expect = "구입금액을 입력해 주세요.\n";

        //when
        printSystemMessage(SystemMessage.ASK_MONEY);

        //then
        assertThat(output.toString()).isEqualTo(expect);
    }

    @DisplayName("출력 (구입 금액 예외처리)")
    @Test
    void 출력테스트_printErrorMessage() {
        //given
        String expect = "[ERROR] 구입 금액은 1,000 이상의 1,000 으로 나누어 떨어지는 숫자여야 합니다.\n";

        //when
        printErrorMessage(new IllegalArgumentException(ILLEGAL_MONEY.getMessage()));

        //then
        assertThat(output.toString()).isEqualTo(expect);
    }
}
