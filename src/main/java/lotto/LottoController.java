package lotto;

import static lotto.Result.printResult;

import java.util.List;
import lotto.input.LottoWinningNumberInput;
import lotto.input.PurchaseAmountInput;
import lotto.output.GeneratedLottoOutput;

public class LottoController {
    private final PurchaseAmountInput userAmountInput = new PurchaseAmountInput();
    private final LottoWinningNumberInput lottoWinningNumberInput = new LottoWinningNumberInput();

    public void run() {
        Integer purchasedLottoCount = purchaseLotto();

        List<Lotto> lottos = generateLotto(purchasedLottoCount);
        printLottoNumbers(lottos);

        List<Integer> winningNumbers = generateWinningNumbers();
        useLottoService(winningNumbers, lottos);

        printResult(purchasedLottoCount);
    }

    private void useLottoService(List<Integer> winningNumbers, List<Lotto> lottos) {
        LottoService lottoService = new LottoService(winningNumbers, lottos);
        lottoService.compareWinningNumbers();
    }

    private List<Integer> generateWinningNumbers() {
        return lottoWinningNumberInput.createWinningNumbers();
    }

    private Integer purchaseLotto() {
        return userAmountInput.userAmountInput();
    }

    private void printLottoNumbers(List<Lotto> lottos) {
        GeneratedLottoOutput outputView = new GeneratedLottoOutput(lottos);
        outputView.printGeneratedLottos();
    }

    private List<Lotto> generateLotto(Integer purchasedLottoCount) {
        LottoGenerator lottoGenerator = new LottoGenerator(purchasedLottoCount);
        return lottoGenerator.generateLottos();
    }


}
