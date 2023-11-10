package model;

import java.util.List;

public class LottoPrize {
    PrizeRepository prizeRepository;

    public LottoPrize(LottoWinningNumbers winningNumbers, List<Lotto> lottos) {
        prizeRepository = new PrizeRepository();
        judgePrize(winningNumbers, lottos);
    }

    public int getReword() {
        return prizeRepository.calculateTotalReword();
    }

    public boolean isWinning(Prize prize) {
        return prizeRepository.getPrizeRepository().containsKey(prize);
    }

    public int getWinningCount(Prize prize) {
        return (int) prizeRepository.getPrizeRepository().get(prize);
    }

    public void judgePrize(LottoWinningNumbers lottoWinningNumbers, List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            int count = compareTo(lottoWinningNumbers.getWinningNumbers(), lotto);
            boolean isBonus = hasBonusNumber(lottoWinningNumbers, lotto);
            prizeRepository.add(Prize.of(count, isBonus));
        }
    }

    public int compareTo(List<Integer> winningNumbers, Lotto lotto) {
        return winningNumbers.stream().mapToInt(winNumber -> countSameNumber(winNumber, lotto))
                .sum();
    }

    public int countSameNumber(int winNumber, Lotto lotto) {
        return (int) lotto.getNumbers().stream().filter(number -> number == winNumber).count();
    }

    public boolean hasBonusNumber(LottoWinningNumbers lottoWinningNumbers, Lotto lotto) {
        return lotto.getNumbers().stream().anyMatch(number -> number == lottoWinningNumbers.getBonusNumber());
    }

}
