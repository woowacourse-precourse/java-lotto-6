package lotto.model;

import java.util.List;

public class User {

    private int amount;
    private List<Lotto> lottos ;

    public User(int amount, List<Lotto> lottos){
        this.amount = amount;
        this.lottos = lottos;
    }
}
