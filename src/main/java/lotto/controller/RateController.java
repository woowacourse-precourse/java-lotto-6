package lotto.controller;

import lotto.domain.Rate;

public class RateController {
    public Rate create(long purchaseMoney, long reward) {
        return new Rate(purchaseMoney, reward);
    }
}
