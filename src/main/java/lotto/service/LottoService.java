package lotto.service;

import static lotto.model.Lotto.LOTTO_PRICE;
import static lotto.model.LottoPrize.PRIZE_2;
import static lotto.model.LottoPurchaseMoney.INVALID_PURCHASE_AMOUNT;
import static lotto.model.LottoStatistic.RATE;
import static lotto.model.LottoWinningNumbers.INVALID_BONUS_NUMBER;

import java.util.stream.Stream;

import lotto.exception.InputCallback;
import lotto.exception.InputExceptionTemplate;
import lotto.model.Lotto;
import lotto.model.LottoMatchResult;
import lotto.model.LottoPrize;
import lotto.model.LottoPrizeCount;
import lotto.model.LottoPurchaseMoney;
import lotto.model.LottoStatistic;
import lotto.model.LottoWinningNumbers;
import lotto.model.Lottos;

public class LottoService {

    private final InputExceptionTemplate inputExceptionTemplate;

    public LottoService(final InputExceptionTemplate inputExceptionTemplate) {
        this.inputExceptionTemplate = inputExceptionTemplate;
    }

    public LottoPurchaseMoney askPurchaseMoney(final InputCallback<LottoPurchaseMoney> callback) {
        return inputByExceptionTemplate(callback, INVALID_PURCHASE_AMOUNT);
    }

    public Lottos buyLottos(final LottoPurchaseMoney amount) {
        int lottoCount = amount.toInt() / LOTTO_PRICE;
        return Lottos.from(
                Stream.generate(Lotto::createRandomNumberLotto)
                .limit(lottoCount)
                .toList()
        );
    }

    public Lotto askWinningNumbers(final InputCallback<Lotto> callback) {
        return inputByExceptionTemplate(callback);
    }

    public LottoWinningNumbers createWinningNumbers(final Lotto numbers, final InputCallback<Integer> callback) {
        return inputByExceptionTemplate(
                () -> {
                    int bonusNumber = inputByExceptionTemplate(callback);
                    return LottoWinningNumbers.of(numbers, bonusNumber);
                },
                INVALID_BONUS_NUMBER
        );
    }

    public LottoStatistic createStatistic(
            final LottoPurchaseMoney lottoPurchaseMoney,
            final Lottos lottos,
            final LottoWinningNumbers lottoWinningNumbers
    ) {
        LottoPrizeCount prizeCount = countLottoPrizes(lottos, lottoWinningNumbers);
        double earningRate = computeEarningRate(lottoPurchaseMoney, prizeCount);
        return LottoStatistic.of(prizeCount, earningRate);
    }

    private LottoPrizeCount countLottoPrizes(final Lottos lottos, final LottoWinningNumbers lottoWinningNumbers) {
        LottoPrizeCount prizeCount = LottoPrizeCount.create();
        lottos.stream()
                .map(lotto -> match(lotto, lottoWinningNumbers))
                .forEach(prizeCount::add);
        return prizeCount;
    }

    private double computeEarningRate(final LottoPurchaseMoney lottoPurchaseMoney, final LottoPrizeCount prizeCount) {
        return sumPrizeMoney(prizeCount) / lottoPurchaseMoney.toInt() * RATE;
    }

    private LottoPrize match(final Lotto lotto, final LottoWinningNumbers lottoWinningNumbers) {
        int matchCount = countMatch(lotto, lottoWinningNumbers);
        boolean hasBonus = isSameMatchCountOfPrize2(matchCount)
                && lotto.stream().anyMatch(number -> number == lottoWinningNumbers.getBonusNumber());
        return LottoPrize.from(new LottoMatchResult(matchCount, hasBonus));
    }

    private double sumPrizeMoney(final LottoPrizeCount prizeCount) {
        return LottoPrize.stream()
                .mapToDouble(prize -> (double) prizeCount.getCountOf(prize) * prize.getPrizeMoney())
                .sum();
    }

    private int countMatch(final Lotto lotto, final LottoWinningNumbers lottoWinningNumbers) {
        return (int) lotto.stream().filter(lottoWinningNumbers::contains).count();
    }

    private boolean isSameMatchCountOfPrize2(final int matchCount) {
        return matchCount == PRIZE_2.getMatchCount();
    }

    private <T> T inputByExceptionTemplate(final InputCallback<T> callback) {
        return inputExceptionTemplate.run(callback, null);
    }

    private <T> T inputByExceptionTemplate(final InputCallback<T> callback, final String message) {
        return inputExceptionTemplate.run(callback, message);
    }
}
