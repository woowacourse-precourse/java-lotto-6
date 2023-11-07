package lotto;

import lotto.v2.controller.LottoControllerV2;
import lotto.v2.model.LottoMachineV2;
import lotto.v2.view.LottoViewV2;

public class Application {
    public static void main(String[] args) {
        LottoMachineV2 lottoMachine = new LottoMachineV2();
        LottoViewV2 lottoView = new LottoViewV2();
        LottoControllerV2 controller = new LottoControllerV2(lottoMachine, lottoView);
        controller.play();
    }
}
