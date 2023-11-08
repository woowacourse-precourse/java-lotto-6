package lotto.Model.Service;

import java.util.List;
import lotto.Model.Domain.Raffle;

public class RaffleService {

    private Raffle raffle;

    public void setRaffleNumber(List<Integer> winningNumbers, int bonusNumber) {
        raffle = new Raffle(winningNumbers, bonusNumber);
    }

    public Raffle getRaffle() {
        return raffle;
    }
}
