package lotto;

import lotto.domain.controller.LottoController;
import lotto.domain.service.ClientService;
import lotto.domain.service.LottoService;
import lotto.global.utils.generator.NumbersGenerator;
import lotto.global.utils.generator.RandomNumbersGenerator;

public class Application {
    public static void main(String[] args) {
        ClientService clientService = new ClientService();
        LottoService lottoService = new LottoService();
        NumbersGenerator numbersGenerator = new RandomNumbersGenerator();
        LottoController lottoController = new LottoController(clientService, lottoService, numbersGenerator);
        lottoController.run();
    }
}
