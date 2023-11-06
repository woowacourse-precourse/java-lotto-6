package lotto.view;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

public class InputViewTest {
    private final InputView inputView = new InputView();
    private ByteArrayOutputStream output;

    @AfterEach
    void restore() {
        System.setOut(System.out);
        output.reset();
    }

    public void set_custom_printStream() {
        output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));
    }

    @Test
    void 구입_금액_입력_화면_출력_테스트() {
        // given
        set_custom_printStream();

        // when
        inputView.renderEnterBudgetText();

        // then
        assertThat(output.toString()).contains("구입금액을 입력해 주세요.");
    }

    @Test
    void 당첨_번호_입력_화면_출력_테스트() {
        // given
        set_custom_printStream();

        // when
        inputView.renderEnterWinningNumbersText();

        // then
        assertThat(output.toString()).contains("당첨 번호를 입력해 주세요.");
    }

    @Test
    void 보너스_번호_입력_화면_출력_테스트() {
        // given
        set_custom_printStream();

        // when
        inputView.renderEnterBonusNumberText();

        // then
        assertThat(output.toString()).contains("보너스 번호를 입력해 주세요.");
    }
}
