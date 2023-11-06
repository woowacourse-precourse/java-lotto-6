package model;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

public class LottoPrize {
    HashMap<Prize, Integer> prizeRepository = new LinkedHashMap<>();
    private final static int COUNT = 1;

    public LottoPrize(LottoWinningNumbers winningNumbers, List<Lotto> lottos) {
        judgePrize(winningNumbers, lottos);
    }

    public HashMap getPrize(){
        return prizeRepository;
    }
    public void judgePrize(LottoWinningNumbers winningNumbers, List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            int count = compareTo(winningNumbers, lotto);
            boolean isBonus = hasBonusNumber(winningNumbers, lotto);
            createOrSum(Prize.of(count,isBonus));
        }
    }

    public boolean hasContain(Prize prize) {
        return prizeRepository.containsKey(prize);
    }

    public void createOrSum(Prize prize) {
        if (hasContain(prize)) {
            prizeRepository.put(prize, prizeRepository.get(prize) + COUNT);
            return;
        }
        prizeRepository.put(prize, COUNT);
    }

    public int compareTo(LottoWinningNumbers winningNumbers, Lotto lotto) {
        return winningNumbers.getWinningNumbers().stream()
                .mapToInt(winNumber -> countSameNumber(winNumber, lotto))
                .sum();
    }

    public int countSameNumber(int winNumber, Lotto lotto) {
        return (int) lotto.getNumbers().stream()
                .filter(number -> number == winNumber)
                .count();
    }

    public boolean hasBonusNumber(LottoWinningNumbers winningNumbers, Lotto lotto) {
        return lotto.getNumbers().stream().anyMatch(number -> number == winningNumbers.getBonusNumber());
    }

}
