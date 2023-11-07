package lotto.service;

import static lotto.model.Lotto.LOTTO_PRICE;
import static lotto.model.LottoPrize.PRIZE_2;
import static lotto.model.LottoStatistic.RATE;
import static lotto.model.PurchaseAmount.INVALID_PURCHASE_AMOUNT;
import static lotto.model.WinningNumbers.INVALID_BONUS_NUMBER;

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
import lotto.model.LottoMatchResult;

public class LottoService {

    private final InputExceptionTemplate inputExceptionTemplate;

    public LottoService(final InputExceptionTemplate inputExceptionTemplate) {
        this.inputExceptionTemplate = inputExceptionTemplate;
    }

    public PurchaseAmount askPurchaseAmount(final InputCallback<Integer> callback) {
        return inputByExceptionTemplate(
                () -> {
                    int amount = inputByExceptionTemplate(callback, INVALID_PURCHASE_AMOUNT);
                    return PurchaseAmount.from(amount);
                },
                INVALID_PURCHASE_AMOUNT
        );
    }

    public Lottos buyLottos(final PurchaseAmount amount) {
        int lottoCount = amount.toInt() / LOTTO_PRICE;
        return Lottos.from(Stream.generate(Lotto::create)
                .limit(lottoCount)
                .toList());
    }

    public Lotto askWinningNumbers(final InputCallback<Lotto> callback) {
        return inputByExceptionTemplate(callback);
    }

    public WinningNumbers createWinningNumbers(final Lotto lotto, final InputCallback<Integer> callback) {
        return inputByExceptionTemplate(
                () -> {
                    int bonusNumber = inputByExceptionTemplate(callback);
                    return WinningNumbers.of(lotto, bonusNumber);
                },
                INVALID_BONUS_NUMBER
        );
    }

    public LottoStatistic createStatisticOf(
            final PurchaseAmount purchaseAmount,
            final Lottos lottos,
            final WinningNumbers winningNumbers
    ) {
        LottoPrizeCount prizeCount = countPrizesOf(lottos, winningNumbers);
        double earningRate = computeEarningRateOf(purchaseAmount, prizeCount);
        return LottoStatistic.of(prizeCount, earningRate);
    }

    private LottoPrizeCount countPrizesOf(final Lottos lottos, final WinningNumbers winningNumbers) {
        LottoPrizeCount prizeCount = LottoPrizeCount.create();
        lottos.stream()
                .map(lotto -> match(lotto, winningNumbers))
                .forEach(prizeCount::add);
        return prizeCount;
    }

    private double computeEarningRateOf(final PurchaseAmount purchaseAmount, LottoPrizeCount prizeCount) {
        return sumPrizeMoneyFrom(prizeCount) / purchaseAmount.toInt() * RATE;
    }

    private LottoPrize match(final Lotto lotto, final WinningNumbers winningNumbers) {
        int matchCount = (int) lotto.stream().filter(winningNumbers::contains).count();
        boolean hasBonus = isSameMatchCountOfPrize2(matchCount)
                && lotto.stream()
                        .anyMatch(number -> number == winningNumbers.getBonusNumber());
        return LottoPrize.from(new LottoMatchResult(matchCount, hasBonus));
    }

    private double sumPrizeMoneyFrom(final LottoPrizeCount prizeCount) {
        return LottoPrize.stream()
                .mapToDouble(prize -> (double) prizeCount.getCountOf(prize) * prize.getAmount())
                .sum();
    }

    private boolean isSameMatchCountOfPrize2(final int matchCount) {
        return matchCount == PRIZE_2.getMatchCount();
    }

    private <T> T inputByExceptionTemplate(final InputCallback<T> callback) {
        return inputExceptionTemplate.run(callback);
    }

    private <T> T inputByExceptionTemplate(final InputCallback<T> callback, final String message) {
        return inputExceptionTemplate.run(callback, message);
    }
}
