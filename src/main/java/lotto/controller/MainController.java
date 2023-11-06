package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import lotto.model.LottoTickets;
import lotto.view.View;

public class MainController {
    static View view = new View();

    public void run() {
        LottoTickets lottoTickets = purchaseLottoTickets();
        Console.close();
    }

    private LottoTickets purchaseLottoTickets() {
        String order = view.askPurchasingAmount();
        return new LottoTickets(Integer.parseInt(order));
    }


}
