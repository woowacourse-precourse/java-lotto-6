package lotto;

import lotto.domain.controller.LottoController;
import lotto.domain.service.ClientService;
import lotto.domain.service.LottoService;

public class Application {
    public static void main(String[] args) {
        ClientService clientService = new ClientService();
        LottoService lottoService = new LottoService();
        LottoController lottoController = new LottoController(clientService, lottoService);
        lottoController.run();
    }
}
