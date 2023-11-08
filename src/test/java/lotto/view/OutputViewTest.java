package lotto.view;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import lotto.global.util.StringConverter.IntegerListToStringConverter;
import lotto.model.LottoNumbers;
import lotto.model.LottoTickets;
import lotto.model.WinningStatistic;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class OutputViewTest {
    OutputView outputView = OutputView.getInstance();
    IntegerListToStringConverter integerListToStringConverter = IntegerListToStringConverter.getInstance();
    private ByteArrayOutputStream outputStream;
    private PrintStream printStream;

    @BeforeEach
    void setUp() {
        printStream = System.out;
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
    }

    @AfterEach
    void tearDown() {
        System.setOut(printStream);
        System.out.println(getOutput());
    }

    private String getOutput(){
        return outputStream.toString();
    }

    @Test
    @DisplayName("구입금액 입력 공지 출력")
    void printInputPurchaseAmountNotice() {
        outputView.printInputPurchaseAmountNotice();
        Assertions.assertThat(getOutput()).contains("구입금액을 입력해 주세요.");
    }

    @Test
    @DisplayName("구입 금액 출력")
    void printOutputPurchaseAmount() {
        outputView.printOutputPurchaseAmount(8);
        Assertions.assertThat(getOutput()).contains("8개를 구매했습니다.");
    }

    @Test
    @DisplayName("구매한 로또 티켓 정보 출력")
    void printPurchaseLottoTicketsInfo() {
        LottoTickets lottoTickets = new LottoTickets(Arrays.asList(new LottoNumbers(Arrays.asList(1, 2, 3, 4, 5, 6)),
                new LottoNumbers(Arrays.asList(1, 7, 8, 9, 10, 11))));
        outputView.printPurchaseLottoTicketsInfo(lottoTickets);
        Assertions.assertThat(getOutput()).contains("[1,2,3,4,5,6]");
    }

    @Test
    @DisplayName("당첨 번호 입력 공지 출력")
    void printInputWinningNumbersNotice() {
        outputView.printInputWinningNumbersNotice();
        Assertions.assertThat(getOutput()).contains("당첨 번호를 입력해 주세요.");
    }

    @Test
    @DisplayName("보너스 번호 입력 공지 출력")
    void printInputBonusNumberNotice() {
        outputView.printInputBonusNumberNotice();
        Assertions.assertThat(getOutput()).contains("보너스 번호를 입력해 주세요.");
    }

    @Test
    @DisplayName("당첨 통계 출력")
    void printWinningStatisticsInfo() {
        WinningStatistic winningStatistic = new WinningStatistic(1, 0, 1, 2, 3);
        outputView.printWinningStatisticsInfo(winningStatistic);
        Assertions.assertThat(getOutput()).contains("3개 일치 (5,000원) - 1개\n"
                + "4개 일치 (50,000원) - 0개\n"
                + "5개 일치 (1,500,000원) - 1개\n"
                + "5개 일치, 보너스 볼 일치 (30,000,000원) - 2개\n"
                + "6개 일치 (2,000,000,000원) - 3개");
    }

    @Test
    @DisplayName("총 수익률 출력")
    void printTotalReturn() {
        outputView.printTotalReturn(62.5F);
        Assertions.assertThat(getOutput()).contains("총 수익률은 62.5%입니다.");
    }
}