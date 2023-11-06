package lotto.view;

import static lotto.constant.Constant.PURCHASE_COUNT_MESSAGE;

import java.util.Comparator;
import java.util.List;

import lotto.domain.Lotto;

public class OutputView {

    private List<Lotto> purchaseLotto;

    public void printLottoTicket(List<Lotto> purchaseLotto) {
        this.purchaseLotto = purchaseLotto;
        printTicketCount(purchaseLotto.size());
        sortNumbers();
        printLottoTicketNumbers();
    }

    private void printTicketCount(Integer numberOfTickets) {
        printWhiteSpace();
        System.out.printf(PURCHASE_COUNT_MESSAGE, numberOfTickets);
    }

    private void sortNumbers(){
        purchaseLotto.forEach(lotto -> lotto.getNumbers().sort(Comparator.naturalOrder()));
    }

    private void printLottoTicketNumbers(){
        purchaseLotto.forEach(lotto -> System.out.println(lotto.getNumbers()));
    }

    private void printWhiteSpace(){
        System.out.println();
    }

}
