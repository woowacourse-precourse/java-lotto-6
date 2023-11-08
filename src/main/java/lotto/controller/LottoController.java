package lotto.controller;

import lotto.model.Lotto;
import lotto.model.LottoTickets;
import lotto.model.WinningNumbers;
import lotto.model.WinningStatistic;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;
import lotto.view.exception.InputException;

public class LottoController {
    private final LottoService lottoService;
    private final InputView input;
    private final OutputView output;

    public LottoController(LottoService lottoService, InputView inputView, OutputView outputView) {
        this.lottoService = lottoService;
        this.input = inputView;
        this.output = outputView;
    }

    public void playLottoGame(){
        int purchaseAmount = inputPurchaseAmount();
        int purchaseQuantity = makePurchaseQuantity(purchaseAmount);

        LottoTickets lottoTickets = makeLottoTickets(purchaseQuantity);
        WinningNumbers winningNumbers = makeWinningNumbers();

        WinningStatistic winningStatistic = makeWinningStatistic(lottoTickets, winningNumbers);
        makeTotalReturn(purchaseAmount, winningStatistic);
    }

    private int inputPurchaseAmount(){
        output.printInputPurchaseAmountNotice();

        int purchaseAmount;
        while(true){
            try {
                purchaseAmount = input.inputPurchaseAmount();
                break;
            } catch (InputException e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println();

        return purchaseAmount;
    }

    private int makePurchaseQuantity(int purchaseAmount){
        int purchaseQuantity = lottoService.calPurchaseQuantity(purchaseAmount);
        output.printOutputPurchaseAmount(purchaseQuantity);
        return purchaseQuantity;
    }

    private LottoTickets makeLottoTickets(int purchaseQuantity) {
        LottoTickets lottoTickets = lottoService.createLottoTickets(purchaseQuantity);
        output.printPurchaseLottoTicketsInfo(lottoTickets);
        return lottoTickets;
    }

    private Lotto inputWinningNumbers(){
        output.printInputWinningNumbersNotice();
        Lotto winningNumber;
        while(true){
            try {
                winningNumber = new Lotto(input.inputWinningNumbers());
                break;
            } catch (InputException e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println();
        return winningNumber;
    }

    private int inputBonusNumber(){
        output.printInputBonusNumberNotice();

        int bonusNumber;
        while(true){
            try {
                bonusNumber = input.inputBonusNumber();
                break;
            } catch (InputException e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println();
        return bonusNumber;
    }
    private WinningNumbers makeWinningNumbers(){
        Lotto winningNumber = inputWinningNumbers();
        int bonusNumber = inputBonusNumber();

        WinningNumbers winningNumbers= new WinningNumbers(winningNumber, bonusNumber);

        return winningNumbers;
    }

    private WinningStatistic makeWinningStatistic(LottoTickets lottoTickets, WinningNumbers winningNumbers) {
        WinningStatistic winningStatistic = lottoService.statisticWinningResult(lottoTickets, winningNumbers);
        output.printWinningStatisticsInfo(winningStatistic);
        return winningStatistic;
    }

    private void makeTotalReturn(int purchaseQuantity, WinningStatistic winningStatistic) {
        double totalReturn = lottoService.calTotalReturn(purchaseQuantity, winningStatistic);
        output.printTotalReturn(totalReturn);
    }

}
