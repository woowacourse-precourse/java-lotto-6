package lotto.Domain;


import java.util.ArrayList;
import java.util.List;


public class User {
    private int money;
    private List<Lotto> lottos;

    public User(int money, List<Lotto> lottos) {
        validate(money, lottos);
        this.money = money;
        this.lottos = lottos;

    }
    private void validate(int money, List<Lotto> lottos) {

    }

}
