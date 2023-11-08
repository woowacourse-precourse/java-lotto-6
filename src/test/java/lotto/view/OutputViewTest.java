package lotto.view;

import static lotto.constant.testConstant.BONUS_NUMBER_45;
import static lotto.constant.testConstant.LOTTO_1_TO_5_WITH_45;
import static lotto.constant.testConstant.LOTTO_1_TO_6;
import static lotto.constant.testConstant.LOTTO_3_TO_8;
import static lotto.constant.testConstant.LOTTO_7_TO_12;
import static lotto.domain.MatchingCase.NEW_GAME;
import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;
import java.util.stream.Stream;
import lotto.domain.Lotto;
import lotto.domain.LottoCollection;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

public class OutputViewTest {
    private ByteArrayOutputStream outputStream;

    @BeforeEach
    void setup() {
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
    }

    static Stream<Arguments> lottoCountTestData() {
        return Stream.of(
                Arguments.of(1, "1개를 구매했습니다.\n"),
                Arguments.of(11, "11개를 구매했습니다.\n")
        );
    }

    @DisplayName("printLottoCount는 로또 수량을 출력한다.")
    @ParameterizedTest
    @MethodSource("lottoCountTestData")
    void check_lotto_count(int lottoCount, String message) {
        OutputView.printLottoCount(lottoCount);
        assertThat(outputStream.toString())
                .hasToString(message);
    }

    public static Stream<Arguments> lottoCollectionTestData() {
        return Stream.of(
                Arguments.of(List.of(LOTTO_1_TO_6, LOTTO_7_TO_12), "[1, 2, 3, 4, 5, 6]\n[7, 8, 9, 10, 11, 12]\n\n"),
                Arguments.of(List.of(LOTTO_3_TO_8), "[3, 4, 5, 6, 7, 8]\n\n")
        );
    }

    @DisplayName("printLottoCollection는 발행된 로또들을 출력한다.")
    @ParameterizedTest
    @MethodSource("lottoCollectionTestData")
    void check_lotto_collection(List<Lotto> lottoCollection, String message) {
        OutputView.printLottoCollection(lottoCollection);
        assertThat(outputStream.toString())
                .hasToString(message);
    }

    @DisplayName("printResult는 당첨통계를 출력한다.")
    @Test
    void check_result() {
        // given
        NEW_GAME.initMatchingCase();
        LottoCollection lottoCollection = LottoCollection.from(List.of(LOTTO_1_TO_5_WITH_45, LOTTO_1_TO_6, LOTTO_3_TO_8));
        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        lottoCollection.applyResults(winningLotto, BONUS_NUMBER_45);
        // when
        OutputView.printResult(NEW_GAME.getResult());
        // then
        assertThat(outputStream.toString())
                .hasToString("당첨 통계\n"
                        + "---\n"
                        + "3개 일치 (5,000원) - 0개\n"
                        + "4개 일치 (50,000원) - 1개\n"
                        + "5개 일치 (1,500,000원) - 0개\n"
                        + "5개 일치, 보너스 볼 일치 (30,000,000원) - 1개\n"
                        + "6개 일치 (2,000,000,000원) - 1개\n");
    }

    @DisplayName("printProfit는 수익률을 출력한다.")
    @ParameterizedTest
    @CsvSource(value = {"12.3, 총 수익률은 12.3%입니다.", "123456.7, 총 수익률은 123456.7%입니다."})
    void check_profit(double profit, String message) {
        OutputView.printProfit(profit);

        assertThat(outputStream.toString())
                .hasToString(message);
    }
}
