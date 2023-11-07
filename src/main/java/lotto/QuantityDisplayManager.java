package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class QuantityDisplayManager {
    public static List<List<Integer>> printPurchaseQuantity(int purchaseQuantity) {
        List<List<Integer>> numbers = new ArrayList<List<Integer>>();
        for (int i = 0; i < purchaseQuantity; i++) {
            List<Integer> randomNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Collections.sort(randomNumbers);
            numbers.add(randomNumbers);
        }
        return numbers;
    }

}
