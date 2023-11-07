package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import lotto.model.BonusNumber;
import lotto.model.LottoTickets;
import lotto.model.OrderAmount;
import lotto.model.WinningNumber;
import lotto.view.View;

public class MainController {
    static View view = new View();
    OrderAmount payedMoney;

    public void run() {
        LottoTickets lottoTickets = purchaseLottoTickets();
        view.printLottoTickets(lottoTickets.printTickets());
        WinningNumber winningNumber = new WinningNumber(view.askWinningNumbers());
        BonusNumber bonusNumber = new BonusNumber(view.askBonusNumber());
        Console.close();
    }

    private LottoTickets purchaseLottoTickets() {
        String order = view.askPurchasingAmount();
        payedMoney = new OrderAmount(Integer.parseInt(order));
        view.printOrderedLottoCount(payedMoney.amountOfLotto());
        return new LottoTickets(payedMoney.amountOfLotto());
    }


}
