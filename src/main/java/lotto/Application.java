package lotto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Application {
    public static final int LOTTO_TICKET_PRICE = 1000;

    public static void main(String[] args) {
        int purchaseAmount = UserInput.getPurchaseAmount();

        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < purchaseAmount / LOTTO_TICKET_PRICE; i++) {
            lottos.add(Lotto.generate());
        }

        Output.printLottos(lottos);

        List<Integer> winningNumbers = UserInput.getWinningNumbers();

        int bonusNumber = UserInput.getBonusNumber();

        Map<PrizeTier, Long> results = new HashMap<>();
        for (Lotto lotto : lottos) {
            PrizeTier prizeTier = lotto.checkPrize(winningNumbers, bonusNumber);
            results.put(prizeTier, results.getOrDefault(prizeTier, 0L) + 1);
        }

        Output.printResults(results, purchaseAmount);
    }
}
