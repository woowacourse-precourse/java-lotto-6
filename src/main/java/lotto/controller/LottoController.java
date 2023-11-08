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
        try {
            OutputView.printInputBuyAmount();
            String inputAmount = Console.readLine();

            this.lottoService.buyLottoTickets(inputAmount);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            inputBuyLottoTickets();
        }
    }

    public void inputWinnerLottoTicket() {

        try {
            OutputView.printInputWinningNumber();
            String inputLotto = InputView.getInputLine();

            this.lottoService.createLottoWinningNumber(inputLotto);

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            inputWinnerLottoTicket();
        }
    }

    public void createUserLottoNumbers() {

        List<List<Integer>> userLottoNumbers = this.lottoService.getUserLottoNumbers();

        OutputView.printPurchaseTicketCount(userLottoNumbers.size());
        OutputView.printUserLottoNumbers(userLottoNumbers);
    }

    public void inputBonusNumber() {
        try {
            OutputView.printInputBonusNumber();
            String inputBonus = InputView.getInputLine();

            this.lottoService.createBonusNumber(inputBonus);

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            inputBonusNumber();
        }
    }

    public void processPrizeCalculation() {
        this.lottoService.calculatePrize();
    }

    public void processProfitCalculation() {
        this.lottoService.calculateProfit();
    }
}
