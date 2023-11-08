package lotto.Controller;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import lotto.Service.LottoInitService;
import lotto.Service.LottoService;
import lotto.Validator.BonusNumberValidator;
import lotto.domain.LottoResult;
import lotto.domain.Lottos;
import lotto.domain.WinningNumber;
import lotto.view.InputView;

public class LottoController {
    LottoInitService lottoInitService = new LottoInitService();
    LottoService lottoService = new LottoService();

    public void run() {
        Integer amount = getUserAmount();
        Lottos lottos = printLottos(amount);
        WinningNumber winningNumber =  getWinningNumber();
        printStatistics(lottos, winningNumber);
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

    private WinningNumber getWinningNumber() {
        List<Integer> winningNumbers = getWinningNumbers();
        Integer bonusNumber = getBonusNumber(winningNumbers);

        return lottoInitService.getWinningNumber(winningNumbers, bonusNumber);
    }

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

    private Integer getBonusNumber(List<Integer> winningNumbers) {
        System.out.println();

        while (true) {
            try {
                InputView.printGetBonusNumber();
                Integer bonusNumber = lottoInitService.inputBonusNumberToInteger(userInput());
                BonusNumberValidator.validDuplicatedNumber(winningNumbers, bonusNumber);
                return bonusNumber;
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] " + e.getMessage());
            }
        }
    }

    private void printStatistics(Lottos lottos, WinningNumber winningNumber) {
        LottoResult result = lottoService.getResult(lottos, winningNumber);

        System.out.println();
        lottoService.printStatistics(result);
    }

    private String userInput() {
        return Console.readLine();
    }
}
