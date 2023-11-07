package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import lotto.model.lotto.BonusNumber;
import lotto.model.lotto.WinningNumber;
import lotto.model.user.LottoResults;
import lotto.model.user.LottoTickets;
import lotto.model.user.OrderAmount;
import lotto.view.View;

public class MainController {
    static View view = new View();
    OrderAmount payedMoney;
    LottoTickets lottoTickets;
    WinningNumber winningNumber;
    BonusNumber bonusNumber;

    public void run() {
        lottoTickets = purchaseLottoTickets();
        view.printLottoTickets(lottoTickets.printTickets());
        makeWinningNumbers();
        makeBonusNumber();
        calculateStatistics(winningNumber, bonusNumber);
        Console.close();
    }

    private LottoTickets purchaseLottoTickets() {
        while (true){
            try {
                String order = view.askPurchasingAmount();
                payedMoney = new OrderAmount(order);
                break;
            } catch (IllegalArgumentException exception){
                System.out.println(exception.getMessage());
            }
        }
        view.printOrderedLottoCount(payedMoney.amountOfLotto());
        return new LottoTickets(payedMoney.amountOfLotto());
    }

    private void makeWinningNumbers(){
        while (true){
            try {
                winningNumber = new WinningNumber(view.askWinningNumbers());
                break;
            } catch (IllegalArgumentException exception){
                System.out.println(exception.getMessage());
            }
        }
    }

    private void makeBonusNumber(){
        while (true){
            try {
                bonusNumber = new BonusNumber(winningNumber, view.askBonusNumber());
                break;
            } catch (IllegalArgumentException exception){
                System.out.println(exception.getMessage());
            }
        }
    }

    private void calculateStatistics(WinningNumber winningNumber, BonusNumber bonusNumber) {
        LottoResults results = lottoTickets.calculateResult(winningNumber, bonusNumber);
        view.printStatistics(results.showResults());
        view.printProfit(payedMoney.calculateProfit(results));
    }
}
