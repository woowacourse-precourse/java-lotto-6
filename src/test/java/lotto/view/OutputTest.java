package lotto.view;

import static org.assertj.core.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class OutputTest {
    private ByteArrayOutputStream output;
    private OutputView outputView;

    @BeforeEach
    public void setUpStreams() {
        output = new ByteArrayOutputStream();
        outputView = new OutputView();
        System.setOut(new PrintStream(output));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(System.out);
    }


    @DisplayName("수익률이 소수점 둘째자리에서 반올림하여 출력되는지 테스트")
    @Test
    void 수익률_출력_테스트() {
        String expectTotalReturnOutput = "총 수익률은 65.6%입니다.";

        outputView.totalReturnOutput(65.5555);

        assertThat(expectTotalReturnOutput).isEqualTo(output.toString().trim());
    }


}
