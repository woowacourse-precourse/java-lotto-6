package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import lotto.model.*;
import lotto.view.View;

public class MainController {
    static View view = new View();
    OrderAmount payedMoney;
    LottoTickets lottoTickets;

    public void run() {
        lottoTickets = purchaseLottoTickets();
        view.printLottoTickets(lottoTickets.printTickets());
        WinningNumber winningNumber = new WinningNumber(view.askWinningNumbers());
        BonusNumber bonusNumber = new BonusNumber(view.askBonusNumber());
        calculateStatistics(winningNumber, bonusNumber);
        Console.close();
    }

    private LottoTickets purchaseLottoTickets() {
        String order = view.askPurchasingAmount();
        payedMoney = new OrderAmount(Integer.parseInt(order));
        view.printOrderedLottoCount(payedMoney.amountOfLotto());
        return new LottoTickets(payedMoney.amountOfLotto());
    }

    private void calculateStatistics(WinningNumber winningNumber, BonusNumber bonusNumber) {
        LottoResults results = lottoTickets.calculateResult(winningNumber, bonusNumber);
        view.printStatistics(results.showResults());
        view.printProfit(payedMoney.calculateProfit(results));
    }
}
