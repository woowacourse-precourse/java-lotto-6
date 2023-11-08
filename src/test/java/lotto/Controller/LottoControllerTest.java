package lotto.Controller;

import static lotto.Global.Exception.LOTTO_BONUS_NUMBER_INPUT;
import static lotto.Global.Exception.LOTTO_WRONG_AMOUNT_INPUT;
import static lotto.Global.PrintPhrase.PURCHASE_RESULT;
import static lotto.Global.PrintPhrase.WINNING_INFORMATION_OUTPUT;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import lotto.Model.LottoMachine;
import lotto.Model.LottoResultGenerator;
import lotto.Model.LottoVendingMachine;
import lotto.View.InputView;
import lotto.View.OutputView;
import lotto.View.View;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoControllerTest {
    private static View view = new View(new InputView(), new OutputView());
    private static LottoMachine lottoMachine = new LottoMachine(new LottoVendingMachine(), new LottoResultGenerator());
    static LottoController lottoController = new LottoController(view, lottoMachine);

    @AfterEach()
    void cleanUp() {
        Console.close();
    }

    @DisplayName("로또 판매 시 정상값을 입력했을 때를 검증")
    @Test
    void lottoValidateBuyAmount() {
        System.setIn(new ByteArrayInputStream("1000\n1,2,3,4,5,6\n7".getBytes()));
        lottoController.run();
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        assertThat(out.toString().contains(PURCHASE_RESULT.getResultState(1)));
    }

    @ParameterizedTest
    @DisplayName("로또 판매 시 비정상값을 입력했을 때를 검증")
    @ValueSource(strings = {"1009\n1000\n1,2,3,4,5,6\n7", "1000f\n1000\n1,2,3,4,5,6\n7"})
    void lottoInvalidateBuyAmount(String text) {
        System.setIn(new ByteArrayInputStream(text.getBytes()));
        lottoController.run();
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        assertThat(out.toString().contains("[ERROR]"));
    }

    @DisplayName("로또 당첨번호로 정상적인 값을 입력했을 때를 검증")
    @Test
    void winningLottoNumberValidate() {
        System.setIn(new ByteArrayInputStream("1000\n1,2,3,4,5,6\n7".getBytes()));
        lottoController.run();
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        assertThat(out.toString().contains(WINNING_INFORMATION_OUTPUT.getPhrase()));
    }

    @ParameterizedTest
    @DisplayName("로또 당첨번호로 비정상적인 값을 입력했을 때를 검증")
    @ValueSource(strings = {"1000\n1,2,3,4,5\n1,2,3,4,5,6\n7", "1000\n1,2,3,0,6,99\n1,2,3,4,5,6\n7",
            "1000\n1,2,3,4,f1,5\n1,2,3,4,5,6\n7", "1000\n1.2.3\n1,2,3,4,5,6\n7"})
    void winningLottoNumberInvalidate(String text) {
        System.setIn(new ByteArrayInputStream(text.getBytes()));
        lottoController.run();
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        assertThat(out.toString().contains(LOTTO_WRONG_AMOUNT_INPUT.getErrorPhrase()));
    }

    @ParameterizedTest
    @DisplayName("보너스 번호로 비정상적인 값을 입력했을 때의 반응")
    @ValueSource(strings = {"1000\n1,2,3,4,5,6\n46\n7", "1000\n1,2,3,4,5,6\n1f\n7"})
    void bonusNumberInvalidate(String text) {
        System.setIn(new ByteArrayInputStream(text.getBytes()));
        lottoController.run();
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        assertThat(out.toString().contains(LOTTO_BONUS_NUMBER_INPUT.getErrorPhrase()));
    }

}