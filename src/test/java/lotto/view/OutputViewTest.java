package lotto.view;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

public class OutputViewTest {
    private final OutputView outputView = new OutputView();
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
    void 구매한_로또_개수_화면_포맷_출력_테스트() {
        // given
        set_custom_printStream();

        // when
        outputView.renderLottoTicketsCountText();

        // then
        assertThat(output.toString()).contains("개를 구매했습니다.");
    }

    @Test
    void 당첨_개수_통계_화면_포맷_출력_테스트() {
        // given
        set_custom_printStream();

        // when
        outputView.renderPrizeCounterText();

        // then
        assertThat(output.toString()).contains("당첨 통계", "---");
    }

    @Test
    void 수익률_화면_포맷_출력_테스트() {
        // given
        set_custom_printStream();

        // when
        outputView.renderRateOfReturnText();

        // then
        assertThat(output.toString()).contains("총 수익률은", "%%입니다.");
    }
}