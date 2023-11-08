package lotto.model.controller;

import camp.nextstep.edu.missionutils.Console;
import lotto.model.lotto.BonusNumber;
import lotto.model.lotto.LottoTickets;
import lotto.model.lotto.WinningNumber;
import lotto.model.user.LottoResults;
import lotto.model.user.OrderAmount;
import lotto.view.OutputView;

public class LottoController {
    final OutputView view = new OutputView();
    OrderAmount payedMoney;
    LottoTickets lottoTickets;
    WinningNumber winningNumber;
    BonusNumber bonusNumber;

    public void run() {
        purchaseLottoTickets();
        makeWinningNumbers();
        makeBonusNumber();
        showStatistics();

        Console.close();
    }

    private void purchaseLottoTickets() {
        while (true){
            try {
                String order = view.askPurchasingAmount();
                payedMoney = new OrderAmount(order);
                break;
            } catch (IllegalArgumentException exception){
                view.printMessage(exception.getMessage());
            }
        }
        view.printOrderedLottoCount(payedMoney.amountOfLotto());
        lottoTickets = new LottoTickets(payedMoney.amountOfLotto());
        view.printLottoTickets(lottoTickets.printTickets());
    }

    private void makeWinningNumbers(){
        while (true){
            try {
                winningNumber = new WinningNumber(view.askWinningNumbers());
                break;
            } catch (IllegalArgumentException exception){
                view.printMessage(exception.getMessage());
            }
        }
    }

    private void makeBonusNumber(){
        while (true){
            try {
                bonusNumber = new BonusNumber(winningNumber, view.askBonusNumber());
                break;
            } catch (IllegalArgumentException exception){
                view.printMessage(exception.getMessage());
            }
        }
    }

    private void showStatistics() {
        LottoResults results = lottoTickets.calculateResult(winningNumber, bonusNumber);
        view.printStatistics(results.showResults());
        view.printProfit(payedMoney.calculateProfit(results));
    }
}
