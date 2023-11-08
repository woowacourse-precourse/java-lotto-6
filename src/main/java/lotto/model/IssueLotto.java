package lotto.model;

import java.util.ArrayList;
import java.util.List;
import lotto.view.OutputView;

public class IssueLotto {

    private final List<Lotto> lottoPurchaseHistory = new ArrayList<>();

    public void issue(int numberOfPurchases) {
        OutputView.printNumberOfPurchaseMessage(numberOfPurchases);
        int count = 0;
        while (count < numberOfPurchases) {
            Lotto lotto = new Lotto();
            OutputView.printIssueLottoMessage(lotto.getNumbers());
            this.lottoPurchaseHistory.add(lotto);
            count++;
        }
    }

    public List<Lotto> getLottoPurchaseHistory() {
        return lottoPurchaseHistory;
    }
}
