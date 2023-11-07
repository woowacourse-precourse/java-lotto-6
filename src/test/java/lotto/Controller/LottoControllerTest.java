package lotto.Controller;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import lotto.Global.Exception;
import lotto.Global.LottoResult;
import lotto.Global.PrintPhrase;
import lotto.Model.LottoMachine;
import lotto.Model.LottoResultGenerator;
import lotto.Model.LottoVendingMachine;
import lotto.View.InputView;
import lotto.View.OutputView;
import lotto.View.View;

class LottoControllerTest {
    private static View view = new View(new InputView(), new OutputView());
    private static LottoMachine lottoMachine = new LottoMachine(new LottoVendingMachine(), new LottoResultGenerator());
    static LottoController lottoController = new LottoController(view, lottoMachine);

    void 로또_판매_정상값_검증() {
        System.setIn(new ByteArrayInputStream("1000".getBytes()));
        lottoController.run();
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        assertThat(out.toString().contains(LottoResult.PURCHASE_RESULT.getResultState(1)));
        verify(lottoMachine, times(1)).buyLottos(1);
    }

    void 로또_판매_비정상값_검증() {
        System.setIn(new ByteArrayInputStream("1009".getBytes()));
        lottoController.run();
        assertThatThrownBy(() -> lottoController.run()).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Exception.LOTTO_PURCHASE_INPUT.getErrorPhrase());
    }

    void 로또_당첨번호_정상값_검증() {
        System.setIn(new ByteArrayInputStream("1000\n1,2,3,4,5,6\n7".getBytes()));
        lottoController.run();
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        assertThat(out.toString().contains(PrintPhrase.WINNING_INFORMATION_OUTPUT.getPhrase()));
    }

    void 로또_당첨번호_비정상값_검증() {
        System.setIn(new ByteArrayInputStream("1000\n1,2,3,4,5".getBytes()));
        lottoController.run();
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        assertThat(out.toString().contains(Exception.LOTTO_WRONG_AMOUNT_INPUT.getErrorPhrase()));
    }

}