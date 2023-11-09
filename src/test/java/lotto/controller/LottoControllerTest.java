package lotto.controller;

import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import lotto.exception.defaultexception.DefaultErrorMessage;
import lotto.exception.lottoamountexception.AmountErrorMessage;
import lotto.exception.lottonumbersexception.NumbersErrorMessage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoControllerTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private LottoController lottoController;

    @BeforeEach
    void setUp() {
        lottoController = new LottoController();
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    void tearDown() {
        Console.close();
        System.setOut(originalOut);
    }

    @ParameterizedTest(name = "입력값 {0}에 대한 예외처리 테스트")
    @ValueSource(strings = {"5000\n1,2,3,4,5,6\n7\n", "1000\n1,2,3,4,5,6\n40\n", "5000\n1,2,3,4,5,6\n7\n"})
    @DisplayName("통합 테스트 - 정상 입력")
    void testRunMethod(String input) {
        // given
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        // when
        lottoController.run();

        // then
        String output = outContent.toString();
        assertThat(output).contains("구매 금액을 입력해 주세요.");
        assertThat(output).contains("개를 구매했습니다.");
        assertThat(output).contains("당첨 통계");
        assertThat(output).contains("%입니다.");
    }

    @ParameterizedTest(name = "입력값 {0}에 대한 예외처리 테스트")
    @ValueSource(strings = {"5000j\n5000\n1,2,3,4,5,6\n7\n", "a1000\n1000\n1,2,3,4,5,6\n40\n"})
    @DisplayName("통합 테스트 - 기본 입력 오류")
    void testRunMethodWithWrongDefaultInput(String input) {
        // given
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        String[] defaultErrorMessages = Arrays.stream(DefaultErrorMessage.values())
                .map(DefaultErrorMessage::getMessage)
                .toArray(String[]::new);

        // when
        lottoController.run();

        // then
        String output = outContent.toString();
        assertThat(output).contains("구매 금액을 입력해 주세요."); 
        assertThat(output).contains("개를 구매했습니다.");
        assertThat(output).contains("당첨 통계"); 
        assertThat(output).contains("%입니다.");
        assertThat(output).containsAnyOf(defaultErrorMessages);
    }

    @ParameterizedTest(name = "입력값 {0}에 대한 예외처리 테스트")
    @ValueSource(strings = {"0\n1000\n1,2,3,4,5,6\n7\n", "999\n2000\n1,2,3,4,5,6\n40\n"})
    @DisplayName("통합 테스트 - 금액 입력 오류")
    void testRunMethodWithWrongAmount(String input) {
        // given
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        String[] amountErrorMessages = Arrays.stream(AmountErrorMessage.values())
                .map(AmountErrorMessage::getMessage)
                .toArray(String[]::new);

        // when
        lottoController.run();

        // then
        String output = outContent.toString();
        assertThat(output).contains("구매 금액을 입력해 주세요.");
        assertThat(output).contains("개를 구매했습니다.");
        assertThat(output).contains("당첨 통계");
        assertThat(output).contains("%입니다.");
        assertThat(output).containsAnyOf(amountErrorMessages);
    }

    @ParameterizedTest(name = "입력값 {0}에 대한 예외처리 테스트")
    @ValueSource(strings = {"1000\n0,2,3,4,5,6\n1,2,3,4,5,6\n7\n", "1000\n1,49,3,4,5,6\n1,2,3,4,5,6\n40\n"})
    @DisplayName("통합 테스트 - 로또 번호 입력 오류")
    void testRunMethodWithWrongLottoNumber(String input) {
        // given
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        String[] errorMessages = Arrays.stream(NumbersErrorMessage.values())
                .map(NumbersErrorMessage::getMessage)
                .toArray(String[]::new);

        // when
        lottoController.run();

        // then
        String output = outContent.toString();
        assertThat(output).contains("구매 금액을 입력해 주세요.");
        assertThat(output).contains("개를 구매했습니다.");
        assertThat(output).contains("당첨 통계");
        assertThat(output).contains("%입니다.");
        assertThat(output).containsAnyOf(errorMessages);
    }
}