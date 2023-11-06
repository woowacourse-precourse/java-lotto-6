package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import camp.nextstep.edu.missionutils.Console;

class CommunicatorTest {
    static final Communicator communicator = new Communicator();

    ByteArrayOutputStream outputStream;

    static Stream<Arguments> stringAndStringProvider() {
        return Stream.of(
                Arguments.of("", "입력 금액이 비어 있습니다."),
                Arguments.of(" ", "올바른 숫자 형식이 아닙니다."),
                Arguments.of("10 000", "올바른 숫자 형식이 아닙니다."),
                Arguments.of("0", "0보다 큰 금액을 입력해주세요."),
                Arguments.of("-10000", "0보다 큰 금액을 입력해주세요."),
                Arguments.of("5500", "구매 금액은 1000원 단위여야 합니다.")
        );
    }

    static Stream<Arguments> listAndStringsProvider() {
        return Stream.of(
                Arguments.of(
                        List.of(LottoResult.FOUR_MATCHING, LottoResult.FIVE_MATCHING),
                        List.of(
                                "4개 일치 (50,000원) - 1개",
                                "5개 일치 (1,500,000원) - 1개",
                                "총 수익률은 15500.0%입니다."
                        )
                ),
                Arguments.of(
                        List.of(LottoResult.FIVE_MATCHING, LottoResult.FIVE_MATCHING),
                        List.of(
                                "5개 일치 (1,500,000원) - 2개",
                                "총 수익률은 30000.0%입니다."
                        )
                )
        );
    }

    @BeforeEach
    void setUp() {
        setOut();
    }

    @AfterEach
    void cleanUp() {
        System.setOut(System.out);
        System.setIn(System.in);
        Console.close();
    }

    @Test
    @DisplayName("금액 입력 문구를 출력한다.")
    void test_InstructorBuy_PrintPrompt() {
        //when
        assertThatThrownBy(communicator::instructBuy);

        //then
        assertThat(output()).contains("구입금액을 입력해주세요.");
    }

    @ParameterizedTest(name = "{0}원을 입력 시 출력 문구 : {1}")
    @MethodSource("stringAndStringProvider")
    @DisplayName("입력 받는 금액이 잘못되면 IllegalArgumentException을 발생시킨다.")
    void test_InstructBuyFailed(String input, String expectedMessage) {
        //given
        setIn(input);

        //when
        Exception exception = assertThrows(IllegalArgumentException.class, communicator::instructBuy);

        //then
        assertThat(exception.getMessage()).isEqualTo(expectedMessage);
    }

    @Test
    @DisplayName("구매 금액 입력을 성공한다.")
    void test_InstructBuySuccessful() {
        //given
        String input = "5000";
        setIn(input);

        //when
        BigDecimal payment = communicator.instructBuy();

        //then
        assertThat(payment).isEqualTo(new BigDecimal(input));
    }

    @Test
    @DisplayName("당첨 번호 입력 문구를 출력한다.")
    void test_InstructJackpotNumber() {
        //given
        setIn(" ");

        //when
        communicator.instructJackpotNumbers();

        //then
        assertThat(output()).contains("당첨 번호를 입력해주세요.");
    }

    @Test
    @DisplayName("보너스 번호 입력 문구를 출력한다.")
    void test_InstructBonusNumber() {
        //given
        setIn(" ");

        //when
        communicator.instructBonusNumber();

        //then
        assertThat(output()).contains("보너스 번호를 입력해 주세요.");
    }

    @ParameterizedTest
    @MethodSource("listAndStringsProvider")
    @DisplayName("당첨 내역을 출력한다.")
    void test_PrintResult(List<LottoResult> results, List<String> expectedMessages) {
        //given
        BigDecimal payment = new BigDecimal(10000);
        LottoResults lottoResults = LottoResults.of(results);

        //when
        communicator.printResults(payment, lottoResults);

        //then
        expectedMessages.forEach(message -> assertThat(output()).contains(message));
    }

    void setIn(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
    }

    void setOut() {
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
    }

    String output() {
        System.setOut(new PrintStream(outputStream));
        return outputStream.toString();
    }
}
