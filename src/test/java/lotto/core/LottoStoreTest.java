package lotto.core;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.List;
import lotto.core.calculator.Calculator;
import lotto.core.exception.IllegalAmountException;
import lotto.core.iomanangers.OutputManager;
import lotto.core.lotto.LottoTicketScratcher;
import lotto.core.numbergenerator.NumberGenerator;
import lotto.core.numbergenerator.RandomNumberGenerator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class LottoStoreTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final static OutputManager outputManager = new OutputManager();
    private final static RandomNumberGenerator mockRandomNumberGenerator = Mockito.mock(RandomNumberGenerator.class);
    private final static RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
    private final static Calculator calculator = new Calculator();
    private final static LottoTicketScratcher lottoTicketScratcher = new LottoTicketScratcher();
    private final static NumberGenerator mockNumberGenerator = new NumberGenerator(mockRandomNumberGenerator);
    private final static NumberGenerator numberGenerator = new NumberGenerator(randomNumberGenerator);


    private InputStream originalIn;

    @BeforeEach
    public void setUpStreams() {
        originalIn = System.in;
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
        System.setIn(originalIn);
    }

    @DisplayName("통합 테스트")
    @Test
    void start() {
        final String input = "8000\n1,2,3,4,5,6\n7\n";
        LottoStore storeForTest = LottoStore.createStoreForTest(lottoTicketScratcher, calculator, mockNumberGenerator,
                outputManager);

        Mockito.when(mockRandomNumberGenerator.createRandomUniqueNumber())
                .thenReturn(List.of(1, 2, 3, 4, 11, 23)).thenReturn(List.of(11, 22, 33, 44, 32, 36))
                .thenReturn(List.of(11, 22, 33, 44, 32, 36)).thenReturn(List.of(11, 22, 33, 44, 32, 36))
                .thenReturn(List.of(11, 22, 33, 44, 32, 36)).thenReturn(List.of(11, 22, 33, 44, 32, 36))
                .thenReturn(List.of(11, 22, 33, 44, 32, 36)).thenReturn(List.of(11, 22, 33, 44, 32, 36));

        System.setIn(new ByteArrayInputStream(input.getBytes()));

        storeForTest.start();

        String output = outContent.toString();
        assertThat(output).contains("8개를 구매했습니다.");
        assertThat(output).contains("총 수익률은 625.0%입니다.");
    }

    @DisplayName("예외상황 1-1 : 금액 입력시 1000원 단위로 입력하지 아니한면 예외를 발생한다.")
    @Test
    void exceptionSituation1_1() {
        final String input = "8001\n1,2,3,4,5,6\n7\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        LottoStore storeForTest = LottoStore.createStoreForTest(lottoTicketScratcher, calculator, numberGenerator, outputManager);

        Assertions.assertThatThrownBy(storeForTest::start).isInstanceOf(IllegalAmountException.class);
    }

    @DisplayName("예외상황 1-2 : 금액 입력시 숫자가 아니면 예외를 발생한다.")
    @Test
    void exceptionSituation1_2() {
    }

    @DisplayName("예외상황 1-3 : 금액 입력시 숫자의 범위가 Integer 범위를 넘어서면 예외를 발생한다.")
    @Test
    void exceptionSituation1_3() {
    }

    @DisplayName("예외상황 2-1 : 당첨 번호 입력 시 6자리의 수가 아니면 예외를 발생한다.")
    @Test
    void exceptionSituation2_1() {
    }

    @DisplayName("예외상황 2-2 : 당첨 번호 입력 시 숫자가 아니면 예외를 발생한다.")
    @Test
    void exceptionSituation2_2() {
    }

    @DisplayName("예외상황 2-3 : 당첨 번호 입력 시 쉼표(,) 가 없으면 예외를 발생한다.")
    @Test
    void exceptionSituation2_3() {
    }

    @DisplayName("예외상황 2-4 : 당첨 번호 입력 시 중복되는 번호가 있으면 예외를 발생한다.")
    @Test
    void exceptionSituation2_4() {
    }

    @DisplayName("예외상황 2-5 : 당첨 번호 입력 시 1~45 를 넘어가는 번호가 있으면 예외를 발생한다.")
    @Test
    void exceptionSituation2_5() {
    }

    @DisplayName("예외상황 2-6 : 당첨 번호 입력 시 Integer의 범위를 넘어가는 번호가 있으면 예외를 발생한다.")
    @Test
    void exceptionSituation2_6() {
    }

    @DisplayName("예외상황 3-1 : 보너스 번호 입력 시 1~45 를 넘어가면 예외를 발생한다.")
    @Test
    void exceptionSituation3_1() {
    }

    @DisplayName("예외상황 3-2 : 보너스 번호 입력 시 Integer 범위를 넘어가면 예외를 발생한다.")
    @Test
    void exceptionSituation3_2() {
    }

    @DisplayName("예외상황 3-3 : 보너스 번호 입력 시 숫자가 아니면 예외를 발생한다.")
    @Test
    void exceptionSituation3_3() {
    }

}