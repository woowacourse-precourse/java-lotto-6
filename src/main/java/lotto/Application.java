package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Application {
    public static void main(String[] args) {
        Output output = new Output();
        Input input = new Input();
        Lotto lotto = new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
        Analyzer analyzer = new Analyzer();

        output.outputPurchaseAmount();
        int purchaseAmount = input.inputPurchaseAmount();
        int ticket = purchaseAmount / Ticket.TICKET_PRICE.getTicketPrice();
        List<List<Integer>> allTicketNumbers = new ArrayList<>();
        for (int i = 0; i < ticket; i++) {
            allTicketNumbers.add(new ArrayList<>(lotto.generateLotto()));
        }
        output.outputTicketPurchaseHistory(ticket, allTicketNumbers);

        output.outputWinningNumbers();
        List<Integer> winningNumbers = input.inputWinningNumbers();

        output.outputBonusNumber();
        int bonusNumber = input.inputBonusNumber();

        Map<Integer, Integer> ticketResults;
        ticketResults = analyzer.fillTicketResults(ticket, winningNumbers, allTicketNumbers, bonusNumber);
        double yieldRate = analyzer.calculateYield(purchaseAmount, ticketResults);
        output.outputResult(ticketResults, yieldRate);
    }
}