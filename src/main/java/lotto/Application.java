package lotto;

import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        int purchaseAmount = InputView.inputPurchaseAmount();
        List<Lotto> lottos = LottoStore.buyLottos(purchaseAmount);

        List<Integer> winningNumbers = InputView.inputWinningNumbers();
        int bonusNumber = InputView.inputBonusNumber();

        Result result = LottoResult.calculateResult(lottos, winningNumbers, bonusNumber);
        OutputView.printLottos(lottos);
        OutputView.printResult(result);
    }
}
