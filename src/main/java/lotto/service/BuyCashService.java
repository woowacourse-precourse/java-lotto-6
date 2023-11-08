package lotto.service;

import lotto.domain.BuyCash;

public class BuyCashService {
    public BuyCash generateBuyCash(long buyCash) {
        return new BuyCash(buyCash);
    }
}
