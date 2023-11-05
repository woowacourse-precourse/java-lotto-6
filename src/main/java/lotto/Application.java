package lotto;

import lotto.controller.LottoController;
import lotto.service.LottoMachine;
import lotto.service.LottoService;

public class Application {
    public static void main(String[] args) {
        try {
            // TODO: 프로그램 구현
            LottoService lottoService = new LottoService(new LottoMachine());
            LottoController lottoController = new LottoController(lottoService);

            lottoController.play();
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR]" + e.getMessage());
        }
    }
}
