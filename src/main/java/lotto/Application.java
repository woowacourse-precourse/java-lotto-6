package lotto;

import lotto.domain.controller.LottoController;
import lotto.domain.util.generator.ILottoNumberGenerator;
import lotto.domain.util.generator.LottoNumberGenerator;
import lotto.domain.util.referee.ILottoReferee;
import lotto.domain.util.referee.LottoReferee;

public class Application {
    public static void main(String[] args) {
        LottoController lottoController = initGameController();
        lottoController.run();
    }

    private static LottoController initGameController() {
        ILottoNumberGenerator iLottoNumberGenerator = new LottoNumberGenerator();
        ILottoReferee iLottoReferee = new LottoReferee();

        return new LottoController(iLottoNumberGenerator, iLottoReferee);
    }
}
