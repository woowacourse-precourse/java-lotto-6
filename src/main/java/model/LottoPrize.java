package model;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class LottoPrize {
    PrizeRepository prizeRepository;
    private int price;

    public LottoPrize(LottoWinningNumbers winningNumbers, List<Lotto> lottos) {
        prizeRepository = new PrizeRepository();
        judgePrize(winningNumbers, lottos);
        price = calculateTotalPrice(prizeRepository);
    }

    public int getPrice() {
        return price;
    }

    public HashMap getPrizeRepository() {
        return prizeRepository.getPrizeRepository();
    }

    public int calculateTotalPrice(PrizeRepository prizeRepository) {
        int totalPrice = 0;
        Iterator<Entry<Prize, Integer>> iterator = prizeRepository.getPrizeRepository().entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Prize, Integer> entry = iterator.next();
            totalPrice = totalPrice + calculateOnePrice(entry.getKey(), entry.getValue());
        }
        return totalPrice;
    }

    public int calculateOnePrice(Prize key, int value) {
        return key.getPrice() * value;
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
