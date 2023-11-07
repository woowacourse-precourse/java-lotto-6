package lotto.controller;

import static lotto.utils.StringUtils.*;
import static lotto.view.ErrorMessage.*;
import static org.assertj.core.api.Assertions.*;

import camp.nextstep.edu.missionutils.Console;
import org.junit.jupiter.api.*;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;



class LottoControllerTest {
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    private LottoController lottoController;

    InputStream createUserInput(String input) {
        return new ByteArrayInputStream(input.getBytes());
    }

    @BeforeEach
    public void beforeEach() {
        lottoController = new LottoController();
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    public void afterEach() {
        Console.close();
        System.setOut(standardOut);
    }

    @Test
    @DisplayName("기능15 테스트 : 사용자로 부터 로또 구입 금액을 입력받아 정수로 변환해서 반환한다.")
    void receiveMoneyShouldReturnTotalPurchaseMoneyFromUserInput() {
        // given
        System.setIn(createUserInput("1000"));

        // when
        int result = lottoController.receiveMoney();

        // then
        assertThat(result).isEqualTo(1000);
    }

    @Test
    @DisplayName("기능16, 기능17 테스트 : 로또 총 구매 비용으로 입력한 값이 숫자가 아니면 예외가 발생한다.")
    void receiveMoneyShouldThrowIllegalArgumentExceptionWhenInputIsNotNumber() {
        // given
        System.setIn(createUserInput("1000j"));

        // when, then
        assertThatThrownBy(() -> lottoController.receiveMoney())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(NOT_A_NUMBER.getErrorMessage());
    }

    @Test
    @DisplayName("기능16, 기능18 테스트 : 로또 총 구매 비용으로 입력한 값이 1000의 배수가 아니면 예외가 발생한다.")
    void receiveMoneyShouldThrowIllegalArgumentExceptionWhenInputIsNotMultipleOf1000() {
        // given
        System.setIn(createUserInput("1001"));

        // when, then
        assertThatThrownBy(() -> lottoController.receiveMoney())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(RECEIVED_MONEY_NOT_MULTIPLE_OF_1000.getErrorMessage());
    }

    @Test
    @DisplayName("기능20 테스트 : 0원을 입력했을 때 로또를 하나 구매하고 그 결과를 반환한다.")
    void purchaseOneLottoWhenInputMoneyIs0() {
        // given
        int totalPurchaseAmount = 0;

        // when
        lottoController.showPurchaseResult(totalPurchaseAmount);
        String result = outputStreamCaptor.toString();
        int count = countOccurrences(result, "[");

        // then
        assertThat(result).startsWith("0개를 구매했습니다.");
        assertThat(count).isEqualTo(0);
    }


    @Test
    @DisplayName("기능20 테스트 : 1000원을 입력했을 때 로또를 하나 구매하고 그 결과를 반환한다.")
    void purchaseOneLottoWhenInputMoneyIs1000() {
        // given
        int totalPurchaseAmount = 1000;

        // when
        lottoController.showPurchaseResult(totalPurchaseAmount);
        String result = outputStreamCaptor.toString();
        int count = countOccurrences(result, "[");

        // then
        assertThat(result).startsWith("1개를 구매했습니다.");
        assertThat(count).isEqualTo(1);
    }

    @Test
    @DisplayName("기능20 테스트 : 5000원을 입력했을 때 로또 5개를 구매하고 그 결과를 반환한다.")
    void purchaseFiveLottoWhenInputMoneyIs5000() {
        // given
        int totalPurchaseAmount = 5000;

        // when
        lottoController.showPurchaseResult(totalPurchaseAmount);
        String result = outputStreamCaptor.toString();
        int count = countOccurrences(result, "[");

        // then
        assertThat(result).startsWith("5개를 구매했습니다.");
        assertThat(count).isEqualTo(5);
    }
}