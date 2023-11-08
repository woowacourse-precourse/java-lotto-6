package lotto.Controller;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
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

        getWinningNumbers();
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

//    private WinningNumber getWinningNumber() {
//        List<Integer> winningNumbers = getWinningNumbers();
//    }

    private List<Integer> getWinningNumbers() {
        System.out.println();

        while (true) {
            try {
                InputView.printGetWinningNumbers();
                return lottoInitService.inputWinningNumberToList(userInput());
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] " + e.getMessage());
            }
        }
    }

    private Integer getBonusNumber() {
        System.out.println();

        while (true) {
            try {
                InputView.printGetBonusNumber();
                return lottoInitService.inputBonusNumberToInteger(userInput());
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] " + e.getMessage());
            }
        }
    }

    private String userInput() {
        return Console.readLine();
    }
}
