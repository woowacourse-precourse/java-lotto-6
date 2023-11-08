package lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoController {

    public void play() {
        int purchaseAmount = InputView.inputPurchaseAmount();
        LottoAmount lottoAmount = new LottoAmount(purchaseAmount);
        int lottoCount = lottoAmount.calculateAmount();

        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            List<Integer> numbers = LottoNumbers.setRandomNumbers();
            lottos.add(new Lotto(numbers));
        }
        OutputView.printLottos(lottos);

        List<Integer> winningNumbers = InputView.inputWinningNumbers();
        int bonusNumber = InputView.inputBonusNumber();
        Lotto winningLotto = new Lotto(winningNumbers);

        Results results = new Results(lottos, winningLotto, bonusNumber, purchaseAmount);

        OutputView.printResults(results);
    }
}
