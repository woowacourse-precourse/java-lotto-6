package lotto;

import lotto.v1.controller.LottoControllerV1;
import lotto.v1.model.LottoMachineV1;
import lotto.v1.view.LottoViewV1;

public class Application {
    public static void main(String[] args) {
        LottoMachineV1 lottoMachine = new LottoMachineV1();
        LottoViewV1 lottoView = new LottoViewV1();
        LottoControllerV1 lottoController = new LottoControllerV1(lottoMachine, lottoView);
        lottoController.play();
    }
}
