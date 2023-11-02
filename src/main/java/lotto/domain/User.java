package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class User {
    private static final List<Lotto> DEFAULT_LOTTO_LIST = new ArrayList<>();

    private static final Long DEFAULT_TOTAL_PRIZE = Long.valueOf(0);

    private List<Lotto> lottoList;

    private Long totalBought;

    private Long totalPrize;

    public User(Long totalBought){
        this.lottoList = DEFAULT_LOTTO_LIST;
        this.totalBought = totalBought;
        this.totalPrize = DEFAULT_TOTAL_PRIZE;
    }
}
