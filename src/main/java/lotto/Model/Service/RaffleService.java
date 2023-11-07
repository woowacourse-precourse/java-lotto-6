package lotto.Model.Service;

import java.util.List;
import lotto.Model.Domain.Raffle;
import lotto.Model.Util.RaffleUtil;

public class RaffleService {

    private final RaffleUtil raffleUtil;
    private Raffle raffle;

    public RaffleService(RaffleUtil raffleUtil) {
        this.raffleUtil = raffleUtil;
    }

    public void setRaffleNumber(String winningNumbers, String bonusNumber) {
        if (raffleUtil.validateWinningNumbers(winningNumbers)) {

            List<Integer> winningNumberList = raffleUtil.parseWinningNumbers(winningNumbers);
            int parsedBonusNumber = Integer.parseInt(bonusNumber);
            raffleUtil.checkInRange(winningNumberList);
            raffleUtil.hasDuplicate(winningNumberList);
            raffleUtil.isDuplicate(winningNumberList, parsedBonusNumber);

            raffle = new Raffle(winningNumberList, parsedBonusNumber);
        }
    }

    public Raffle getRaffle() {
        return raffle;
    }
}
