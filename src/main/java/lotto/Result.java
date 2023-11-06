package lotto;

import java.util.List;

public class Result {
    private int matchingNumbersCounter;
    private boolean isBonusMatching;
    private Rank rank;

    Result(Ticket ticket, Lotto lotto) {
        compareTicketAndLotto(ticket, lotto);
        decideRank();
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

    private void decideRank() {
        if (matchingNumbersCounter == 6) {
            rank = Rank.FIRST;
        }

        if (matchingNumbersCounter == 5) {
            rank = Rank.THIRD;

            if (isBonusMatching) {
                rank = Rank.SECOND;
            }
        }

        if (matchingNumbersCounter == 4) {
            rank = Rank.FOURTH;
        }

        if (matchingNumbersCounter == 3) {
            rank = Rank.FIFTH;
        }
    }

    public Rank getRanking() {
        return rank;
    }
}
