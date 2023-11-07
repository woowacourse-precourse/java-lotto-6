package lotto.service;

import static lotto.model.Lotto.LOTTO_PRICE;

import java.util.List;
import java.util.stream.Stream;

import lotto.exception.InputCallback;
import lotto.exception.InputExceptionTemplate;
import lotto.model.Lotto;
import lotto.model.LottoStatistic;
import lotto.model.Lottos;
import lotto.model.PurchaseAmount;
import lotto.model.WinningNumbers;

public class LottoService {

    private final InputExceptionTemplate inputExceptionTemplate;

    public LottoService(final InputExceptionTemplate inputExceptionTemplate) {
        this.inputExceptionTemplate = inputExceptionTemplate;
    }

    public PurchaseAmount askPurchaseAmount(InputCallback<Integer> callback) {
        return inputByExceptionTemplate(() -> PurchaseAmount.from(inputByExceptionTemplate(callback)));
    }

    public Lottos buyLottos(PurchaseAmount amount) {
        int lottoCount = amount.toInt() / LOTTO_PRICE;
        return Lottos.from(Stream.generate(Lotto::create)
                .limit(lottoCount)
                .toList());
    }

    public List<Integer> askWinningNumbers(InputCallback<List<Integer>> callback) {
        return inputByExceptionTemplate(callback);
    }

    public int askBonusNumber(InputCallback<Integer> callback) {
        return inputByExceptionTemplate(callback);
    }

    public WinningNumbers createWinningNumbers(List<Integer> numbers, int bonusNumber) {
        return inputByExceptionTemplate(() -> WinningNumbers.of(numbers, bonusNumber));
    }

    public LottoStatistic createStatisticOf(PurchaseAmount amount, Lottos lottos, WinningNumbers winningNumbers) {
        LottoStatistic statistic = new LottoStatistic(amount);
        statistic.match(lottos, winningNumbers);
        return statistic;
    }

    private <T> T inputByExceptionTemplate(InputCallback<T> callback) {
        return inputExceptionTemplate.run(callback);
    }
}
