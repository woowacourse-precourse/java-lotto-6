package lotto.view.output;

import lotto.model.domain.Lotto;
import lotto.model.domain.LottoRank;
import lotto.model.dto.LottoResult;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.List;

class OutputViewTest {
    private PrintStream standardOut;
    private OutputStream captor;

    @BeforeEach
    protected final void init() {
        standardOut = System.out;
        captor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(captor));
    }

    @AfterEach
    protected final void printOutput() {
        System.setOut(standardOut);
        System.out.println(output());
    }

    protected final String output() {
        return captor.toString().trim();
    }

    @Test
    @DisplayName("로또 출력 형식 테스트")
    public void printLottoTest() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        OutputView outputView = new OutputView();

        outputView.printLottos(List.of(lotto));

        Assertions.assertThat(output())
                .contains("1개를 구매했습니다.",
                        "[1, 2, 3, 4, 5, 6]");
    }

    @Test
    @DisplayName("로또 결과 출력 형식 테스트")
    public void printLottoResultTest() {
        LottoResult lottoResult = new LottoResult();
        lottoResult.addResult(LottoRank.FIRST_PLACE);
        lottoResult.addResult(LottoRank.FIRST_PLACE);
        lottoResult.addResult(LottoRank.SECOND_PLACE);

        OutputView outputView = new OutputView();

        outputView.printLottoResult(lottoResult, 5000);

        Assertions.assertThat(output())
                .contains("당첨 통계",
                        "---",
                        "3개 일치 (5,000원) - 0개",
                        "4개 일치 (50,000원) - 0개",
                        "5개 일치 (1,500,000원) - 0개",
                        "5개 일치, 보너스 볼 일치 (30,000,000원) - 1개",
                        "6개 일치 (2,000,000,000원) - 2개",
                        "총 수익률은 80,600,000.0%입니다."
                );
    }

    @Test
    @DisplayName("로또 결과 출력 형식 테스트2")
    public void printLottoResultTest2() {
        LottoResult lottoResult = new LottoResult();
        lottoResult.addResult(LottoRank.FIRST_PLACE);
        lottoResult.addResult(LottoRank.SECOND_PLACE);
        lottoResult.addResult(LottoRank.THIRD_PLACE);
        lottoResult.addResult(LottoRank.FOURTH_PLACE);
        lottoResult.addResult(LottoRank.FIFTH_PLACE);
        lottoResult.addResult(LottoRank.NO_LUCK);

        OutputView outputView = new OutputView();

        outputView.printLottoResult(lottoResult, 6000);

        Assertions.assertThat(output())
                .contains("당첨 통계",
                        "---",
                        "3개 일치 (5,000원) - 1개",
                        "4개 일치 (50,000원) - 1개",
                        "5개 일치 (1,500,000원) - 1개",
                        "5개 일치, 보너스 볼 일치 (30,000,000원) - 1개",
                        "6개 일치 (2,000,000,000원) - 1개",
                        "총 수익률은 33,859,250.0%입니다."
                );
    }

    @Test
    @DisplayName("수익률 출력 포맷 정수")
    public void earningRateFormatInteger() {
        OutputView outputView = new OutputView();
        String format = outputView.calculateEarningRateAndFormat(1000, 14000000);

        Assertions.assertThat(format)
                .isEqualTo("1,400,000.0");
    }

    @Test
    @DisplayName("수익률 출력 포맷 실수")
    public void earningRateFormatDecimal() {
        OutputView outputView = new OutputView();
        String format = outputView.calculateEarningRateAndFormat(67000, 14000000);

        Assertions.assertThat(format)
                .isEqualTo("20,895.5");
    }

    @Test
    @DisplayName("수익률 출력 포맷 실수 반올림 X")
    public void earningRateFormatDecimalHalfUp_X() {
        OutputView outputView = new OutputView();
        String format = outputView.calculateEarningRateAndFormat(68000, 14000000);

        Assertions.assertThat(format)
                .isEqualTo("20,588.2");
    }

    @Test
    @DisplayName("수익률 출력 포맷 실수 반올림 O")
    public void earningRateFormatDecimalHalfUp_O() {
        OutputView outputView = new OutputView();
        String format = outputView.calculateEarningRateAndFormat(66000, 14000000);

        Assertions.assertThat(format)
                .isEqualTo("21,212.1");
    }
}