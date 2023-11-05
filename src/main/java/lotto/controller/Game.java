package lotto.controller;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.RandomNumber;
import lotto.domain.Ticket;
import lotto.view.BonusNumberView;
import lotto.view.LottoView;
import lotto.view.PurchaseView;
import lotto.view.RandomNumberView;

public class Game {

    private PurchaseView purchaseView = new PurchaseView();
    private RandomNumber randomNumber = new RandomNumber();
    private RandomNumberView randomNumberView = new RandomNumberView();
    private LottoView lottoView = new LottoView();
    private BonusNumberView bonusNumberView = new BonusNumberView();
    private Lotto lotto;
    private Ticket ticket;

    public void start() {
        int money = purchaseView.requestMoney();
        ticket = new Ticket(money);
        times();

        List<Integer> lottoNumbers = lottoView.numbers();
        int bonusNumber = bonusNumberView.bonusNumber(lottoNumbers);
    }

    private void times() {
        for (int i = 0; i < ticket.getTicket(); i++) {
            randomNumberView.printRandomNumber(randomNumber.randomNumbers());

        }
    }
}
