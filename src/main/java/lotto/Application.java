package lotto;

import lotto.controller.LottoController;
import lotto.utils.ResultOutput;

public class Application {
    public static void main(String[] args) {
        try {
            LottoController Lottocontroller = new LottoController();
            Lottocontroller.startLottoController();
        } catch (IllegalArgumentException e) {
            ResultOutput.printErrorMessage(e.getMessage());
        }
    }
}