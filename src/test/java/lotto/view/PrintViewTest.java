package lotto.view;

import static lotto.constant.testConstant.BONUS_NUMBER_45;
import static lotto.constant.testConstant.LOTTO_1_TO_5_WITH_45;
import static lotto.constant.testConstant.LOTTO_1_TO_6;
import static lotto.constant.testConstant.LOTTO_3_TO_8;
import static lotto.constant.testConstant.LOTTO_7_TO_12;
import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoCollection;
import lotto.domain.LottoCount;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PrintViewTest {
    private ByteArrayOutputStream outputStream;

    @BeforeEach
    void setup() {
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
    }

    @Test
    void check_lotto_count() {
        LottoCount lottoCount = LottoCount.from(2000);
        PrintView.printLottoCount(lottoCount.getCount());
        assertThat(outputStream.toString())
                .hasToString("2개를 구매했습니다.");
    }

}
