package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class Application {
    private final Output output;
    private final Input input;
    private final Analyzer analyzer;

    public static void main(String[] args) {
        Application application = new Application();
        application.run();
    }

    private Application() {
        output = new Output();
        input = new Input();
        analyzer = new Analyzer();
    }

    private void run() {
        output.outputPurchaseAmount();
        int purchaseAmount = input.inputPurchaseAmount();
        int ticket = purchaseAmount / Ticket.TICKET_PRICE.getTicketPrice();
        List<List<Integer>> allTicketNumbers = generateAllTickets(ticket);

        output.outputWinningNumbers();
        List<Integer> winningNumbers = input.inputWinningNumbers();

        output.outputBonusNumber();
        int bonusNumber = input.inputBonusNumber();

        Map<Integer, Integer> ticketResults = analyzer.fillTicketResults(ticket, winningNumbers, allTicketNumbers, bonusNumber);
        double yieldRate = analyzer.calculateYield(purchaseAmount, ticketResults);
        output.outputResult(ticketResults, yieldRate);
    }

    private List<List<Integer>> generateAllTickets(int ticket) {
        List<List<Integer>> allTicketNumbers = new ArrayList<>();
        for (int i = 0; i < ticket; i++) {
            allTicketNumbers.add(new ArrayList<>(generateLotto()));
        }
        output.outputTicketPurchaseHistory(ticket, allTicketNumbers);
        return allTicketNumbers;
    }

    private List<Integer> generateLotto() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        List<Integer> sortedNumbers = new ArrayList<>(numbers);
        Collections.sort(sortedNumbers);
        return sortedNumbers;
    }
}