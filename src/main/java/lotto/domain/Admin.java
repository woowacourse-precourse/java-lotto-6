package lotto.domain;

import java.util.ArrayList;

public class Admin {
    ArrayList<Integer> winnerNumber;
    int bonusNumber;

    public Admin(ArrayList<Integer> winnerNumber, int bonusNumber) {
        this.winnerNumber = winnerNumber;
        this.bonusNumber = bonusNumber;
    }
}
