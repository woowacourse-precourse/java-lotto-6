package lotto.service;

import static lotto.model.Lotto.LOTTO_PRICE;
import static lotto.model.LottoPrize.PRIZE_2;
import static lotto.model.LottoStatistic.RATE;

import java.util.List;
import java.util.stream.Stream;

import lotto.exception.InputCallback;
import lotto.exception.InputExceptionTemplate;
import lotto.model.Lotto;
import lotto.model.LottoPrize;
import lotto.model.LottoPrizeCount;
import lotto.model.LottoStatistic;
import lotto.model.Lottos;
import lotto.model.PurchaseAmount;
import lotto.model.WinningNumbers;
import lotto.model.result.LottoMatchResult;

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

    public LottoStatistic createStatisticOf(
            PurchaseAmount purchaseAmount,
            Lottos lottos,
            WinningNumbers winningNumbers
    ) {
        LottoPrizeCount prizeCount = countPrizesOf(lottos, winningNumbers);
        double earningRate = computeEarningRateOf(purchaseAmount, prizeCount);
        return LottoStatistic.of(prizeCount, earningRate);
    }

    private LottoPrizeCount countPrizesOf(Lottos lottos, WinningNumbers winningNumbers) {
        LottoPrizeCount prizeCount = LottoPrizeCount.create();
        lottos.stream()
                .map(lotto -> match(lotto, winningNumbers))
                .forEach(prizeCount::add);
        return prizeCount;
    }

    private double computeEarningRateOf(PurchaseAmount purchaseAmount, LottoPrizeCount prizeCount) {
        return sumPrizeMoneyFrom(prizeCount) / purchaseAmount.toInt() * RATE;
    }

    private LottoPrize match(Lotto lotto, WinningNumbers winningNumbers) {
        int matchCount = (int) lotto.stream().filter(winningNumbers::contains).count();
        boolean hasBonus = isSameMatchCountOfPrize2(matchCount)
                && lotto.stream().anyMatch(number -> number == winningNumbers.getBonusNumber());
        return LottoPrize.from(new LottoMatchResult(matchCount, hasBonus));
    }

    private double sumPrizeMoneyFrom(LottoPrizeCount prizeCount) {
        return LottoPrize.stream()
                .mapToDouble(prize -> (double) prizeCount.getCountOf(prize) * prize.getAmount())
                .sum();
    }

    private boolean isSameMatchCountOfPrize2(final int matchCount) {
        return matchCount == PRIZE_2.getMatchCount();
    }

    private <T> T inputByExceptionTemplate(InputCallback<T> callback) {
        return inputExceptionTemplate.run(callback);
    }
}
