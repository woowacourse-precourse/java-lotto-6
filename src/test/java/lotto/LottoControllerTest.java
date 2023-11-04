package lotto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import Controller.InputManger;
import Controller.LottoController;
import Model.InputModel;
import VIew.InputView;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class LottoControllerTest {

    @DisplayName("로또 당첨 번호를 입력받는다")
    @Test
    void testGettingLottoWinningNumbers() {

        //given
        String input = "1,2,3,4,5,6";
        InputModel inputModel = new InputModel();
        InputView inputView = new InputView();
        InputManger inputManger = new InputManger(inputView);
        LottoController lottoController = new LottoController(inputManger, inputModel);
        Lotto expectedLotto = new Lotto(Arrays.asList(1,2,3,4,5,6));

        // when
        Lotto actualLotto = lottoController.gettingLottoWinningNumbers(input);

        // then
        assertEquals(expectedLotto.getLottoArray(), actualLotto.getLottoArray());
    }
}
