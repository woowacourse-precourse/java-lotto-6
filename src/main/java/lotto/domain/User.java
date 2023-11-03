package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class User {
    private static final List<Lotto> DEFAULT_LOTTO_LIST = new ArrayList<>();

    private static final Long DEFAULT_TOTAL_PRIZE = Long.valueOf(0);

    private List<Lotto> lottoList;

    private Long totalAmount;

    private Long totalPrize;

    public User(Long totalAmount){
        this.lottoList = DEFAULT_LOTTO_LIST;
        this.totalAmount = totalAmount;
        this.totalPrize = DEFAULT_TOTAL_PRIZE;
    }
}
