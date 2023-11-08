package lotto.view.output;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.List;
import lotto.model.domain.Lotto;
import lotto.model.domain.LottoRank;
import lotto.model.dto.LottoResult;
import lotto.model.dto.LottoWallet;
import lotto.model.dto.PurchaseMoney;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class OutputViewTest {
    private final OutputView outputView = new OutputView();
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
        LottoWallet lottoWallet = new LottoWallet(List.of(lotto));

        outputView.printLottos(lottoWallet);

        Assertions.assertThat(output())
                .contains("1개를 구매했습니다.",
                        "[1, 2, 3, 4, 5, 6]");
    }

    @Test
    @DisplayName("로또 결과 출력 형식 테스트")
    public void printLottoResultTest() {
        LottoResult lottoResult = new LottoResult(
                List.of(LottoRank.FIRST_PLACE, LottoRank.FIRST_PLACE, LottoRank.SECOND_PLACE), 0);
        outputView.printLottoRanks(lottoResult);

        Assertions.assertThat(output())
                .contains("당첨 통계",
                        "---",
                        "3개 일치 (5,000원) - 0개",
                        "4개 일치 (50,000원) - 0개",
                        "5개 일치 (1,500,000원) - 0개",
                        "5개 일치, 보너스 볼 일치 (30,000,000원) - 1개",
                        "6개 일치 (2,000,000,000원) - 2개"
                );
    }

    @Test
    @DisplayName("로또 결과 출력 형식 테스트2")
    public void printLottoResultTest2() {
        LottoResult lottoResult = new LottoResult(List.of(LottoRank.values()), 0);

        outputView.printLottoRanks(lottoResult);

        Assertions.assertThat(output())
                .contains("당첨 통계",
                        "---",
                        "3개 일치 (5,000원) - 1개",
                        "4개 일치 (50,000원) - 1개",
                        "5개 일치 (1,500,000원) - 1개",
                        "5개 일치, 보너스 볼 일치 (30,000,000원) - 1개",
                        "6개 일치 (2,000,000,000원) - 1개"
                );
    }

    @Test
    @DisplayName("수익률 출력 포맷 정수")
    public void earningRateFormatInteger() {
        LottoResult lottoResult = new LottoResult(List.of(), 14000000);
        PurchaseMoney purchaseMoney = new PurchaseMoney(1000);

        outputView.printEarningRate(lottoResult, purchaseMoney);

        Assertions.assertThat(output())
                .isEqualTo("총 수익률은 1,400,000.0%입니다.");
    }

    @Test
    @DisplayName("수익률 출력 포맷 실수")
    public void earningRateFormatDecimal() {
        LottoResult lottoResult = new LottoResult(List.of(), 14000000);
        PurchaseMoney purchaseMoney = new PurchaseMoney(67000);

        outputView.printEarningRate(lottoResult, purchaseMoney);

        Assertions.assertThat(output())
                .isEqualTo("총 수익률은 20,895.5%입니다.");
    }

    @Test
    @DisplayName("수익률 출력 포맷 실수 반올림 X")
    public void earningRateFormatDecimalHalfUp_X() {
        LottoResult lottoResult = new LottoResult(List.of(), 14000000);
        PurchaseMoney purchaseMoney = new PurchaseMoney(68000);

        outputView.printEarningRate(lottoResult, purchaseMoney);

        Assertions.assertThat(output())
                .isEqualTo("총 수익률은 20,588.2%입니다.");
    }

    @Test
    @DisplayName("수익률 출력 포맷 실수 반올림 O")
    public void earningRateFormatDecimalHalfUp_O() {
        LottoResult lottoResult = new LottoResult(List.of(), 14000000);
        PurchaseMoney purchaseMoney = new PurchaseMoney(66000);

        outputView.printEarningRate(lottoResult, purchaseMoney);

        Assertions.assertThat(output())
                .isEqualTo("총 수익률은 21,212.1%입니다.");
    }

    @Test
    @DisplayName("수익률 출력 0.0%")
    public void earningRateFormatZero() {
        LottoResult lottoResult = new LottoResult(List.of(), 0);
        PurchaseMoney purchaseMoney = new PurchaseMoney(8000);

        outputView.printEarningRate(lottoResult, purchaseMoney);

        Assertions.assertThat(output())
                .isEqualTo("총 수익률은 0.0%입니다.");
    }
    
}