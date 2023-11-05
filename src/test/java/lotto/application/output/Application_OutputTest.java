package lotto.application.output;

import static lotto.resource.TextResourceProvider.INPUT_PURCHASE_AMOUNT_TEXT;
import static lotto.resource.TextResourceProvider.QUANTITY_OUTPUT_TEXT_FORMAT;
import static org.assertj.core.api.Assertions.assertThat;

import lotto.MyApplicationTest;
import org.junit.jupiter.api.Test;

public class Application_OutputTest extends MyApplicationTest {
    @Test
    void 구입금액_입력_문구를_출력한다() {
        runWithValidArguments();

        assertThat(outputs())
                .contains(INPUT_PURCHASE_AMOUNT_TEXT);
    }

    @Test
    void 구입개수_출력_문구를_출력한다() {
        runWithValidArguments();

        assertThat(outputs())
                .contains(QUANTITY_OUTPUT_TEXT_FORMAT.format("1"));
    }

    @Test
    void 발행한_로또의_개수는_구입_금액에서_로또_금액을_나눈_몫이다() {
        runWithValidArguments();

        assertThat(outputs())
                .filteredOn(QUANTITY_OUTPUT_TEXT_FORMAT::matches)
                .hasSize(1);
    }

    private static void runWithValidArguments() {
        run("1000", "123456", "7");
    }

}
