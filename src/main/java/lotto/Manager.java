package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.view.Input;
import lotto.view.Output;

import java.util.ArrayList;
import java.util.List;

public class Manager {
    public static final int NUMBER_OF_LOTTO_NUMBER = 6;
    private final Input input = new Input();
    private final Output output = new Output();

    public List<Lotto> purchaseLottoTickets() {
        output.printEnteringAmountPrompt();
        int purchasedAmount = input.readTotalPurchasedAmount();
        int purchasedQuantity = purchasedAmount / 1000;

        List<Lotto> lottoTickets = new ArrayList<>();
        for (int i = 0; i < purchasedQuantity; i++) {
            lottoTickets.add(generateLottoTicket());
        }
        return lottoTickets;
    }

    public Lotto generateLottoTicket() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, NUMBER_OF_LOTTO_NUMBER);
        return new Lotto(numbers);
    }

    public void printLottoTickets(List<Lotto> tickets) {
        output.printPurchasedLottoTickets(tickets);
    }
}
