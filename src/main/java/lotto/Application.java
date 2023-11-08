package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Application {
    public static void main(String[] args) {
        Output output = new Output();
        Input input = new Input(output);
        Lotto lotto = new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
        Analyzer analyzer = new Analyzer();

        int purchaseAmount = input.inputPurchaseAmount();
        int ticket = purchaseAmount / Ticket.TICKET_PRICE.getTicketPrice();
        List<Integer> winningNumbers = input.inputWinningNumbers();
        int bonusNumber = input.inputBonusNumber();

        List<List<Integer>> allTicketNumbers = new ArrayList<>();
        Map<Integer, Integer> ticketResults;

        for (int i = 0; i < ticket; i++) {
            allTicketNumbers.add(new ArrayList<>(lotto.generateLotto()));
        }
        ticketResults = analyzer.fillTicketResults(ticket, winningNumbers, allTicketNumbers, bonusNumber);
        analyzer.calculateYield(purchaseAmount, ticketResults);
    }
}