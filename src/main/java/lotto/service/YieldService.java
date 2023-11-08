package lotto.service;

import static lotto.constant.NumberConstant.PERCENT;

public class YieldService {


    public double calculateYield(Long result, Long money) {
        double v = result.doubleValue();
        double yield = v / money * PERCENT.getNumber();
        return yield;
    }

}
