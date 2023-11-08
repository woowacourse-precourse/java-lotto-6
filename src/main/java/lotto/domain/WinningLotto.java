package lotto.domain;

import java.util.ArrayList;
import java.util.List;


public class WinningLotto {
    private final Lotto lotto;
    private final Bonus bonus;

    public WinningLotto(Lotto lotto) {
        this.lotto = lotto;
        this.bonus = generateBonusNumber();
    }

    public List<Integer> countContainsNumber(GuessLottoTickets guessLottoTickets) {
        List<Integer> countNumbers = new ArrayList<>();
        for (GuessLottoTicket guessLottoTicket : guessLottoTickets.getGuessLottoTickets()) {
            Lotto guessNumbers = guessLottoTicket.getLotto();
            int numbers = lotto.countContainNumbers(guessNumbers);
            int bonusCount = bonus.containBonusNumber(guessNumbers);
            countNumbers.add(numbers + bonusCount);
        }
        return countNumbers;
    }

    public boolean containsBonus(GuessLottoTickets guessLottoTickets) {
        List<Integer> numbers = countContainsNumber(guessLottoTickets);
        boolean isContain = false;
        for (int size = 0; size < numbers.size(); size++) {
            if (numbers.get(size) == 5) {
                isContain = bonus.isContainBonusNumber(guessLottoTickets.getGuessLottoTicketNumber(size));
            }
        }
        return isContain;
    }

    private Bonus generateBonusNumber() {
        return new Bonus();
    }
}
