package lotto.core;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.List;
import java.util.stream.Stream;
import lotto.core.calculator.Calculator;
import lotto.core.iomanangers.MessageManager;
import lotto.core.lotto.LottoTicketScratcher;
import lotto.core.numbergenerator.NumberGenerator;
import lotto.core.numbergenerator.RandomNumberGenerator;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
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

    @ParameterizedTest
    @MethodSource("provideInputForExceptionTesting")
    @DisplayName("다양한 입력에 대한 예외 메시지 출력을 테스트한다.")
    void testInputExceptionMessages(String input, String expectedExceptionMessage) {
        //given
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        //when
        storeForTest.start();
        String output = outContent.toString();

        //then
        assertThat(output).contains(expectedExceptionMessage);
    }

    static Stream<Arguments> provideInputForExceptionTesting() {
        return Stream.of(
                Arguments.of("8100\n8000\n1,2,3,4,5,6\n7\n", ILLEGAL_AMOUNT_EXCEPTION_MESSAGE),
                Arguments.of("800s0\n8000\n1,2,3,4,5,6\n7\n", ILLEGAL_NUMBER_TYPE_EXCEPTION_MESSAGE),
                Arguments.of( "80000000000000\n8000\n1,2,3,4,5,6\n7\n", ILLEGAL_NUMBER_RANGE_EXCEPTION_MESSAGE),
                Arguments.of( "8000\n1,2,3,4,5\n1,2,3,4,5,6\n7\n", ILLEGAL_LOTTO_SIZE_EXCEPTION_MESSAGE),
                Arguments.of( "8000\n112345\n1,2,3,4,5,6\n7\n", ILLEGAL_LOTTO_SIZE_EXCEPTION_MESSAGE),
                Arguments.of( "8000\n1,2,3,4,4,4\n1,2,3,4,5,6\n7\n", ILLEGAL_DUPLICATE_EXCEPTION_MESSAGE),
                Arguments.of( "8000\n1,2,3,4,5,54\n1,2,3,4,5,6\n7\n", ILLEGAL_LOTTO_RANGE_EXCEPTION_MESSAGE),
                Arguments.of( "8000\n11234511111111111111\n1,2,3,4,5,6\n7\n", ILLEGAL_NUMBER_RANGE_EXCEPTION_MESSAGE),
                Arguments.of( "8000\n1,2,3,4,5,6\n99\n7\n", ILLEGAL_LOTTO_RANGE_EXCEPTION_MESSAGE),
                Arguments.of( "8000\n1,2,3,4,5,6\n9999999999999999999999999\n7\n", ILLEGAL_NUMBER_RANGE_EXCEPTION_MESSAGE),
                Arguments.of( "8000\n1,2,3,4,5,6\ns9\n7\n", ILLEGAL_NUMBER_TYPE_EXCEPTION_MESSAGE)
        );
    }
}