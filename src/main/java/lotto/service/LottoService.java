package lotto.service;

import static lotto.domain.Lotto.LOTTO_PRICE;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import lotto.domain.Lotto;
import lotto.domain.LottoGenerator;
import lotto.domain.WinningPrize;

public class LottoService {

    private static final int ROUNDS_UP_RATE_OR_RETURN = 10;
    private static final int STANDARD_OF_PERCENT = 100;

    public LottoService() {
    }

    public List<Lotto> createLottos(int lottoPurchaseAmount) {
        int lottoCount = calculateLottoCount(lottoPurchaseAmount);
        return Stream.generate(LottoGenerator::generatorLotto)
                .limit(lottoCount)
                .collect(Collectors.toList());
    }

    public double getRateOfReturn(
            List<Lotto> lottos,
            List<Integer> winningNumbers,
            int bonusNumber
    ) {
        Map<WinningPrize, Integer> winningPrizes = getWinningPrizes(lottos, winningNumbers, bonusNumber);
        int winningPrizeAmount = sumWinningPrizeAmount(winningPrizes);
        int lottoPurchaseAmount = calculateLottoPurchaseAmount(lottos.size());
        double returnOnLotto = calculateReturnOnLotto(winningPrizeAmount, lottoPurchaseAmount);
        return roundSecondPoint(returnOnLotto);
    }

    public Map<WinningPrize, Integer> getWinningPrizes(
            List<Lotto> lottos,
            List<Integer> winningNumbers,
            int bonusNumber
    ) {
        return lottos.stream()
                .map(lotto -> {
                    int winningNumbersCount = checkLotto(lotto, winningNumbers);
                    boolean existBonusNumber = checkBonusNumber(lotto, bonusNumber);
                    return WinningPrize.valueOf(winningNumbersCount, existBonusNumber);
                })
                .collect(
                        Collectors.toMap(winningPrize -> winningPrize, winningPrize -> 1, Integer::sum)
                );
    }

    public double calculateReturnOnLotto(int winningPrizeAmount, int lottoPurchaseAmount) {
        return (double) winningPrizeAmount / lottoPurchaseAmount * STANDARD_OF_PERCENT;
    }

    private int sumWinningPrizeAmount(Map<WinningPrize, Integer> winningPrizes) {
        return winningPrizes.entrySet().stream()
                .mapToInt(entry -> entry.getKey().getWinningPrizeAmount() * entry.getValue())
                .sum();
    }

    private int calculateLottoPurchaseAmount(int lottosSize) {
        return lottosSize * LOTTO_PRICE;
    }

    private double roundSecondPoint(double amount) {
        return (double) Math.round(amount * ROUNDS_UP_RATE_OR_RETURN) / ROUNDS_UP_RATE_OR_RETURN;
    }

    public int checkLotto(Lotto lotto, List<Integer> winningNumbers) {
        return lotto.compareNumbers(winningNumbers);
    }

    public boolean checkBonusNumber(Lotto lotto, int bonusNumber) {
        return lotto.compareNumber(bonusNumber);
    }

    private int calculateLottoCount(int lottoPurchaseAmount) {
        return lottoPurchaseAmount / LOTTO_PRICE;
    }
}
