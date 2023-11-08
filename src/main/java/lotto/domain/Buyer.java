package lotto.domain;

import static lotto.util.Util.inputPrice;
import static lotto.validation.InputValidation.validateCost;

// 로또를 구입하는 대상에 관한 도메인
public class Buyer {
    private final int cost;

    public Buyer() {
        String costString = inputPrice();
        cost = validateCost(costString);
    }

    public int getPrice() {
        return cost;
    }
}