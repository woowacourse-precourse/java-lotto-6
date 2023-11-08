package lotto.Controller;

import camp.nextstep.edu.missionutils.Console;
import lotto.Service.LottoInitService;
import lotto.Service.LottoService;
import lotto.view.InputView;

public class LottoController {
    LottoInitService lottoInitService = new LottoInitService();
    LottoService lottoService = new LottoService();

    public void run() {
        Integer amount = getUserAmount();


//        Lottos lottos = lottoService.getLottos(amount);
//        lottoService.printLottos(lottos);


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

    private String userInput() {
        return Console.readLine();
    }
}
