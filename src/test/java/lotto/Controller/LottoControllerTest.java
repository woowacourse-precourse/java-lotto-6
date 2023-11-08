package lotto.Controller;

import static lotto.Global.Exception.LOTTO_BONUS_NUMBER_INPUT;
import static lotto.Global.Exception.LOTTO_PURCHASE_INPUT;
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
import org.junit.jupiter.api.Test;

class LottoControllerTest {
    private static View view = new View(new InputView(), new OutputView());
    private static LottoMachine lottoMachine = new LottoMachine(new LottoVendingMachine(), new LottoResultGenerator());
    static LottoController lottoController = new LottoController(view, lottoMachine);

    @AfterEach()
    void cleanUp() {
        Console.close();
    }

    @Test
    void 로또_판매_정상값_검증() {
        System.setIn(new ByteArrayInputStream("1000\n1,2,3,4,5,6\n7".getBytes()));
        lottoController.run();
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        assertThat(out.toString().contains(PURCHASE_RESULT.getResultState(1)));
    }

    @Test
    void 로또_판매_비정상값_검증() {
        System.setIn(new ByteArrayInputStream("1009\n1000\n1,2,3,4,5,6\n7".getBytes()));
        lottoController.run();
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        assertThat(out.toString().contains(LOTTO_PURCHASE_INPUT.getErrorPhrase()));
    }

    @Test
    void 로또_당첨번호_정상값_검증() {
        System.setIn(new ByteArrayInputStream("1000\n1,2,3,4,5,6\n7".getBytes()));
        lottoController.run();
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        assertThat(out.toString().contains(WINNING_INFORMATION_OUTPUT.getPhrase()));
    }

    @Test
    void 로또_당첨번호_비정상값_검증() {
        System.setIn(new ByteArrayInputStream("1000\n1,2,3,4,5\n1,2,3,4,5,6\n7".getBytes()));
        lottoController.run();
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        assertThat(out.toString().contains(LOTTO_WRONG_AMOUNT_INPUT.getErrorPhrase()));
    }

    @Test
    void 로또_보너스번호_비정상값_검증() {
        System.setIn(new ByteArrayInputStream("1000\n1,2,3,4,5,6\n46\n7".getBytes()));
        lottoController.run();
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        assertThat(out.toString().contains(LOTTO_BONUS_NUMBER_INPUT.getErrorPhrase()));
    }

}