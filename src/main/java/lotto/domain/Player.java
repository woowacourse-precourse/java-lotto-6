package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private int money;
    private List<Lotto> lottos = new ArrayList<>();

    public Player(int money) {
        this.money = money;
    }

    public void issueLotto() {

    }

    public String issuedLottos() {
        return "";
    }

    public String lottoResults(List<Integer> winningNumbers, int bonusNumber) {
        return "";
    }
}
