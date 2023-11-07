package lotto.view;

import static lotto.constant.ConstantString.DELIMITER;
import static lotto.constant.ConstantString.FINAL_REVENUE_MESSAGE;
import static lotto.constant.ConstantString.PURCHASE_COUNT_MESSAGE;
import static lotto.constant.ConstantString.RESULT_MESSAGE;

import java.util.List;
import java.util.Map;

import lotto.domain.Lotto;
import lotto.domain.Rank;

public class OutputView {

    private List<Lotto> purchaseLotto;

    public void printLottoTicket(List<Lotto> purchaseLotto) {
        this.purchaseLotto = purchaseLotto;
        printTicketCount(purchaseLotto.size());
        printLottoTicketNumbers();
    }

    private void printTicketCount(Integer numberOfTickets) {
        printWhiteSpace();
        System.out.printf(PURCHASE_COUNT_MESSAGE, numberOfTickets);
    }

    private void printLottoTicketNumbers() {
        purchaseLotto.forEach(lotto -> System.out.println(lotto.getNumbers()));
    }

    private void printWhiteSpace() {
        System.out.println();
    }

    public void printResult(Map<Rank, Integer> result){
        printResultMessage();
        result.forEach((rank,count) ->{
            String message = rank.getMessage();
            if (!message.equals("")) System.out.println(String.format("%s%d개", message, count));
        });
    }

    private void printResultMessage() {
        printWhiteSpace();
        System.out.println(RESULT_MESSAGE);
        System.out.println(DELIMITER);
    }

    public void printRevenue(double revenue) {
        System.out.printf(FINAL_REVENUE_MESSAGE, revenue);
    }
}
