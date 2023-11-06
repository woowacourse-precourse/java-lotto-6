package lotto.service;

import java.util.ArrayList;
import java.util.List;

public class LottoPurchaseListComparer {
    private List<Integer> resultList = new ArrayList<>();

    public LottoPurchaseListComparer() {
        for (int i = 0; i < 5; i++) {
            resultList.add(0);
        }
    }

    public List<Integer> getResultList() {
        return resultList;
    }

    public void compareBundle(List<List<Integer>> purchase, List<Integer> lotto, int bonus) {
        for (List<Integer> purchaseUnit : purchase) {
            int match = compareUnitNumber(purchaseUnit, lotto, bonus);

            if (match >= 3 && match <= 7) {
                resultList.set(match - 3, resultList.get(match - 3) + 1);
            }
        }
    }

    public int compareUnitNumber(List<Integer> purchaseUnit, List<Integer> lotto, int bonus) {
        int match = 0;
        for (Integer number : purchaseUnit) {
            if (lotto.contains(number)) {
                match++;
            }
        }
        if ((match == 5 && purchaseUnit.contains(bonus)) || match == 6) {
            return match + 1;
        }

        return match;
    }

}
