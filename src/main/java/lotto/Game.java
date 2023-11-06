package lotto;

import static lotto.InputReader.*;
import static lotto.MessagePrinter.*;
import static lotto.Util.*;

public class Game {
    public void run() {
        askPurchaseAmount();
        int purchaseAmount = inputPurchaseAmount();
        int purchaseCount = getLottoCount(purchaseAmount);
    }
}
