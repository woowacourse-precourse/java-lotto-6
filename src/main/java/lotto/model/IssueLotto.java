package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class IssueLotto {

    private final List<Lotto> lottoPurchaseHistory = new ArrayList<>();

    public void issue(int numberOfPurchases) {
        System.out.println(numberOfPurchases + "개를 구매했습니다.");
        int count = 0;
        while (count < numberOfPurchases) {
            Lotto lotto = new Lotto();
            System.out.println(lotto.getNumbers());
            this.lottoPurchaseHistory.add(lotto);
            count++;
        }
    }

    public List<Lotto> getLottoPurchaseHistory() {
        return lottoPurchaseHistory;
    }
}
