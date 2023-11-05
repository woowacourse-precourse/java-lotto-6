package lotto;

import lotto.LottoGameController.LottoGameController;
import lotto.util.Utils;
import lotto.util.Input;
import lotto.util.Output;

public class Application {

    public static void main(String[] args) throws IllegalArgumentException {


        // TODO: 프로그램 구현

        LottoGameController lottoGameController = new LottoGameController(new Input(), new Output(), new Utils());
        lottoGameController.start();
    }
}
