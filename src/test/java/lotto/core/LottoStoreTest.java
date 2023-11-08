package lotto.core;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.List;
import lotto.core.calculator.Calculator;
import lotto.core.iomanangers.MessageManager;
import lotto.core.lotto.LottoTicketScratcher;
import lotto.core.numbergenerator.NumberGenerator;
import lotto.core.numbergenerator.RandomNumberGenerator;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class LottoStoreTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final static MessageManager CONSOLE_OUTPUT_MANAGER = new MessageManager();
    private final static RandomNumberGenerator mockRandomNumberGenerator = Mockito.mock(RandomNumberGenerator.class);
    private final static Calculator calculator = new Calculator();
    private final static LottoTicketScratcher lottoTicketScratcher = new LottoTicketScratcher();
    private final static NumberGenerator mockNumberGenerator = new NumberGenerator(mockRandomNumberGenerator);
    private final static LottoStore storeForTest = LottoStore.createStoreForTest(lottoTicketScratcher, calculator,
            mockNumberGenerator,
            CONSOLE_OUTPUT_MANAGER);
    private final static String ILLEGAL_AMOUNT_EXCEPTION_MESSAGE = "[ERROR] 최소단위는 1,000원이며 2,147,483,000원 까지 입력 가능합니다.";
    private final static String ILLEGAL_NUMBER_TYPE_EXCEPTION_MESSAGE = "[ERROR] 반드시 숫자만 입력하셔야 합니다.";
    private final static String ILLEGAL_NUMBER_RANGE_EXCEPTION_MESSAGE = "[ERROR] 수의 범위를 벗어났습니다. 다시 입력해 주세요.";
    private final static String ILLEGAL_LOTTO_RANGE_EXCEPTION_MESSAGE = "[ERROR] 번호의 값은 1 ~ 45 사이의 정수 입니다.";
    private final static String ILLEGAL_LOTTO_SIZE_EXCEPTION_MESSAGE = "[ERROR] 로또 번호는 6자리 입니다.";
    private final static String ILLEGAL_DUPLICATE_EXCEPTION_MESSAGE = "[ERROR] 번호는 중복되지 말아야 합니다.";
    private InputStream originalIn;

    @BeforeEach
    public void setUpStreams() {
        originalIn = System.in;
        System.setOut(new PrintStream(outContent));
    }

    @BeforeEach
    public void setMock() {
        Mockito.when(mockRandomNumberGenerator.createRandomUniqueNumber())
                .thenReturn(List.of(1, 2, 3, 4, 11, 23)).thenReturn(List.of(11, 22, 33, 44, 32, 36))
                .thenReturn(List.of(11, 22, 33, 44, 32, 36)).thenReturn(List.of(11, 22, 33, 44, 32, 36))
                .thenReturn(List.of(11, 22, 33, 44, 32, 36)).thenReturn(List.of(11, 22, 33, 44, 32, 36))
                .thenReturn(List.of(11, 22, 33, 44, 32, 36)).thenReturn(List.of(11, 22, 33, 44, 32, 36));
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
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        storeForTest.start();

        String output = outContent.toString();
        assertThat(output).contains("8개를 구매했습니다.");
        assertThat(output).contains("총 수익률은 625.0%입니다.");
    }

    @DisplayName("예외상황 1-1 : 금액 입력시 1000원 단위로 입력하지 아니하면 예외메시지를 출력한다.")
    @Test
    void exceptionSituation1_1() {
        //given
        final String input = "8100\n8000\n1,2,3,4,5,6\n7\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        //when
        storeForTest.start();
        String output = outContent.toString();

        //then
        assertThat(output).contains(ILLEGAL_AMOUNT_EXCEPTION_MESSAGE);
    }

    @DisplayName("예외상황 1-2 : 금액 입력시 숫자가 아니면 예외메시지를 출력한다.")
    @Test
    void exceptionSituation1_2() {
        //given
        final String input = "800s0\n8000\n1,2,3,4,5,6\n7\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        //when
        storeForTest.start();

        //then
        String output = outContent.toString();
        assertThat(output).contains(ILLEGAL_NUMBER_TYPE_EXCEPTION_MESSAGE);
    }

    @DisplayName("예외상황 1-3 : 금액 입력시 숫자의 범위가 Integer 범위를 넘어서면 예외메시지를 출력한다.")
    @Test
    void exceptionSituation1_3() {
        //given
        final String input = "80000000000000\n8000\n1,2,3,4,5,6\n7\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        //when
        storeForTest.start();

        //then
        String output = outContent.toString();
        assertThat(output).contains(ILLEGAL_NUMBER_RANGE_EXCEPTION_MESSAGE);
    }

    @DisplayName("예외상황 2-1 : 당첨 번호 입력 시 6자리의 수가 아니면 예외메시지를 출력한다.")
    @Test
    void exceptionSituation2_1() {
        //given
        final String input = "8000\n1,2,3,4,5\n1,2,3,4,5,6\n7\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        //when
        storeForTest.start();

        //then
        String output = outContent.toString();
        assertThat(output).contains(ILLEGAL_LOTTO_SIZE_EXCEPTION_MESSAGE);
    }

    @DisplayName("예외상황 2-2 : 당첨 번호 입력 시 숫자가 아니면 예외메시지를 출력한다.")
    @Test
    void exceptionSituation2_2() {
        //given
        final String input = "8000\n1,2,3,4,s\n1,2,3,4,5,6\n7\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        //when
        storeForTest.start();

        //then
        String output = outContent.toString();
        assertThat(output).contains(ILLEGAL_NUMBER_TYPE_EXCEPTION_MESSAGE);
    }

    @DisplayName("예외상황 2-3 : 당첨 번호 입력 시 쉼표(,) 가 없으면 예외메시지를 출력한다.")
    @Test
    void exceptionSituation2_3() {
        //given
        final String input = "8000\n112345\n1,2,3,4,5,6\n7\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        //when
        storeForTest.start();

        //then
        String output = outContent.toString();
        assertThat(output).contains(ILLEGAL_LOTTO_SIZE_EXCEPTION_MESSAGE);
    }

    @DisplayName("예외상황 2-4 : 당첨 번호 입력 시 중복되는 번호가 있으면 예외메시지를 출력한다.")
    @Test
    void exceptionSituation2_4() {
        //given
        final String input = "8000\n1,2,3,4,4,4\n1,2,3,4,5,6\n7\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        //when
        storeForTest.start();

        //then
        String output = outContent.toString();
        assertThat(output).contains(ILLEGAL_DUPLICATE_EXCEPTION_MESSAGE);
    }

    @DisplayName("예외상황 2-5 : 당첨 번호 입력 시 1~45 를 넘어가는 번호가 있으면 예외메시지를 출력한다.")
    @Test
    void exceptionSituation2_5() {
        //given
        final String input = "8000\n1,2,3,4,5,54\n1,2,3,4,5,6\n7\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        //when
        storeForTest.start();

        //then
        String output = outContent.toString();
        assertThat(output).contains(ILLEGAL_LOTTO_RANGE_EXCEPTION_MESSAGE);
    }

    @DisplayName("예외상황 2-6 : 당첨 번호 입력 시 Integer 범위를 넘어가는 번호가 있으면 예외메시지를 출력한다.")
    @Test
    void exceptionSituation2_6() {
        //given
        final String input = "8000\n11234511111111111111\n1,2,3,4,5,6\n7\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        //when
        storeForTest.start();

        //then
        String output = outContent.toString();
        assertThat(output).contains(ILLEGAL_NUMBER_RANGE_EXCEPTION_MESSAGE);
    }

    @DisplayName("예외상황 3-1 : 보너스 번호 입력 시 1~45 를 넘어가면 예외메시지를 출력한다.")
    @Test
    void exceptionSituation3_1() {
        //given
        final String input = "8000\n1,2,3,4,5,6\n99\n7\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        //when
        storeForTest.start();

        //then
        String output = outContent.toString();
        assertThat(output).contains(ILLEGAL_LOTTO_RANGE_EXCEPTION_MESSAGE);
    }

    @DisplayName("예외상황 3-2 : 보너스 번호 입력 시 Integer 범위를 넘어가면 예외메시지를 출력한다.")
    @Test
    void exceptionSituation3_2() {
        //given
        final String input = "8000\n1,2,3,4,5,6\n9999999999999999999999999\n7\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        //when
        storeForTest.start();

        //then
        String output = outContent.toString();
        assertThat(output).contains(ILLEGAL_NUMBER_RANGE_EXCEPTION_MESSAGE);
    }

    @DisplayName("예외상황 3-3 : 보너스 번호 입력 시 숫자가 아니면 예외메시지를 출력한다.")
    @Test
    void exceptionSituation3_3() {
        //given
        final String input = "8000\n1,2,3,4,5,6\ns9\n7\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        //when
        storeForTest.start();

        //then
        String output = outContent.toString();
        assertThat(output).contains(ILLEGAL_NUMBER_TYPE_EXCEPTION_MESSAGE);
    }

}