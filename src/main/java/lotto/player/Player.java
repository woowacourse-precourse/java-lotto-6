package lotto.player;

import java.util.List;

public class Player {
    int amount;
    List<Integer> prizeNumbers;
    int bonusNumber;

    public Player(List<Integer> prizeNumbers, int bonusNumber, int amount) {
        this.prizeNumbers = prizeNumbers;
        this.bonusNumber = bonusNumber;
        this.amount = amount;
    }
}
