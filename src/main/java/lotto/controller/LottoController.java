package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class LottoController {

    private final LottoService lottoService = new LottoService();

    public void run() {
        inputBuyLottoTickets();
        createUserLottoNumbers();
        inputWinnerLottoTicket();
        inputBonusNumber();
        processPrizeCalculation();
        processProfitCalculation();
    }

    public void inputBuyLottoTickets() {
        boolean exceptionCheck = true;
        while (exceptionCheck) {
            try {
                OutputView.printInputBuyAmount();
                String inputAmount = Console.readLine();

                this.lottoService.buyLottoTickets(inputAmount);

                exceptionCheck = false;

            }catch (IllegalArgumentException e) {
                System.err.println(e.getMessage());
            }
        }
    }

    public void inputWinnerLottoTicket() {
        boolean exceptionCheck = true;
        while (exceptionCheck) {
            try {
                OutputView.printInputWinningNumber();
                String inputLotto = InputView.getInputLine();

                this.lottoService.createLottoWinningNumber(inputLotto);
                exceptionCheck = false;

            }catch (IllegalArgumentException e) {
                System.err.println(e.getMessage());
            }
        }
    }

    public void createUserLottoNumbers() {
        List<List<Integer>> userLottoNumbers = this.lottoService.getUserLottoNumbers();
        OutputView.printPurchaseTicketCount(userLottoNumbers.size());

        OutputView.printUserLottoNumbers(userLottoNumbers);

    }

    public void inputBonusNumber() {
        boolean exceptionCheck = true;
        while (exceptionCheck) {
            try {
                OutputView.printInputBonusNumber();
                String inputBonus = InputView.getInputLine();

                this.lottoService.createBonusNumber(inputBonus);
                exceptionCheck = false;

            }catch (IllegalArgumentException e) {
                System.err.println(e.getMessage());
            }
        }
    }

    public void processPrizeCalculation() {
        this.lottoService.calculatePrize();
    }

    public void processProfitCalculation() {
        this.lottoService.calculateProfit();
    }
}