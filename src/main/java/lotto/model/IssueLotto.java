package lotto.model;

import java.util.ArrayList;
import java.util.List;
import lotto.view.OutputView;

public class IssueLotto {

    public static IssueLotto createIssueLotto() {
        return new IssueLotto();
    }

    public List<Lotto> issue(int numberOfPurchases) {
        OutputView.printNumberOfPurchaseMessage(numberOfPurchases);
        List<Lotto> purchaseHistory = new ArrayList<>();
        int count = 0;
        while (count < numberOfPurchases) {
            Lotto lotto = new Lotto();
            OutputView.printIssueLottoMessage(lotto.getNumbers());
            purchaseHistory.add(lotto);
            count++;
        }
        return purchaseHistory;
    }
}
