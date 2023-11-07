package lotto.entity;

import java.util.List;

public class Result {
    private int matchingNumbersCounter;
    private boolean isBonusMatching;
    private Rank rank = Rank.OTHERS;

    public Result(Ticket ticket, Lotto lotto) {
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

        isBonusMatching = (matchingNumbersCounter == Rank.SECOND.getNumberOfMatching())
                && lottoNumbers.contains(bonusNumber);
    }

    private void decideRank() {
        if (matchingNumbersCounter == Rank.FIRST.getNumberOfMatching()) {
            rank = Rank.FIRST;
        }

        if (matchingNumbersCounter == Rank.THIRD.getNumberOfMatching()) {
            rank = Rank.THIRD;

            if (isBonusMatching) {
                rank = Rank.SECOND;
            }
        }

        if (matchingNumbersCounter == Rank.FOURTH.getNumberOfMatching()) {
            rank = Rank.FOURTH;
        }

        if (matchingNumbersCounter == Rank.FIFTH.getNumberOfMatching()) {
            rank = Rank.FIFTH;
        }
    }

    public Rank getRank() {
        return rank;
    }
}
