package lotto.domain.repository;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.PurchaseAmount;

public class PurchaseAmountRepository {
    private static final int DEFAULT = 0;

    private static List<PurchaseAmount> purchaseAmounts = new ArrayList<>();

    public static void add(PurchaseAmount purchaseAmount) {
        purchaseAmounts.add(purchaseAmount);
    }

    public static void clear() {
        purchaseAmounts.clear();
    }

    public static int findAmount() {
        return findByIndex(DEFAULT).getAmount();
    }

    private static PurchaseAmount findByIndex(int index) {
        return purchaseAmounts.get(index);
    }
}
