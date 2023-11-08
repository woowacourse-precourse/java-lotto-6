package lotto.Controller;

import camp.nextstep.edu.missionutils.Console;
import lotto.Service.LottoInitService;
import lotto.Service.LottoService;
import lotto.domain.Lottos;
import lotto.view.InputView;

public class LottoController {
    LottoInitService lottoInitService = new LottoInitService();
    LottoService lottoService = new LottoService();

    public void run() {
        Integer amount = getUserAmount();
        Lottos lottos = printLottos(amount);
    }

    private Integer getUserAmount() {
        while (true) {
            InputView.printGetUserAmount();

            try {
                return lottoInitService.inputAmountToNumber(userInput());
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] " + e.getMessage());
            }
        }
    }

    private Lottos printLottos(Integer amount) {
        Lottos lottos = lottoService.getLottos(amount);
        System.out.println();
        lottoService.printLottos(lottos);
        return lottos;
    }

    private String userInput() {
        return Console.readLine();
    }
}
