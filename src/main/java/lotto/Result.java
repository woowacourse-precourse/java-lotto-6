package lotto;

import java.util.List;

public class Result {
    private int matchingNumbersCounter;
    private boolean isBonusMatching;
    private int ranking;

    Result(Ticket ticket, Lotto lotto) {
        compareTicketAndLotto(ticket, lotto);
        decideRanking();
    }

    private void compareTicketAndLotto(Ticket ticket, Lotto lotto) {
        List<Integer> ticketNumbers = ticket.getLotto().getNumbers();
        int bonusNumber = ticket.getBonus().getNumber();

        List<Integer> lottoNumbers = lotto.getNumbers();

        for (Integer ticketNumber : ticketNumbers) {
            if (lottoNumbers.contains(ticketNumber)) {
                matchingNumbersCounter++;

            }
        }

        isBonusMatching = (matchingNumbersCounter == 5) && lottoNumbers.contains(bonusNumber);
    }

    private void decideRanking() {
        if (matchingNumbersCounter == 6) {
            ranking = 1;
        }

        if (matchingNumbersCounter == 5) {
            ranking = 3;

            if (isBonusMatching) {
                ranking = 2;
            }
        }

        if (matchingNumbersCounter == 4) {
            ranking = 4;
        }

        if (matchingNumbersCounter == 3) {
            ranking = 5;
        }
    }

    public int getRanking() {
        return ranking;
    }
}
