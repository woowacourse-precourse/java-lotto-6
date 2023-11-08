package lotto;

import static controller.LottoController.buyLotto;
import static controller.LottoController.lottoMachine;

public class Application {
    public static void main(String[] args) {
        lottoMachine(buyLotto());
    }
}
