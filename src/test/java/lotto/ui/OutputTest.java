package lotto.ui;

import static lotto.constants.Message.BONUS_NUMBER;
import static lotto.constants.Message.PURCHASE_LOTTO;
import static lotto.constants.Message.PURCHASE_MONEY;
import static lotto.constants.Message.WINNING_NUMBER;
import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import lotto.constants.Prize;
import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class OutputTest {
    private OutputStream out;

    @BeforeEach
    void beforeEach() {
        // given
        out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
    }

    @DisplayName("예외 발생 시, 예외 처리 메시지만 출력")
    @Test
    void printError() {
        // when
        try {
            throw new IllegalArgumentException("[ERROR] 예외 처리 메시지");
        } catch (IllegalArgumentException ex) {
            Output.printError(ex);
        }

        // then
        assertThat(out.toString())
                .contains("[ERROR] 예외 처리 메시지");
    }

    @DisplayName("금액 입력할 때, 출력")
    @Test
    void printPurchase() {
        // when
        Output.printPurchase();

        // then
        assertThat(out.toString())
                .contains(PURCHASE_MONEY.getMessage());
    }

    @DisplayName("구매한 로또 개수 출력")
    @Test
    void printCount() {
        // given
        Integer lottoCount = 8;

        // when
        Output.printCount(lottoCount);

        // then
        assertThat(out.toString())
                .contains(lottoCount + PURCHASE_LOTTO.getMessage());
    }

    @DisplayName("로또 번호를 오름차순으로 정렬하여 구매한 로또 전체 출력")
    @Test
    void printLottos() {
        // given
        List<Lotto> lottos = new ArrayList<>();
        lottos.add(new Lotto(List.of(6, 5, 4, 3, 2, 1)));
        lottos.add(new Lotto(List.of(20, 30, 10, 40, 1, 45)));

        // when
        Output.printLottos(lottos);

        // then
        assertThat(out.toString())
                .contains("[1, 2, 3, 4, 5, 6]")
                .contains("[1, 10, 20, 30, 40, 45]");
    }

    @DisplayName("당첨 번호 입력할 때, 출력")
    @Test
    void printWinningNumber() {
        // when
        Output.printWinningNumber();

        // then
        assertThat(out.toString())
                .contains(WINNING_NUMBER.getMessage());
    }

    @DisplayName("보너스 번호 입력할 때, 출력")
    @Test
    void printBonusNumber() {
        // when
        Output.printBonusNumber();

        // then
        assertThat(out.toString())
                .contains(BONUS_NUMBER.getMessage());
    }

    @DisplayName("당첨 통계 출력, 수익률은 둘째 자리에서 반올림")
    @Test
    void printResultAndRoundingOffEarningsRate() {
        // given
        LottoResult lottoResult = new LottoResult();
        lottoResult.state.replace(Prize.FIFTH, 1);   // 5등 5000원, 1개

        Double earningsRate = lottoResult.calculateEarningsRate(9); // 로또 9장, 55.5555...6 %

        // when
        Output.printResult(lottoResult, earningsRate);

        // then
        assertThat(out.toString())
                .contains("당첨 통계")
                .contains("---")
                .contains("3개 일치 (5,000원) - 1개")
                .contains("4개 일치 (50,000원) - 0개")
                .contains("5개 일치 (1,500,000원) - 0개")
                .contains("5개 일치, 보너스 볼 일치 (30,000,000원) - 0개")
                .contains("6개 일치 (2,000,000,000원) - 0개")
                .contains("총 수익률은 55.6%입니다.");
    }

    @DisplayName("수익률을 천 단위마다 콤마로 구분하여 출력")
    @Test
    void printUsingCommaEarningsRate() {
        // given
        LottoResult lottoResult = new LottoResult();
        lottoResult.state.replace(Prize.FIRST, 1);   // 1등 2,000,000,000원, 1개

        Double earningsRate = lottoResult.calculateEarningsRate(1); // 로또 1장, 200,000,000.0%

        // when
        Output.printResult(lottoResult, earningsRate);

        // then
        assertThat(out.toString())
                .contains("총 수익률은 200,000,000.0%입니다.");
    }
}
