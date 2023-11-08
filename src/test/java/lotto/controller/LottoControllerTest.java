package lotto.controller;

import java.util.NoSuchElementException;
import lotto.service.PurchaseService;
import lotto.service.ResultService;
import lotto.service.WinningNumberService;
import lotto.view.OutputView;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import camp.nextstep.edu.missionutils.Console;

import static lotto.constant.message.InputMessage.*;
import static lotto.constant.message.OutputMessage.*;
import static lotto.constant.message.ExceptionMessage.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoControllerTest {

    private InputStream originalSystemIn;
    private PrintStream originalSystemOut;
    private ByteArrayOutputStream outputStream;

    private LottoController lottoController;

    @BeforeEach
    void setUp() {
        originalSystemIn = System.in;
        originalSystemOut = System.out;

        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        lottoController = new LottoController(new OutputView(), new PurchaseService(),
                new ResultService(), new WinningNumberService());
    }

    @AfterEach
    void tearDown() {
        System.setIn(originalSystemIn);
        System.setOut(originalSystemOut);
        Console.close();
    }

    @ParameterizedTest
    @ValueSource(strings = {"10000\n1,2,3,4,5,6\n7\n"})
    @DisplayName("올바른 값들이 입력되었을 때")
    void testPlayMethod(String input) {
        // given
        setInputStream(input);

        // when
        lottoController.play();

        // then
        assertThat(outputStream.toString()).contains(INPUT_PURCHASE.getMessage());
        assertThat(outputStream.toString()).contains(PURCHASE_LOTTO.getMessage());
        assertThat(outputStream.toString()).contains(INPUT_NUMBER.getMessage());
        assertThat(outputStream.toString()).contains(INPUT_BONUS.getMessage());
        assertThat(outputStream.toString()).contains(RESULT_START.getMessage());

    }

    @ParameterizedTest
    @ValueSource(strings = {"ab6\n", "3500\n", "삼천원"})
    @DisplayName("구매 금액에 잘못된 값을 넣은 경우")
    void testPlayMethodWithInvalidPurchaseInput(String input) {
        // given
        setInputStream(input);

        // when
        assertThrows(NoSuchElementException.class, () -> lottoController.play());

        //then
        assertThat(outputStream.toString()).contains(INPUT_PURCHASE.getMessage());
        assertThat(outputStream.toString()).contains(ERROR.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"5000\n,12,3,,4,6,8\n", "5000\n,1,2,3,4,5,6,7\n", "5000\n,1,2,3,4\n",
            "5000\n,10,46,0,56,23,21\n", "5000\n,1,2,3,3,4,5\n"})
    @DisplayName("로또 번호에 잘못된 값을 넣은 경우")
    void testPlayMethodWithInvalidWinningNumberInput(String input) {
        // given
        setInputStream(input);

        // when
        assertThrows(NoSuchElementException.class, () -> lottoController.play());

        //then
        assertThat(outputStream.toString()).contains(INPUT_PURCHASE.getMessage());
        assertThat(outputStream.toString()).contains(INPUT_NUMBER.getMessage());
        assertThat(outputStream.toString()).contains(ERROR.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"5000\n1,2,3,4,5,6\n,팔", "5000\n1,2,3,4,5,6\n,6", "5000\n1,2,3,4,5,6\n,78"})
    @DisplayName("보너스 번호에 잘못된 값을 넣은 경우")
    void testPlayMethodWithInvalidBonusInput(String input) {
        // given
        setInputStream(input);

        // when
        assertThrows(NoSuchElementException.class, () -> lottoController.play());

        //then
        assertThat(outputStream.toString()).contains(INPUT_PURCHASE.getMessage());
        assertThat(outputStream.toString()).contains(INPUT_NUMBER.getMessage());
        assertThat(outputStream.toString()).contains(INPUT_BONUS.getMessage());
        assertThat(outputStream.toString()).contains(ERROR.getMessage());
    }

    void setInputStream(String input) {
        ByteArrayInputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);
    }
}
