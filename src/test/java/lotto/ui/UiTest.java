package lotto.ui;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;
import lotto.Lotto;
import lotto.LottoScore;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class UiTest {
    final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    final PrintStream standardOut = System.out;

    private static Ui getUi() {
        Ui ui = new Ui();
        return ui;
    }

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    void tearDown() {
        System.setOut(standardOut);
    }

    @Test
    void 구매가격입력을_출력한다() {
        final String expectMessage = "구입금액을 입력해 주세요.";
        Ui ui = getUi();
        ui.printPrice();
        Assertions.assertThat(outputStreamCaptor.toString().trim()).isEqualTo(expectMessage);
    }

    @Test
    void 로또구매현황을_출력한다() {
        final String expectMessage = "3개를 구매했습니다.\n[1, 2, 3, 4, 5, 6]\n[1, 2, 3, 4, 5, 7]\n[7, 11, 15, 22, 33, 44]";
        Ui ui = getUi();
        ui.printLotto(List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(1, 2, 3, 4, 5, 7)),
                new Lotto(List.of(11, 22, 33, 44, 15, 7))
        ));
        Assertions.assertThat(outputStreamCaptor.toString().trim()).isEqualToIgnoringNewLines(expectMessage);
    }

    @Test
    void 로또입력을_유도하는_문장을_출력한다() {
        final String expectMessage = "당첨 번호를 입력해 주세요.";
        Ui ui = getUi();
        ui.printReadLottoNumber();
        Assertions.assertThat(outputStreamCaptor.toString().trim()).isEqualToIgnoringNewLines(expectMessage);
    }

    @Test
    void 보너스_로또입력을_유도하는_문장을_출력한다() {
        final String expectMessage = "보너스 번호를 입력해 주세요.";
        Ui ui = getUi();
        ui.printReadBonusLottoNumber();
        Assertions.assertThat(outputStreamCaptor.toString().trim()).isEqualToIgnoringNewLines(expectMessage);
    }

    @ParameterizedTest
    @CsvSource({
            "12.20,12.2",
            "12.24,12.2",
            "12.25,12.3",
            "12.29,12.3",
            "2.20,2.2",
            "2.24,2.2",
            "2.25,2.3",
            "2.29,2.3",
    })
    void 로또_통계를_출력한다(double earningPercent, double expectValue) {
        final String expectMessage = String.format("당첨 통계\n"
                + "---"
                + "6개 일치 (2,000,000,000원) - 0개\n"
                + "5개 일치, 보너스 볼 일치 (30,000,000원) - 1개\n"
                + "5개 일치 (1,500,000원) - 0개\n"
                + "4개 일치 (50,000원) - 0개\n"
                + "3개 일치 (5,000원) - 1개\n"
                + "총 수익률은 %.1f%%입니다.", expectValue);
        Ui ui = getUi();
        ui.printLottoResult(List.of(LottoScore.FIFTH_PLACE, LottoScore.SECOND_PLACE), earningPercent);
        Assertions.assertThat(outputStreamCaptor.toString().trim()).isEqualToIgnoringNewLines(expectMessage);
    }
}