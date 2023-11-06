package lotto.application.output;

import static lotto.resource.TextResourceProvider.INPUT_BONUS_NUMBER_TEXT;
import static lotto.resource.TextResourceProvider.INPUT_PURCHASE_AMOUNT_TEXT;
import static lotto.resource.TextResourceProvider.INPUT_WINNING_NUMBERS_TEXT;
import static lotto.resource.TextResourceProvider.OUTPUT_LOTTERY_RESULT_HEADER_LINE_TEXT;
import static lotto.resource.TextResourceProvider.OUTPUT_LOTTERY_RESULT_TEXT;
import static lotto.resource.TextResourceProvider.QUANTITY_OUTPUT_TEXT_FORMAT;
import static org.assertj.core.api.Assertions.assertThat;

import lotto.MyApplicationTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("[Application] 어플리케이션의 출력문구에 관한 테스트")
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

    @Test
    void 당첨번호_입력_문구를_출력한다() {
        runWithValidArguments();

        assertThat(outputs())
                .contains(INPUT_WINNING_NUMBERS_TEXT);
    }

    @Test
    void 보너스번호_입력_문구를_출력한다() {
        runWithValidArguments();

        assertThat(outputs())
                .contains(INPUT_BONUS_NUMBER_TEXT);
    }

    @Test
    void 당첨_통계_출력_헤더_문구를_모두_출력한다() {
        runWithValidArguments();

        assertThat(outputs())
                .contains(OUTPUT_LOTTERY_RESULT_TEXT, OUTPUT_LOTTERY_RESULT_HEADER_LINE_TEXT);
    }

    private static void runWithValidArguments() {
        run("1000", "1,2,3,4,5,6", "7");
    }

}
