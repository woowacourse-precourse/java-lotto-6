package lotto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import Controller.InputManager;
import Controller.LottoController;
import VIew.InputView;
import VIew.LottoView;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class LottoControllerTest {

    @DisplayName("로또 당첨 번호를 입력받는다")
    @Test
    void testGettingLottoWinningNumbers() {

        //given
        String input = "1,2,3,4,5,6";
        InputView inputView = new InputView();
        InputManager inputManger = new InputManager(inputView);

        LottoView lottoView = new LottoView();
        LottoController lottoController = new LottoController(inputManger, lottoView);
        Lotto expectedLotto = new Lotto(Arrays.asList(1,2,3,4,5,6));

        // when
        Lotto actualLotto = lottoController.gettingLottoWinningNumbers(input);

        // then
        assertEquals(expectedLotto.getLottoArray(), actualLotto.getLottoArray());
    }
}
