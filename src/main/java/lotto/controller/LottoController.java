package lotto.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private final InputView inputView;
    private final OutputView outputView;
    private final LottoService lottoService;

    public LottoController(InputView inputView, OutputView outputView, LottoService lottoService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.lottoService = lottoService;
    }

    public void play() {
        outputView.printPurchaseAmount();
        int purchaseAmount = Integer.parseInt(inputView.readPurchaseAmount());

        List<Lotto> lottos = lottoService.createLottos(purchaseAmount);
        outputView.printLottoCount(lottos.size());
        lottos.forEach((lotto -> outputView.printLottoNumbers(lotto.getNumbers())));

        outputView.printLotteryNumbers();
        List<Integer> lotteryNumbers = Arrays.stream(inputView.readLottryNumbers().split(","))
                .mapToInt(Integer::parseInt)
                .boxed()
                .toList();

        outputView.printBonusNumber();
        int bonusNumber = Integer.parseInt(inputView.readBonusNumber());
        boolean hasBonusNumber = false;
        Map<Integer, Integer> result = new HashMap<>();
        for (Lotto lotto : lottos) {
            List<Integer> numbers = lotto.getNumbers();
            int count = 0;
            for (int number : numbers) {
                if (lotteryNumbers.contains(number)) {
                    count++;
                }
                if (lotteryNumbers.contains(bonusNumber)) {
                    hasBonusNumber = true;
                }
            }
            if (count >= 3) {
                result.put(count, result.getOrDefault(count, 0) + 1);
            }
            if (count == 5 && hasBonusNumber) {
                result.put(bonusNumber, result.getOrDefault(bonusNumber, 0) + 1);
            }
        }
        outputView.printResult(result, bonusNumber, purchaseAmount);
    }
}
