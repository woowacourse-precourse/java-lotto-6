package lotto.domain;

import java.util.*;

public class Player {
    private int money;
    private List<Lotto> lottos;

    public Player(int money) {
        validate(money);
        this.money = money;

        lottos = new ArrayList<>();
    }

    private void validate(int money) {
        if (money % LottoMachine.getLottoPrice() != 0 || money < 0) {
            throw new IllegalArgumentException();
        }
    }

    public int getMoney() {
        return money;
    }

    public List<Lotto> getLottos() {
        return List.copyOf(lottos);
    }

    public void addLottos(List<Lotto> issuedLottos) {
        lottos.addAll(issuedLottos);
    }
}
