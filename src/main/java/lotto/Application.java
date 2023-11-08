package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.enums.Ticket;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import static lotto.enums.LottoConfig.*;

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
        List<Lotto> lottos = new ArrayList<>();
        analyzer = new Analyzer();
    }

    private void run() {
        output.outputPurchaseAmount();
        int purchaseAmount = input.inputPurchaseAmount();
        int ticket = purchaseAmount / Ticket.TICKET_PRICE.getTicketPrice();
        List<Lotto> allTicketNumbers = generateAllTickets(ticket);

        output.outputWinningNumbers();
        List<Integer> winningNumbers = input.inputWinningNumbers();

        output.outputBonusNumber();
        int bonusNumber = input.inputBonusNumber();

        Map<Integer, Integer> ticketResults = analyzer.fillTicketResults(ticket, winningNumbers, allTicketNumbers, bonusNumber);
        double yieldRate = analyzer.calculateYield(purchaseAmount, ticketResults);
        output.outputResult(ticketResults, yieldRate);
    }

    public Lotto generateLotto() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(
                START_INCLUSIVE.getValue(), END_INCLUSIVE.getValue(), COUNT.getValue());
        List<Integer> sortedNumbers = new ArrayList<>(numbers);
        Collections.sort(sortedNumbers);
        return new Lotto(sortedNumbers);
    }

    private List<Lotto> generateAllTickets(int ticket) {
        List<Lotto> allTicketNumbers = new ArrayList<>();
        for (int i = 0; i < ticket; i++) {
            allTicketNumbers.add(generateLotto());
        }
        output.outputTicketPurchaseHistory(ticket, allTicketNumbers);
        return allTicketNumbers;
    }
}