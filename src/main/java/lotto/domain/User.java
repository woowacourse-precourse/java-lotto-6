package lotto.domain;

import java.util.List;

public class User {

    private final int PURCHASE_AMOUNT;
    private List<Lotto> lottos;

    private User(int amount,List<Lotto> lottos){
        this.PURCHASE_AMOUNT = amount;
        this.lottos = lottos;
    }

    




}
