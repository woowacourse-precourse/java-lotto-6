package lotto.domain;

import java.util.ArrayList;
import java.util.List;

import static lotto.util.Util.*;
import static lotto.validation.InputValidation.validateCost;

// 로또를 구입하는 대상에 관한 도메인
public class Buyer {
    private final int cost;
    private final int count;
    private final ArrayList<Lotto> purchasedLotteries = new ArrayList<>();

    public Buyer() {
        String costString = inputPrice();
        cost = validateCost(costString);
        count = countLotto(cost);
    }
    public void buyLotto(Lotto lotto) {
        purchasedLotteries.add(lotto);
    }

    public List<Lotto> getPurchasedLotteries(){
        return purchasedLotteries;
    }
    public int getCount(){
        return count;
    }

    public int getPrice() {
        return cost;
    }
}