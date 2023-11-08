package lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoWinning {

    private List<Integer> winningNumbers;
    private Integer bonusNumber;

    public LottoWinning(List<Integer> winningNumbers, Integer bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    // TODO: refactor names of variables
    public List<LottoRank> assignRanks(List<Lotto> tickets) {
        List<LottoRank> winnings = new ArrayList<>();
        // TODO: refactor
        tickets.forEach(t -> {
            LottoRank wonRank = assignRank(t);
            winnings.add(wonRank);
        });
        // TODO: refactor ignore NoWinning
        return winnings;
    }

    public LottoRank assignRank(Lotto ticket) {
        int match = ticket.countMatchingNumbers(winningNumbers);
        boolean bonusMatch = ticket.numbersContain(bonusNumber);
        LottoRank wonRank = LottoRank.getWinningRank(match, bonusMatch);
        if (wonRank == LottoRank.NO_WINNING) {
            return null;
        }
        return wonRank;
    }
}
