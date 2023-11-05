package lotto.domain;

import java.util.List;

public class User {
    private int purchaseNumber;
    private List<Lotto> lottoList;

    public User(int purchaseNumber, List<Lotto> lottoList) {
        this.purchaseNumber = purchaseNumber;
        this.lottoList = lottoList;
    }
}
